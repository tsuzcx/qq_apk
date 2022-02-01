package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.google.gson.Gson;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentMixDataManager;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.CommentLinkData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.event.AddCommentLinkEvent;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SubCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.RIJCreateCommentObserver;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkWrapper;
import com.tencent.biz.pubaccount.readinjoy.comment.topic.RIJCommentTopicUtil;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyStringUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJStudyModeUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertController;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertRecordAction.ActionType;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertRecordAction.ActionType.Companion;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyForCanvasFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoCeilingFragment;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelModule;
import com.tencent.biz.pubaccount.readinjoy.push.RIJPushNotifyManager;
import com.tencent.biz.pubaccount.readinjoy.push.RIJPushNotifyManager.Companion;
import com.tencent.biz.pubaccount.readinjoy.readinfo.UserReadUnReadInfoManager;
import com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.IRIJWriteWatchWordShareContract.IView;
import com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJWriteWatchWordModel;
import com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJWriteWatchWordPresenter;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.IVideoPublishCallback;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.ViolaVideoUpdateController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLikeAnimateManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShareController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr.VideoPreDownloadParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreloadReportData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoResumeManager;
import com.tencent.biz.pubaccount.readinjoy.video.playfeedback.PlayFeedbackHelper;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.BridgeInvokeHandler;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.ViolaBridgeApiHelper;
import com.tencent.biz.pubaccount.readinjoy.viola.utils.ViolaBizUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideoView;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.topicvideo.ViolaCommentManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdExposeFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdReqFreshManager;
import com.tencent.biz.pubaccount.util.ActionItem;
import com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2;
import com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2.ShareReport;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.aditem.GdtPreLoader;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.base.MD5;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.commons.Destroyable;
import com.tencent.viola.core.IActivityState;
import com.tencent.viola.core.ViolaDomManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.module.BaseModule;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.context.DOMActionContext;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.utils.ColorParseUtils;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import cooperation.readinjoy.ReadInJoyHelper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class BridgeModule
  extends BaseModule
  implements IRIJWriteWatchWordShareContract.IView, TroopMemberApiClient.Callback, Destroyable, IActivityState
{
  public static final String BRIDGE_EVENT_FULLSCREENSIZECHANGE = "onFullScreenSizeChange";
  public static final String BRIDGE_LOCAL_JS_URL = "https://viola.qq.com/viola_serve/dev";
  public static final String BRIDGE_METHOD_NAME_ONCLICKBUBBLETIPS = "onClickBubbleTips";
  public static final String BRIDGE_METHOD_NAME_REQUESTBUBBLETIPSWORDING = "requestBubbleTipsWording";
  public static final String BRIDGE_PARAMS = "params";
  public static final String BRIDGE_PARAMS_ACCURATE = "accurate";
  public static final String BRIDGE_PARAMS_ACTION = "action";
  public static final String BRIDGE_PARAMS_ANDROIDID = "androidID";
  public static final String BRIDGE_PARAMS_AUTO_DES = "autoDestroy";
  public static final String BRIDGE_PARAMS_BID = "v_bid";
  public static final String BRIDGE_PARAMS_BOTTOM = "bottom";
  public static final String BRIDGE_PARAMS_CHANNELID = "channelId";
  public static final String BRIDGE_PARAMS_DATA_ERROR_CODE = "data_error_code";
  public static final String BRIDGE_PARAMS_FOR_NV = "isForNativeVue";
  public static final String BRIDGE_PARAMS_FROMCALLBACK = "fromCallback";
  public static final String BRIDGE_PARAMS_FROMTYPE = "fromType";
  public static final String BRIDGE_PARAMS_HEIGHT = "height";
  public static final String BRIDGE_PARAMS_IDENTIFIER = "identifier";
  public static final String BRIDGE_PARAMS_IMSI = "imsi";
  public static final String BRIDGE_PARAMS_IS_LAST_INDEX = "is_last_index";
  public static final String BRIDGE_PARAMS_JS = "js";
  public static final String BRIDGE_PARAMS_JUMP_BUNDLE = "jumpBundle";
  public static final String BRIDGE_PARAMS_JUMP_CLIPBOARDINFO = "clipboardInfo";
  public static final String BRIDGE_PARAMS_JUMP_COMMONDATA = "commonData";
  public static final String BRIDGE_PARAMS_JUMP_SCHEMA = "jumpSchema";
  public static final String BRIDGE_PARAMS_JUMP_TYPE = "jumpType";
  public static final String BRIDGE_PARAMS_JUMP_URL = "jumpUrl";
  public static final String BRIDGE_PARAMS_LEFT = "left";
  public static final String BRIDGE_PARAMS_PICURL = "picUrl";
  public static final String BRIDGE_PARAMS_QIMEI = "qimei";
  public static final String BRIDGE_PARAMS_QUA = "qua";
  public static final String BRIDGE_PARAMS_RATE = "rate";
  public static final String BRIDGE_PARAMS_RECOMMEND = "showRecommendReason";
  public static final String BRIDGE_PARAMS_REDPACKET_ID = "redPacketId";
  public static final String BRIDGE_PARAMS_REDPACKET_ID_SM = "redpackid";
  public static final String BRIDGE_PARAMS_RIGHT = "right";
  public static final String BRIDGE_PARAMS_ROWKEY = "rowkey";
  public static final String BRIDGE_PARAMS_SHOULD_SHOW = "shouldShow";
  public static final String BRIDGE_PARAMS_SHOW_NET = "is_show_net_detail";
  public static final String BRIDGE_PARAMS_STATUS = "status";
  public static final String BRIDGE_PARAMS_TID = "v_tid";
  public static final String BRIDGE_PARAMS_TOP = "top";
  public static final String BRIDGE_PARAMS_TYPE = "type";
  public static final String BRIDGE_PARAMS_VID = "vid";
  public static final String BRIDGE_PARAMS_VIDEOFEEDSJS = "VideoFeeds.js";
  public static final String BRIDGE_PARAMS_VIDEO_ATTACH = "autoAttachVideoView";
  public static final String BRIDGE_PARAMS_VIDEO_HANDATTACH = "handAttachVideoView";
  public static final String BRIDGE_PARAMS_VIDEO_TOKEN = "videoToken";
  public static final String BRIDGE_PARAMS_WIDTH = "width";
  public static final String BRIDGE_PARAMS_WORDING = "wording";
  public static final int BRIDGE_TYPE_NORMAL_IN = 100;
  public static final int BRIDGE_TYPE_VIDEO_CLICK = 1;
  public static final int BRIDGE_TYPE_VIDEO_FLAYING = 2;
  public static final String BRIDGE_WX_CIRCLE_SHARE_URL = "wx_circle_share_url";
  public static final String BRIDGE_WX_SHARE_URL = "wx_share_url";
  public static final int CODE_QRCODE = 1;
  public static final byte CODE_SHARE_IMAGE = 18;
  public static final int DOWNLOAD_ACTION_CANCEL = 3;
  public static final int DOWNLOAD_ACTION_PAUSE = 1;
  public static final int DOWNLOAD_ACTION_RESUME = 2;
  public static final int DOWNLOAD_STAET_PAUSE = 5;
  public static final int DOWNLOAD_STATE_CANCEL = 3;
  public static final int DOWNLOAD_STATE_ERROR = 4;
  public static final int DOWNLOAD_STATE_FINISH = 2;
  public static final int DOWNLOAD_STATE_INSTALL_SUCCESS = 6;
  public static final int DOWNLOAD_STATE_UPDATE = 1;
  public static final String ENABLE = "enable";
  public static final String KEY_PREDOWNLOAD_MGR = "predownload";
  public static final String KEY_VIDEO_PLAY_POSITION = "viola_video_play_position";
  public static String MODULE_NAME = "bridge";
  public static final byte OPENCAMERA = 112;
  public static final byte OPENIMG = 111;
  public static final int PHOTO_CLIP_BANNER_H = 200;
  public static final int PHOTO_CLIP_BANNER_W = 360;
  public static final int PHOTO_CLIP_HEAD_SIZE = 360;
  public static final int PHOTO_CLIP_SIZE = 640;
  public static final int PHOTO_TAGGET_BANNER_W = 750;
  public static final int PHOTO_TARGET_BANNER_H = 416;
  public static final int PHOTO_TARGET_HEAD_SIZE = 160;
  public static final byte REQ_CODE_AQ_INVITE_FRIEND = 119;
  public static final byte REQ_CODE_COMMENT_EDITOR = 117;
  public static final byte REQ_CODE_COMMENT_EDITOR_NATIVE = 126;
  public static final byte REQ_CODE_DELIVER = 113;
  public static final byte REQ_CODE_DELIVER_QUESTION = 122;
  public static final byte REQ_CODE_DELIVER_TOPIC_PIC = 121;
  public static final byte REQ_CODE_DELIVER_UGC = 114;
  public static final byte REQ_CODE_SELECT_AND_UPLOAD_AVATAR = 118;
  public static final byte REQ_CODE_SHARE_QZONE = 125;
  public static final byte REQ_CODE_UGC_ADD_VIDEO = 124;
  public static final byte REQ_CODE_UGC_CAMERA_CAPTURE = 116;
  public static final byte REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM = 115;
  public static final byte REQ_CODE_UGC_MANAGE_COLUMN = 123;
  public static final String TAG = "BridgeModule";
  public static GdtAppReceiver mGdtAppReceiver = null;
  private static HashMap<String, Long> sConsumeCardMap = new HashMap();
  private static WeakReference<Activity> sShareEntryActivity;
  public static String shareCallBackId;
  public static String shareCallBackName;
  public static int shareCallBackType;
  public static String ssoTimeOutRecordStr = "";
  private BridgeInvokeHandler bridgeInvokeHandler = new BridgeInvokeHandler(this);
  private Map<Long, String> columnToUploadCallbackMap = new HashMap();
  private String commentCallbaclId;
  private RIJBiuAndCommentMixDataManager dataManager;
  private ActionSheetHelper mActionSheetHelper;
  private ViolaBridgeApiHelper mBridgeApiHelper = null;
  private String mCallBack = null;
  private TroopMemberApiClient mClient = null;
  private ViolaCommentManager mCommentManager;
  private int mCommentSeq = -1;
  private DownloadListener mDownloadListener;
  private EventHelper mEventHelper;
  private VideoFeedsLikeAnimateManager mLikeAnimateManager;
  private Map<String, Object> mObjectMap = new ArrayMap();
  private SparseArray<BridgeModule.ResultAction> mResultActionMap = new SparseArray();
  protected ShareActionSheetBuilder mShareActionSheet = null;
  public ReadInJoyShareHelperV2 mShareHelper;
  public QShareUtils mShareUtils = new QShareUtils();
  private int mState = -100;
  private String mUploadCallBack;
  private VideoPreDownloadMgr mVideoPreDownloadMgr = new VideoPreDownloadMgr();
  private int maxSize = 204800;
  private int minDuration = 5;
  private INetInfoHandler netInfoHandler;
  private long preTime = 0L;
  public RIJWriteWatchWordPresenter rijWatchWordPresenter;
  public String shareToFriendUin = "";
  public String shareToFriendUinName = "";
  public int shareToFriendUinType = 0;
  private String shareVideoCallBackId;
  private RIJUgcVideoPublishManager.IVideoPublishCallback videoPublishCallback = new BridgeModule.14(this);
  private ViolaVideoUpdateController violaVideoUpdateController;
  
  public BridgeModule()
  {
    this.mObjectMap.put("predownload", this.mVideoPreDownloadMgr);
    this.rijWatchWordPresenter = new RIJWriteWatchWordPresenter(new RIJWriteWatchWordModel());
    this.rijWatchWordPresenter.a(this);
    registerActivityResultAction();
  }
  
  @JSMethod
  public static void addRowkeyToConsumeMap(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      sConsumeCardMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
    }
  }
  
  private void arouseReadInJoyNativeCommentView(JSONObject paramJSONObject, int paramInt)
  {
    ViolaBizUtils.a(paramJSONObject, paramInt);
  }
  
  private int bindCommentCallback(String paramString)
  {
    if (this.mClient == null)
    {
      this.mClient = TroopMemberApiClient.a();
      this.mClient.a();
    }
    this.commentCallbaclId = paramString;
    return this.mClient.a(this);
  }
  
  private void callJsDeliverResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    BridgeModuleHelper.a(this, paramInt1, paramInt2, paramIntent);
  }
  
  private AnchorData createAnchorData(JSONObject paramJSONObject)
  {
    return ViolaBizUtils.a(paramJSONObject);
  }
  
  private ArticleInfo createArticleInfo(JSONObject paramJSONObject)
  {
    return ViolaBizUtils.a(paramJSONObject);
  }
  
  private static RIJFeedsInsertAction createRIJFeedsInsertAction(int paramInt1, int paramInt2)
  {
    return new RIJFeedsInsertAction(RIJFeedsDynamicInsertRecordAction.ActionType.Companion.b(paramInt1), paramInt2, 0, 0);
  }
  
  private TopGestureLayout createTopGestureLayout()
  {
    Object localObject = getActivity();
    if (localObject == null) {
      return null;
    }
    localObject = new TopGestureLayout((Context)localObject);
    ((TopGestureLayout)localObject).setOnFlingGesture(new BridgeModule.18(this));
    return localObject;
  }
  
  private void dealBiuResult(int paramInt, Intent paramIntent)
  {
    BridgeModuleHelper.b(this, paramInt, paramIntent);
  }
  
  private void dealForwardResult(int paramInt, Intent paramIntent)
  {
    JSONObject localJSONObject;
    if (paramInt == -1)
    {
      if ((getViolaInstance() != null) && (getViolaInstance().getActivity() != null))
      {
        ForwardUtils.a((QQAppInterface)ReadInJoyUtils.a(), getViolaInstance().getActivity(), getViolaInstance().getActivity(), paramIntent, null);
        QLog.d("BridgeModule", 2, "share video card to aio success。");
      }
      paramIntent = new JSONObject();
      try
      {
        paramIntent.put("type", shareCallBackType);
        paramIntent.put("action", shareCallBackName);
        paramIntent.put("fromCallback", 1);
        if (!TextUtils.isEmpty(shareCallBackId)) {
          invokeCallJS(shareCallBackId, paramIntent);
        }
        paramIntent = this.shareVideoCallBackId;
        if (TextUtils.isEmpty(paramIntent)) {
          return;
        }
      }
      catch (JSONException paramIntent)
      {
        for (;;)
        {
          QLog.e("BridgeModule", 1, "processClick callback error=" + paramIntent.getMessage());
        }
        localJSONObject = new JSONObject();
      }
    }
    try
    {
      localJSONObject.put("result", 1);
      invokeCallJS(paramIntent, localJSONObject);
      paramIntent = ReadInJoyShareHelperV2.ShareReport.a;
      if (paramInt == -1)
      {
        bool = true;
        paramIntent.a(bool);
        return;
      }
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        QLog.e("BridgeModule", 2, "do call share friend back error:" + paramIntent.getMessage());
        continue;
        boolean bool = false;
      }
    }
  }
  
  private void dealInviteFriendResult(Intent paramIntent)
  {
    BridgeModuleHelper.a(this, paramIntent);
  }
  
  private void dealRedPacketMVResult(int paramInt, Intent paramIntent)
  {
    BridgeModuleHelper.a(this, paramInt, paramIntent);
  }
  
  private void dealShareQzoneResult(int paramInt)
  {
    boolean bool = true;
    Object localObject;
    if (paramInt == -1) {
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("type", shareCallBackType);
      ((JSONObject)localObject).put("action", shareCallBackName);
      ((JSONObject)localObject).put("fromCallback", 1);
      if (!TextUtils.isEmpty(shareCallBackId)) {
        invokeCallJS(shareCallBackId, localObject);
      }
      localObject = ReadInJoyShareHelperV2.ShareReport.a;
      if (paramInt == -1)
      {
        ((ReadInJoyShareHelperV2.ShareReport)localObject).a(bool);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("BridgeModule", 1, "processClick callback error=" + localJSONException.getMessage());
        continue;
        bool = false;
      }
    }
  }
  
  private void dealTopicPicResult(int paramInt, Intent paramIntent)
  {
    if (paramIntent == null) {
      if (paramInt != 0) {}
    }
    do
    {
      String str;
      do
      {
        do
        {
          do
          {
            try
            {
              paramIntent = new JSONObject();
              paramIntent.put("retCode", 1);
              paramIntent.put("msg", HardCodeUtil.a(2131701266));
              if (QLog.isColorLevel()) {
                QLog.d("BridgeModule", 2, "selectAndUploadAvatar  result:" + ReadInJoyDeliverUGCActivity.a(paramIntent.toString()));
              }
              if (!TextUtils.isEmpty(this.mUploadCallBack)) {
                invokeCallJS(this.mUploadCallBack, paramIntent);
              }
              return;
            }
            catch (Exception paramIntent)
            {
              while (!QLog.isColorLevel()) {}
              QLog.e("BridgeModule", 2, QLog.getStackTraceString(paramIntent));
              return;
            }
            str = paramIntent.getStringExtra("callbackId");
          } while (TextUtils.isEmpty(str));
          if (paramInt != -1) {
            break;
          }
          localObject = paramIntent.getBundleExtra("Bundle");
        } while (localObject == null);
        paramInt = ((Bundle)localObject).getInt("retCode");
        paramIntent = ((Bundle)localObject).getString("url");
        Object localObject = ((Bundle)localObject).getString("msg");
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("retCode", paramInt);
          localJSONObject.put("url", paramIntent);
          localJSONObject.put("msg", localObject);
          if (QLog.isColorLevel()) {
            QLog.d("BridgeModule", 2, "selectAndUploadAvatar  result:" + ReadInJoyDeliverUGCActivity.a(localJSONObject.toString()));
          }
          invokeCallJS(str, localJSONObject);
          return;
        }
        catch (Exception paramIntent) {}
      } while (!QLog.isColorLevel());
      QLog.e("BridgeModule", 2, QLog.getStackTraceString(paramIntent));
      return;
      try
      {
        paramIntent = new JSONObject();
        paramIntent.put("retCode", -1);
        if (QLog.isColorLevel()) {
          QLog.d("BridgeModule", 2, " selectAndUploadAvatar result:" + paramIntent.toString());
        }
        invokeCallJS(str, paramIntent);
        return;
      }
      catch (Exception paramIntent) {}
    } while (!QLog.isColorLevel());
    QLog.e("BridgeModule", 2, QLog.getStackTraceString(paramIntent));
  }
  
  private void doOnVideoPublish(UgcVideo paramUgcVideo)
  {
    QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
    QLog.i("BridgeModule", 1, "onPublish, title =" + paramUgcVideo.title);
    if (localQQAppInterface == null) {}
    String str;
    do
    {
      return;
      str = (String)this.columnToUploadCallbackMap.get(Long.valueOf(0L));
      if ((str != null) && (!str.isEmpty())) {
        RIJUgcVideoPublishManager.a(localQQAppInterface).a(0L, new BridgeModule.15(this, str));
      }
      str = (String)this.columnToUploadCallbackMap.get(Long.valueOf(paramUgcVideo.columnId));
    } while ((str == null) || (str.isEmpty()));
    RIJUgcVideoPublishManager.a(localQQAppInterface).a(paramUgcVideo.columnId, new BridgeModule.16(this, paramUgcVideo, str));
  }
  
  private void doPostShowComment(FragmentActivity paramFragmentActivity, VVideoView paramVVideoView, View paramView, ViewGroup paramViewGroup, JSONObject paramJSONObject, boolean paramBoolean)
  {
    FragmentManager localFragmentManager1 = null;
    Object localObject = null;
    int i;
    int j;
    if (this.mCommentManager == null)
    {
      if ((getViolaInstance() != null) && ((getViolaInstance().getFragment() instanceof ViolaFragment)) && (((ViolaFragment)getViolaInstance().getFragment()).isSuspension()) && (((ViolaFragment)getViolaInstance().getFragment()).getCommonSuspensionGestureLayout().d()))
      {
        localFragmentManager1 = paramFragmentActivity.getSupportFragmentManager();
        i = ((ViolaFragment)getViolaInstance().getFragment()).getCommonSuspensionGestureLayout().a();
        if (paramBoolean) {
          localObject = createTopGestureLayout();
        }
        this.mCommentManager = new ViolaCommentManager(paramFragmentActivity, localFragmentManager1, i, paramViewGroup, (TopGestureLayout)localObject);
      }
    }
    else
    {
      if ((getViolaInstance() != null) && ((getViolaInstance().getFragment() instanceof ViolaFragment)))
      {
        paramFragmentActivity = (ViolaFragment)getViolaInstance().getFragment();
        if ((paramFragmentActivity.isSuspension()) && (paramFragmentActivity.getCommonSuspensionGestureLayout() != null)) {
          paramFragmentActivity.getCommonSuspensionGestureLayout().f();
        }
      }
      this.mCommentManager.a(new BridgeModule.12(this));
      paramFragmentActivity = createArticleInfo(paramJSONObject);
      paramViewGroup = createAnchorData(paramJSONObject);
      float f = ViolaUtils.getFloat(paramJSONObject.optString("offset"), Float.valueOf(0.0F));
      this.mCommentManager.a(paramView, f);
      j = ColorParseUtils.parseColor(paramJSONObject.optString("backgroundColor"), -16777216);
      if (paramJSONObject.optInt("directComment") != 1) {
        break label379;
      }
      i = 1;
      label263:
      if (i == 0) {
        break label385;
      }
      this.mCommentManager.b(paramVVideoView, paramView, paramFragmentActivity, paramViewGroup, j);
      label282:
      if (paramJSONObject.optInt("closeTaretViewInOriginSuperView") != 1) {
        break label413;
      }
    }
    label385:
    label413:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.mCommentManager.a(paramBoolean);
      QLog.d("BridgeModule", 1, "openComment, hashCode: " + hashCode());
      return;
      FragmentManager localFragmentManager2 = paramFragmentActivity.getSupportFragmentManager();
      localObject = localFragmentManager1;
      if (paramBoolean) {
        localObject = createTopGestureLayout();
      }
      this.mCommentManager = new ViolaCommentManager(paramFragmentActivity, localFragmentManager2, 0, paramViewGroup, (TopGestureLayout)localObject);
      break;
      label379:
      i = 0;
      break label263;
      if (paramViewGroup != null) {
        paramViewGroup.jdField_b_of_type_Boolean = true;
      }
      this.mCommentManager.a(paramVVideoView, paramView, paramFragmentActivity, paramViewGroup, j);
      break label282;
    }
  }
  
  private void ensureEventHelper()
  {
    if (this.mEventHelper == null) {
      this.mEventHelper = new EventHelper(this);
    }
  }
  
  @Nullable
  private Activity getActivity()
  {
    ViolaInstance localViolaInstance = getViolaInstance();
    if (localViolaInstance == null) {
      return null;
    }
    return localViolaInstance.getActivity();
  }
  
  private void getRecentUserFace(String paramString, boolean paramBoolean)
  {
    Object localObject2 = (QQAppInterface)ReadInJoyUtils.a();
    Object localObject1 = getActivity();
    if (localObject1 == null)
    {
      QLog.e("BridgeModule", 1, "getRecentUserFace activity null");
      return;
    }
    localObject1 = VideoFeedsHelper.a((QQAppInterface)localObject2, (Activity)localObject1);
    if (paramBoolean) {}
    for (localObject1 = VideoFeedsHelper.b((List)localObject1);; localObject1 = VideoFeedsHelper.a((List)localObject1))
    {
      localObject2 = ((IQQAvatarService)((QQAppInterface)localObject2).getRuntimeService(IQQAvatarService.class, "")).getInstance((AppInterface)localObject2);
      if (localObject1 == null) {
        break;
      }
      localObject2 = ((IFaceDecoder)localObject2).getBitmapFromCache(1, ((RecentUser)localObject1).uin);
      if (localObject2 == null) {
        break;
      }
      localObject2 = ReadInJoyUtils.a(Bitmap.createScaledBitmap((Bitmap)localObject2, 128, 128, false));
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("uin", ((RecentUser)localObject1).uin);
        localJSONObject.put("imageBase64", localObject2);
        invokeCallJS(paramString, localJSONObject);
        return;
      }
      catch (Throwable paramString)
      {
        QLog.e("BridgeModule", 1, paramString.getMessage());
        return;
      }
    }
  }
  
  private void getUploadingVideoList(@NotNull QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    ViolaBizUtils.a(this, paramQQAppInterface, paramLong, paramString);
  }
  
  private void handleCommentEditorNativeResult(int paramInt, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    String str2 = paramIntent.getStringExtra("arg_callback");
    if (paramInt != -1)
    {
      handleCommentEditorNativeResultWhenCancel(str2);
      return;
    }
    String str1 = paramIntent.getStringExtra("arg_result_json");
    for (;;)
    {
      Object localObject2;
      CommentData localCommentData;
      int i;
      try
      {
        localObject2 = new JSONObject(str1);
        if (localObject2 == null) {
          break;
        }
        JSONArray localJSONArray = ((JSONObject)localObject2).optJSONArray("linkList");
        if (localJSONArray == null) {
          break label320;
        }
        Object localObject1 = new BridgeModule.9(this).getType();
        localObject1 = (List)new Gson().fromJson(localJSONArray.toString(), (Type)localObject1);
        paramInt = ((JSONObject)localObject2).optInt("biuAfterComment");
        localCommentData = new CommentData();
        RIJCommentTopicUtil.a((JSONObject)localObject2, localCommentData);
        i = ((JSONObject)localObject2).optInt("feedsType");
        localObject2 = new BridgeModule.10(this, (JSONObject)localObject2, localCommentData, localJSONArray, str2);
        paramIntent = paramIntent.getParcelableExtra("comment_create_data");
        if ((paramIntent instanceof FirstCommentCreateData))
        {
          paramIntent = (FirstCommentCreateData)paramIntent;
          paramIntent.a(localCommentData.commentContent);
          paramIntent.a(localCommentData.commentRptDataList);
          paramIntent.b((List)localObject1);
          localObject1 = RIJCommentNetworkWrapper.a;
          if (paramInt == 1)
          {
            bool = true;
            ((RIJCommentNetworkWrapper)localObject1).a(paramIntent, (RIJCommentNetworkHelper.RIJCreateCommentObserver)localObject2, str1, i, false, bool);
            return;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("BridgeModule", 1, "handleCommentEditorNativeResult result parse error.");
        localObject2 = null;
        continue;
        bool = false;
        continue;
      }
      if (!(paramIntent instanceof SubCommentCreateData)) {
        break;
      }
      paramIntent = (SubCommentCreateData)paramIntent;
      paramIntent.d(localCommentData.commentContent);
      paramIntent.a(localCommentData.commentRptDataList);
      paramIntent.b(localJSONException);
      RIJCommentNetworkWrapper localRIJCommentNetworkWrapper = RIJCommentNetworkWrapper.a;
      if (paramInt == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localRIJCommentNetworkWrapper.a(paramIntent, (RIJCommentNetworkHelper.RIJCreateCommentObserver)localObject2, str1, i, false, bool);
        return;
      }
      label320:
      localRIJCommentNetworkWrapper = null;
    }
  }
  
  private void handleCommentEditorNativeResultWhenCancel(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("retCode", -1);
      localJSONObject.put("commentId", 0);
      invokeCallJS(paramString, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("BridgeModule", 1, "handleCommentEditorNativeResult put user cancel result error.");
      }
    }
  }
  
  private void handleCommentEditorResult(int paramInt, Intent paramIntent)
  {
    if (paramIntent == null) {}
    String str;
    do
    {
      return;
      str = paramIntent.getStringExtra("arg_callback");
    } while (TextUtils.isEmpty(str));
    if (paramInt == 1699)
    {
      if (this.dataManager != null) {
        this.dataManager.a();
      }
      this.dataManager = new RIJBiuAndCommentMixDataManager();
      UiApiPlugin.a(paramIntent, this.dataManager, str, new BridgeModule.8(this));
      return;
    }
    paramIntent = paramIntent.getStringExtra("arg_result_json");
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramIntent))
        {
          paramIntent = new JSONObject(paramIntent);
          if (paramInt != -1) {
            break label175;
          }
          paramIntent.put("retCode", 0);
          if (QLog.isColorLevel()) {
            QLog.d("BridgeModule", 2, "ReadInJoyDeliverUGCActivity.replaceUrlInLog result:" + ReadInJoyDeliverUGCActivity.a(paramIntent.toString()));
          }
          invokeCallJS(str, paramIntent);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e("BridgeModule", 1, "handleCommentEditorResult json put data exception.");
        return;
      }
      paramIntent = new JSONObject();
      continue;
      label175:
      paramIntent.put("retCode", -1);
    }
  }
  
  private void handleResultFromAddVideo(int paramInt, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramInt != 3)) {}
    String str;
    do
    {
      return;
      str = paramIntent.getStringExtra("arg_callback");
    } while (TextUtils.isEmpty(str));
    JSONObject localJSONObject = new JSONObject();
    try
    {
      paramInt = paramIntent.getIntExtra("key_column_id", 0);
      localJSONObject.put("errorCode", 0);
      localJSONObject.put("errorMsg", "");
      localJSONObject.put("topicId", paramInt);
      invokeJS(str, localJSONObject);
      return;
    }
    catch (JSONException paramIntent)
    {
      QLog.d("BridgeModule", 1, "ReadInJoyAddUgcVideo fail ! " + paramIntent.toString());
    }
  }
  
  private void handleResultFromManageColumn(int paramInt, Intent paramIntent)
  {
    int i = 0;
    if ((paramIntent == null) || ((paramInt != 1) && (paramInt != 2))) {}
    String str;
    do
    {
      return;
      str = paramIntent.getStringExtra("arg_callback");
    } while (TextUtils.isEmpty(str));
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (paramIntent.getBooleanExtra("key_publish_result", false))
        {
          paramInt = i;
          localJSONObject.put("errCode", paramInt);
          paramIntent = (ColumnInfo)paramIntent.getParcelableExtra("key_column_info");
          if (paramIntent != null) {
            localJSONObject.put("topicId", paramIntent.columnID);
          }
          invokeJS(str, localJSONObject);
          return;
        }
      }
      catch (JSONException paramIntent)
      {
        QLog.d("BridgeModule", 1, "ReadInJoyManageUgcColumn fail ! " + paramIntent.toString());
        return;
      }
      paramInt = -1;
    }
  }
  
  @JSMethod
  public static boolean isRowkeyHasConsume(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return sConsumeCardMap.containsKey(paramString);
  }
  
  private void registerActivityResultAction()
  {
    this.mResultActionMap.put(114, new BridgeModule.DeliverUGCAction(this));
    this.mResultActionMap.put(115, new BridgeModule.DeliverUGCAction(this));
    this.mResultActionMap.put(116, new BridgeModule.DeliverUGCAction(this));
    this.mResultActionMap.put(122, new BridgeModule.DeliverUGCAction(this));
    this.mResultActionMap.put(113, new BridgeModule.BiuAction(this));
    this.mResultActionMap.put(119, new BridgeModule.InviteFriendAction(this));
    this.mResultActionMap.put(118, new BridgeModule.TopicPicAction(this));
    this.mResultActionMap.put(121, new BridgeModule.TopicPicAction(this));
    this.mResultActionMap.put(117, new BridgeModule.CommentEditorAction(this));
    this.mResultActionMap.put(126, new BridgeModule.CommentEditorNativeAction(this));
    this.mResultActionMap.put(21, new BridgeModule.ForwardAction(this));
    this.mResultActionMap.put(123, new BridgeModule.ManageColumnAction(this));
    this.mResultActionMap.put(124, new BridgeModule.AddVideoAction(this));
    this.mResultActionMap.put(101, new BridgeModule.RedPacketMVAction(this));
    this.mResultActionMap.put(125, new BridgeModule.ShareQzoneAction(this));
  }
  
  private void responseUploadingVideoList(long paramLong, @NotNull List<UgcVideo> paramList, String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    ViolaBizUtils.a(this, paramLong, paramList, paramString1, paramInt, paramString2, paramBoolean);
  }
  
  public static void saveImageToLocal(String paramString)
  {
    BridgeModuleHelper.b(paramString);
  }
  
  public static void unRegisterReceiver()
  {
    if ((BaseApplicationImpl.getContext() != null) && (mGdtAppReceiver != null))
    {
      BaseApplicationImpl.getContext().unregisterReceiver(mGdtAppReceiver);
      mGdtAppReceiver = null;
    }
  }
  
  @JSMethod
  public void adFreshAddAdId(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      AdReqFreshManager.a().a(paramJSONObject.optString("scene"), Long.valueOf(paramJSONObject.optLong("adId")));
      invokeCallJS(paramString, new JSONObject());
      return;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("BridgeModule", 1, paramJSONObject.getMessage());
    }
  }
  
  @JSMethod
  public void adFreshFlushSceneAds(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      AdReqFreshManager.a().a(paramJSONObject.optString("scene"));
      AdExposeFreshManager.a().a(paramJSONObject.optString("scene"));
      invokeCallJS(paramString, new JSONObject());
      return;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("BridgeModule", 1, paramJSONObject.getMessage());
    }
  }
  
  @JSMethod
  public void adFreshGetExposeRate(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("value", AdReqFreshManager.a().a());
      invokeCallJS(paramString, localJSONObject);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("BridgeModule", 1, paramString.getMessage());
    }
  }
  
  @JSMethod
  public void adFreshGetRequestAdIds(String paramString)
  {
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject();
      Object localObject = AdReqFreshManager.a().a();
      JSONArray localJSONArray = new JSONArray();
      if ((localObject != null) && (((Set)localObject).size() > 0))
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localJSONArray.put((Long)((Iterator)localObject).next());
        }
      }
      localJSONObject.put("value", localJSONArray);
    }
    catch (Throwable paramString)
    {
      QLog.e("BridgeModule", 1, paramString.getMessage());
      return;
    }
    invokeCallJS(paramString, localJSONObject);
  }
  
  @JSMethod
  public void adFreshIsExposed(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      boolean bool = AdExposeFreshManager.a().a(paramJSONObject.optLong("adId"));
      paramJSONObject = new JSONObject();
      if (bool) {}
      for (int i = 1;; i = 0)
      {
        paramJSONObject.put("isExpose", i);
        invokeCallJS(paramString, paramJSONObject);
        return;
      }
      return;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("BridgeModule", 1, paramJSONObject.getMessage());
    }
  }
  
  @JSMethod
  public void adFreshRemoveAdId(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      AdReqFreshManager.a().a(Long.valueOf(paramJSONObject.optLong("adId")));
      invokeCallJS(paramString, new JSONObject());
      return;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("BridgeModule", 1, paramJSONObject.getMessage());
    }
  }
  
  @JSMethod
  public void adGetMemoryCache(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      invokeCallJS(paramString, MemoryCacheManager.a(paramJSONObject.optString("key")));
      return;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("BridgeModule", 1, paramJSONObject.getMessage());
    }
  }
  
  @JSMethod
  public void adSetMemoryCache(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      boolean bool = MemoryCacheManager.a(paramJSONObject.optString("key"), paramJSONObject.optJSONObject("obj"));
      paramJSONObject = new JSONObject();
      if (bool) {}
      for (int i = 0;; i = 1)
      {
        paramJSONObject.put("code", i);
        invokeCallJS(paramString, paramJSONObject);
        return;
      }
      return;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("BridgeModule", 1, paramJSONObject.getMessage());
    }
  }
  
  @JSMethod
  public void addColorBall()
  {
    ViolaFragment localViolaFragment = getViolaFragment();
    if (localViolaFragment == null) {
      return;
    }
    localViolaFragment.addToColorBall();
  }
  
  public void addEventListener(JSONObject paramJSONObject, String paramString)
  {
    ensureEventHelper();
    this.mEventHelper.a(paramJSONObject, paramString);
  }
  
  @JSMethod
  public void addFavorite(JSONObject paramJSONObject)
  {
    ViolaBizUtils.b(this, paramJSONObject);
  }
  
  @JSMethod
  public void addVideoFeedsUserOperation(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    int i;
    float f;
    do
    {
      return;
      i = ViolaUtils.getInt(paramJSONObject.opt("type"));
      f = ViolaUtils.getFloat(paramJSONObject.opt("progress"));
      paramJSONObject = ViolaUtils.getString(paramJSONObject.opt("rowKey"), "");
      RIJFeedsDynamicInsertController.a.a(paramJSONObject, createRIJFeedsInsertAction(i, (int)f), 6);
    } while (!QLog.isColorLevel());
    QLog.d("BridgeModule", 2, "operation: " + i + ", rowKey: " + paramJSONObject + ", watchProgress: " + f);
  }
  
  public void addViolaPageByUrl(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.t(this, paramJSONObject, paramString);
  }
  
  public void arouseReadInJoyNativeCommentView(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      arouseReadInJoyNativeCommentView(paramJSONObject, bindCommentCallback(paramString));
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("BridgeModule", 1, "arouseReadInJoyNativeCommentView Exception:", paramJSONObject);
    }
  }
  
  public void batchCheckUpdate(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.A(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void c2sReport(JSONObject paramJSONObject)
  {
    BridgeModuleHelper.g(paramJSONObject);
  }
  
  public void callback(Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getString("action");
    if (QLog.isColorLevel()) {
      QLog.d("BridgeModule", 2, "callback: action=" + (String)localObject1);
    }
    if ("onCommentSend".equals(localObject1)) {}
    do
    {
      Object localObject2;
      Object localObject3;
      try
      {
        localObject1 = paramBundle.getString("commentId", "");
        localObject2 = paramBundle.getString("rowKey", "");
        localObject3 = paramBundle.getString("commentContent", "");
        int i = paramBundle.getInt("firstLevelComment");
        paramBundle = new JSONObject();
        paramBundle.put("commentId", localObject1);
        paramBundle.put("rowKey", localObject2);
        paramBundle.put("commentContent", localObject3);
        paramBundle.put("firstLevelComment", i + 1 + "");
        paramBundle.put("result", "success");
        paramBundle.put("type", "onCommentSend");
        invokeCallJS(this.commentCallbaclId, paramBundle);
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      if ("onCommentLike".equals(localObject1)) {
        try
        {
          localObject1 = paramBundle.getString("commentId", "");
          localObject2 = paramBundle.getString("rowKey", "");
          paramBundle = paramBundle.getString("likeStatus", "");
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("commentId", localObject1);
          ((JSONObject)localObject3).put("rowKey", localObject2);
          ((JSONObject)localObject3).put("likeStatus", paramBundle);
          ((JSONObject)localObject3).put("result", "success");
          ((JSONObject)localObject3).put("type", "onCommentLike");
          invokeCallJS(this.commentCallbaclId, localObject3);
          return;
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
          return;
        }
      }
      if ("onCommentDelete".equals(localObject1)) {
        try
        {
          localObject1 = paramBundle.getString("commentId", "");
          paramBundle = paramBundle.getString("rowKey", "");
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("commentId", localObject1);
          ((JSONObject)localObject2).put("rowKey", paramBundle);
          ((JSONObject)localObject2).put("result", "success");
          ((JSONObject)localObject2).put("type", "onCommentDelete");
          invokeJS(this.commentCallbaclId, (JSONObject)localObject2);
          return;
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
          return;
        }
      }
    } while (!"onPanelClose".equals(localObject1));
    try
    {
      paramBundle = paramBundle.getString("rowKey", "");
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("rowKey", paramBundle);
      ((JSONObject)localObject1).put("result", "success");
      ((JSONObject)localObject1).put("type", "onPanelClose");
      invokeJS(this.commentCallbaclId, (JSONObject)localObject1);
      if (this.mClient != null)
      {
        this.mClient.a(this.mCommentSeq);
        this.mCommentSeq = -1;
      }
      QLog.d("BridgeModule", 1, "onPanelClose, hashCode: " + hashCode());
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public void canOpenPage(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.p(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void cancelColorBall()
  {
    ViolaFragment localViolaFragment = getViolaFragment();
    if (localViolaFragment == null) {
      return;
    }
    localViolaFragment.removeColorBall();
  }
  
  @JSMethod
  public void cancelUploadingVideo(JSONObject paramJSONObject, String paramString)
  {
    ViolaBizUtils.b(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void cancelVideoPreDownload()
  {
    if (this.mVideoPreDownloadMgr != null) {
      this.mVideoPreDownloadMgr.d();
    }
  }
  
  @JSMethod
  public void channelRequestSign(String paramString1, String paramString2)
  {
    paramString1 = MD5.a("QQ_" + ReadInJoyUtils.a() + "_" + paramString1).toLowerCase();
    if (getViolaInstance() != null) {
      ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), getModuleName(), "callback", paramString2, paramString1, true);
    }
  }
  
  @JSMethod
  public void chooseVideoAddToTopic(JSONObject paramJSONObject, String paramString)
  {
    ViolaBizUtils.e(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void clearMessageBoxData()
  {
    ReadInJoyLogicEngineEventDispatcher.a().f();
  }
  
  @JSMethod
  public void closeTopicVideoComment()
  {
    this.mCommentManager.c();
  }
  
  @JSMethod
  public void colorBallState(String paramString)
  {
    ViolaFragment localViolaFragment = getViolaFragment();
    if (localViolaFragment == null) {
      return;
    }
    int i = localViolaFragment.colorBallState();
    try
    {
      invokeJS(paramString, new JSONObject().put("state", i));
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("BridgeModule", 1, paramString.getMessage());
    }
  }
  
  @JSMethod
  public void deleteArticleByRowKeys(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    do
    {
      return;
      paramJSONObject = paramJSONObject.optJSONArray("rowKeys");
    } while (paramJSONObject == null);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONObject.length())
    {
      String str = ViolaUtils.getString(paramJSONObject.opt(i), "");
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(str);
      }
      i += 1;
    }
    RIJFeedsDynamicInsertController.a.a(localArrayList);
  }
  
  public void destroy()
  {
    if (this.mShareHelper != null)
    {
      this.mShareHelper.b();
      this.mShareHelper = null;
    }
    if (this.mEventHelper != null)
    {
      this.mEventHelper.a();
      this.mEventHelper = null;
    }
    if (this.mClient != null) {
      this.mClient.b();
    }
    if (this.mShareUtils != null) {
      this.mShareUtils.a();
    }
    if (this.mCommentManager != null) {
      this.mCommentManager.d();
    }
    this.mCommentManager = null;
    if (this.netInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.netInfoHandler);
    }
    if (this.mVideoPreDownloadMgr != null)
    {
      this.mVideoPreDownloadMgr.d();
      this.mVideoPreDownloadMgr.a();
      this.mVideoPreDownloadMgr = null;
    }
    if (this.violaVideoUpdateController != null) {
      this.violaVideoUpdateController.b();
    }
    QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
    if (localQQAppInterface != null) {
      RIJUgcVideoPublishManager.a(localQQAppInterface).b(this.videoPublishCallback);
    }
    if (QLog.isColorLevel()) {
      QLog.d("BridgeModule", 2, "destroy by instance");
    }
    if (this.dataManager != null) {
      this.dataManager.a();
    }
    if (this.mLikeAnimateManager != null) {
      this.mLikeAnimateManager.a();
    }
  }
  
  public void detailLog(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.v(this, paramJSONObject, paramString);
  }
  
  public void directSocialShare(JSONObject paramJSONObject, int paramInt)
  {
    Activity localActivity = getActivity();
    if (localActivity == null) {
      return;
    }
    this.mShareUtils.a(paramJSONObject, paramInt, localActivity, "", 0, "");
  }
  
  public void disableSwitcher()
  {
    BridgeModuleHelper.a(this);
  }
  
  @JSMethod
  public void dismissColorBall()
  {
    ColorNoteSmallScreenUtil.a(BaseApplicationImpl.getContext(), 2, false);
  }
  
  public void dispatchEvent(JSONObject paramJSONObject, String paramString)
  {
    ensureEventHelper();
    this.mEventHelper.c(paramJSONObject, paramString);
  }
  
  public void doSelectAndUploadAvatar(JSONObject paramJSONObject, String paramString)
  {
    this.mUploadCallBack = paramString;
    BridgeModuleHelper.a(paramJSONObject, paramString, getViolaInstance().getActivity());
  }
  
  public void doUploadTopicPic(JSONObject paramJSONObject, String paramString)
  {
    this.mUploadCallBack = paramString;
    BridgeModuleHelper.b(paramJSONObject, paramString, getViolaInstance().getActivity());
  }
  
  public void downloadApk(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("apkUrl"))))
    {
      DownloadInfo localDownloadInfo = new DownloadInfo();
      String str = paramJSONObject.optString("apkUrl");
      localDownloadInfo.d = str;
      localDownloadInfo.e = paramJSONObject.optString("packageName", null);
      localDownloadInfo.m = "biz_src_feeds_kandianads";
      localDownloadInfo.h = paramJSONObject.optString("via");
      if (this.mDownloadListener == null) {
        this.mDownloadListener = new BridgeModule.DownloadListenerImp(this, str, paramString);
      }
      DownloadManagerV2.a().a(this.mDownloadListener);
      localDownloadInfo.a();
      DownloadManagerV2.a().b(localDownloadInfo);
    }
  }
  
  public void downloadApkAction(JSONObject paramJSONObject)
  {
    BridgeModuleHelper.c(paramJSONObject);
  }
  
  public void downloadApkCancel(JSONObject paramJSONObject)
  {
    BridgeModuleHelper.f(paramJSONObject);
  }
  
  public void downloadApkPause(JSONObject paramJSONObject)
  {
    BridgeModuleHelper.d(paramJSONObject);
  }
  
  public void downloadApkResume(JSONObject paramJSONObject)
  {
    BridgeModuleHelper.e(paramJSONObject);
  }
  
  public void downloadApp(String paramString)
  {
    BridgeModuleHelper.p(this, paramString);
  }
  
  public void downloadForGooglePlay(String paramString)
  {
    BridgeModuleHelper.a(paramString);
  }
  
  @JSMethod
  public void dwellTimeMillisReport(JSONObject paramJSONObject)
  {
    BridgeModuleHelper.h(paramJSONObject);
  }
  
  @JSMethod
  public void enableColorNoteSwipeRight(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      QLog.e("BridgeModule", 1, "[enableColorNoteSwipeRight]: jsonObject is null");
      return;
    }
    ViolaFragment localViolaFragment = getViolaFragment();
    if (localViolaFragment == null)
    {
      QLog.e("BridgeModule", 1, "[enableColorNoteSwipeRight]: Fragment is null");
      return;
    }
    localViolaFragment.enableColorNoteSwipeRight(paramJSONObject.optBoolean("enable", true));
  }
  
  @JSMethod
  public void enableFlingGesture(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    ViolaFragment localViolaFragment;
    do
    {
      return;
      localViolaFragment = getViolaFragment();
    } while (localViolaFragment == null);
    localViolaFragment.enableFlingGesture(paramJSONObject.optBoolean("enable", true));
  }
  
  @JSMethod
  public void exeUGCPrivilegeLike(String paramString)
  {
    if ((getViolaInstance() != null) && (getViolaInstance().getActivity() != null)) {
      RIJUserLevelModule.a().a(getViolaInstance().getActivity(), 3, new BridgeModule.17(this, paramString));
    }
  }
  
  public void feedsRefreshMessage(JSONObject paramJSONObject)
  {
    UserReadUnReadInfoManager.a().a(paramJSONObject);
  }
  
  @JSMethod
  public void fetchReadInJoyAccountInfoList(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.D(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void fetchReadInJoyUserInfo(String paramString)
  {
    ViolaBizUtils.a(this, paramString);
  }
  
  public void fireGetLocation(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.C(this, paramJSONObject, paramString);
  }
  
  @JSMethod(uiThread=false)
  public void getALDConfig(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.l(this, paramJSONObject, paramString);
  }
  
  public void getBiuTriggerType(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.g(this, paramJSONObject, paramString);
  }
  
  public void getCUKingStatus(String paramString)
  {
    BridgeModuleHelper.k(this, paramString);
  }
  
  public void getClientInfo(String paramString)
  {
    BridgeModuleHelper.j(this, paramString);
  }
  
  @JSMethod
  public void getCreateTopicPermission(JSONObject paramJSONObject, String paramString)
  {
    getReadInJoyUgcPermission(paramJSONObject, paramString, 1);
  }
  
  protected JSONObject getDeviceInfo()
  {
    return BridgeModuleHelper.b();
  }
  
  @JSMethod(uiThread=false)
  public void getDeviceInfo(String paramString)
  {
    getDeviceInfo(paramString, false);
  }
  
  public void getDeviceInfo(String paramString, boolean paramBoolean)
  {
    BridgeModuleHelper.b(this, paramString, paramBoolean);
  }
  
  public void getDownloadApkState(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.u(this, paramJSONObject, paramString);
  }
  
  public JSONObject getFailInvokeObj(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("code", -1);
      localJSONObject.put("errorText", paramString);
      return localJSONObject;
    }
    catch (JSONException paramString) {}
    return localJSONObject;
  }
  
  @Nullable
  public Object getField(String paramString)
  {
    return this.mObjectMap.get(paramString);
  }
  
  @JSMethod(uiThread=false)
  public void getGdtDeviceInfo(String paramString, JSONObject paramJSONObject)
  {
    getGdtDeviceInfo(paramString, paramJSONObject, true);
  }
  
  public void getGdtDeviceInfo(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    BridgeModuleHelper.a(this, paramString, paramJSONObject, paramBoolean);
  }
  
  public void getGdtInfo(String paramString)
  {
    BridgeModuleHelper.l(this, paramString);
  }
  
  @JSMethod
  public void getMotiveAd(String paramString, JSONObject paramJSONObject)
  {
    BridgeModuleHelper.a(this, paramString, paramJSONObject);
  }
  
  @JSMethod(uiThread=false)
  public void getNetType(String paramString)
  {
    getNetType(paramString, false);
  }
  
  public void getNetType(String paramString, boolean paramBoolean)
  {
    int i = HttpUtil.getNetWorkType();
    if (QLog.isColorLevel()) {
      QLog.d("BridgeModule", 2, "getNetType,netType:" + i);
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("result", i);
      label55:
      if (paramBoolean) {
        invokeCallJS(paramString, localJSONObject);
      }
      for (;;)
      {
        vaNetworkChange(paramString);
        return;
        ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), getModuleName(), "callback", paramString, localJSONObject, true);
      }
    }
    catch (JSONException localJSONException)
    {
      break label55;
    }
  }
  
  public void getNetworkInfo(String paramString, boolean paramBoolean)
  {
    BridgeModuleHelper.c(this, paramString, paramBoolean);
  }
  
  public void getPerformance(String paramString)
  {
    ViolaInstance localViolaInstance = getViolaInstance();
    if (localViolaInstance == null) {
      return;
    }
    invokeCallJS(paramString, localViolaInstance.getMainPerformance());
  }
  
  protected void getReadInJoyUgcPermission(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    ViolaBizUtils.a(this, paramJSONObject, paramString, paramInt);
  }
  
  @JSMethod
  public void getRecentFriendInfo(String paramString)
  {
    getRecentUserFace(paramString, false);
  }
  
  @JSMethod
  public void getRecentGroupInfo(String paramString)
  {
    getRecentUserFace(paramString, true);
  }
  
  public void getRecommendFlag(String paramString)
  {
    BridgeModuleHelper.m(this, paramString);
  }
  
  public JSONObject getSuccInvokeObj(Object paramObject)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("code", 0);
      localJSONObject.put("errorText", "");
      if (paramObject != null)
      {
        localJSONObject.put("data", paramObject);
        return localJSONObject;
      }
      localJSONObject.put("data", new JSONObject());
      return localJSONObject;
    }
    catch (JSONException paramObject) {}
    return localJSONObject;
  }
  
  @JSMethod
  public void getUploadVideoPermission(JSONObject paramJSONObject, String paramString)
  {
    getReadInJoyUgcPermission(paramJSONObject, paramString, 2);
  }
  
  @JSMethod
  public void getUploadingVideoInfo(JSONObject paramJSONObject, String paramString)
  {
    QLog.i("BridgeModule", 1, "getUploadingVideoInfo,callback=" + paramString + ", content=" + paramJSONObject.toString());
    int i = paramJSONObject.optInt("topicId");
    this.columnToUploadCallbackMap.put(Long.valueOf(i), paramString);
    paramJSONObject = RIJQQAppInterfaceUtil.a();
    if (paramJSONObject != null) {
      RIJUgcVideoPublishManager.a(paramJSONObject).a(this.videoPublishCallback);
    }
    if (this.violaVideoUpdateController == null) {
      this.violaVideoUpdateController = new ViolaVideoUpdateController(new BridgeModule.13(this, i, paramString), 500L);
    }
    this.violaVideoUpdateController.a();
  }
  
  protected JSONObject getUserInfo()
  {
    return BridgeModuleHelper.a();
  }
  
  @JSMethod(uiThread=false)
  public void getUserInfo(String paramString)
  {
    getUserInfo(paramString, false);
  }
  
  public void getUserInfo(String paramString, boolean paramBoolean)
  {
    BridgeModuleHelper.a(this, paramString, paramBoolean);
  }
  
  @JSMethod
  public void getUserLiveStatus(String paramString1, String paramString2)
  {
    ViolaBizUtils.a(this, paramString1, paramString2);
  }
  
  @JSMethod
  public void getVideoFrameInfo(JSONObject paramJSONObject, String paramString)
  {
    ViolaBizUtils.a(this, paramJSONObject, paramString);
  }
  
  public ViolaFragment getViolaFragment()
  {
    Object localObject = getViolaInstance();
    if (localObject == null) {
      return null;
    }
    localObject = ((ViolaInstance)localObject).getFragment();
    if ((localObject instanceof ViolaFragment)) {
      return (ViolaFragment)localObject;
    }
    return null;
  }
  
  @JSMethod
  public void handleClick(JSONObject paramJSONObject)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    try
    {
      GdtLog.b("BridgeModule", paramJSONObject.toString());
      JSONObject localJSONObject = paramJSONObject.getJSONObject("options");
      boolean bool1 = localJSONObject.getBoolean("reportForClick");
      boolean bool2 = localJSONObject.getBoolean("appAutoDownload");
      boolean bool3 = localJSONObject.optBoolean("videoCeilingSupported", false);
      boolean bool4 = localJSONObject.optBoolean("videoCeilingSupportedIfInstalled", false);
      boolean bool5 = localJSONObject.optBoolean("videoSpliceSupported", false);
      int i = localJSONObject.optInt("clickPosition", 0);
      long l = localJSONObject.optLong("videoStartPositionMillis", 0L);
      Object localObject = localJSONObject.optJSONObject("mediaViewLocationRect");
      Rect localRect = new Rect();
      if (localObject != null)
      {
        int j = ((JSONObject)localObject).optInt("left", 0);
        int k = ((JSONObject)localObject).optInt("top", 0);
        int m = ((JSONObject)localObject).optInt("right", 0);
        int n = ((JSONObject)localObject).optInt("bottom", 0);
        localRect.left = j;
        localRect.top = k;
        localRect.right = m;
        localRect.bottom = n;
      }
      paramJSONObject = (qq_ad_get.QQAdGetRsp.AdInfo)GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramJSONObject.getJSONObject("adInfo"));
      localObject = new GdtHandler.Params();
      ((GdtHandler.Params)localObject).jdField_c_of_type_Int = 7;
      ((GdtHandler.Params)localObject).jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localBaseActivity);
      ((GdtHandler.Params)localObject).jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(paramJSONObject);
      ((GdtHandler.Params)localObject).jdField_a_of_type_Boolean = bool1;
      ((GdtHandler.Params)localObject).jdField_b_of_type_Boolean = bool2;
      if (mGdtAppReceiver == null)
      {
        mGdtAppReceiver = new GdtAppReceiver();
        mGdtAppReceiver.register(BaseApplicationImpl.getContext());
      }
      ((GdtHandler.Params)localObject).jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(mGdtAppReceiver);
      ((GdtHandler.Params)localObject).jdField_a_of_type_JavaLangClass = ReadInJoyVideoCeilingFragment.class;
      ((GdtHandler.Params)localObject).jdField_c_of_type_Boolean = bool3;
      ((GdtHandler.Params)localObject).d = bool4;
      ((GdtHandler.Params)localObject).e = bool5;
      ((GdtHandler.Params)localObject).jdField_a_of_type_AndroidGraphicsRect = localRect;
      ((GdtHandler.Params)localObject).jdField_b_of_type_JavaLangClass = ReadInJoyForCanvasFragment.class;
      ((GdtHandler.Params)localObject).jdField_b_of_type_Int = i;
      ((GdtHandler.Params)localObject).jdField_a_of_type_AndroidOsBundle = new Bundle();
      ((GdtHandler.Params)localObject).jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
      bool1 = localJSONObject.optBoolean("videoPlayForced", false);
      ((GdtHandler.Params)localObject).jdField_a_of_type_Long = l;
      ((GdtHandler.Params)localObject).f = bool1;
      GdtHandler.a((GdtHandler.Params)localObject);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      GdtLog.d("BridgeModule", "handleJsCallRequest error", paramJSONObject);
    }
  }
  
  @JSMethod
  public void hasApp(String paramString1, String paramString2)
  {
    hasApp(paramString1, paramString2, false);
  }
  
  public void hasApp(String paramString1, String paramString2, boolean paramBoolean)
  {
    BridgeModuleHelper.a(this, paramString1, paramString2, paramBoolean);
  }
  
  public void hasRedPacketSharePermission(String paramString)
  {
    BridgeModuleHelper.b(this, paramString);
  }
  
  @JSMethod
  public void hideFollowAlertView(JSONObject paramJSONObject, String paramString)
  {
    boolean bool = paramJSONObject.optBoolean("animated", true);
    RIJPushNotifyManager.a.a().a(bool, "MATCH_ALL_UIN");
  }
  
  @JSMethod
  public void hideNavigationBar()
  {
    Object localObject = getActivity();
    if (localObject == null) {
      return;
    }
    localObject = ((Activity)localObject).getWindow().getDecorView();
    ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() | 0x1B02);
  }
  
  @JSMethod
  public void hideTopicVideoComment(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("ref", "");
    ViolaDomManager localViolaDomManager = ViolaSDKManager.getInstance().getDomManager();
    if (getViolaInstance() != null)
    {
      localViolaDomManager.getDomContext(getViolaInstance().getInstanceId()).getComponent(paramJSONObject);
      this.mCommentManager.c();
    }
  }
  
  @JSMethod
  public void insertCommentLink(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = paramJSONObject.optJSONObject("linkData");
    paramJSONObject = (BaseCommentData.CommentLinkData)new Gson().fromJson(paramJSONObject.toString(), BaseCommentData.CommentLinkData.class);
    getActivity();
    SimpleEventBus.getInstance().dispatchEvent(new AddCommentLinkEvent(paramJSONObject));
    paramJSONObject = new JSONObject();
    try
    {
      paramJSONObject.put("errCode", 0);
      invokeJS(paramString, paramJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  @JSMethod
  public void invoke(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null) {}
    String str1;
    String str2;
    do
    {
      return;
      str1 = paramJSONObject.optString("ns");
      str2 = paramJSONObject.optString("method");
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
      {
        invokeErrorCallJS(paramString, HardCodeUtil.a(2131701277));
        QLog.d("BridgeModule", 1, "ns or method not exists");
        return;
      }
      QLog.d("BridgeModule", 1, "ns: " + str1 + " method: " + str2 + " params: " + paramJSONObject.toString());
    } while (this.bridgeInvokeHandler.a(str1, str2, paramJSONObject, paramString));
    invokeErrorCallJS(paramString, "ns:" + str1 + HardCodeUtil.a(2131701273) + str2 + HardCodeUtil.a(2131701268));
  }
  
  public void invokeCallJS(String paramString, Object paramObject)
  {
    if (!TextUtils.isEmpty(paramString)) {
      invokeJS(paramString, getSuccInvokeObj(paramObject));
    }
  }
  
  public void invokeErrorCallJS(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      invokeJS(paramString1, getFailInvokeObj(paramString2));
    }
  }
  
  public void invokeJS(String paramString, JSONObject paramJSONObject)
  {
    if (getViolaInstance() != null) {
      ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), getModuleName(), "callback", paramString, paramJSONObject, true);
    }
  }
  
  public void isCached(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.B(this, paramJSONObject, paramString);
  }
  
  public void isInkanDianTab(String paramString)
  {
    BridgeModuleHelper.a(this, paramString);
  }
  
  @JSMethod(uiThread=false)
  public void isKindCard(String paramString)
  {
    BridgeModuleHelper.o(this, paramString);
  }
  
  public void isMobileQQ(String paramString)
  {
    BridgeModuleHelper.n(this, paramString);
  }
  
  public void isNightMode(String paramString)
  {
    BridgeModuleHelper.i(this, paramString);
  }
  
  public boolean onActivityBack()
  {
    if ((this.mCommentManager != null) && (this.mCommentManager.b()))
    {
      this.mCommentManager.a();
      return true;
    }
    return super.onActivityBack();
  }
  
  public void onActivityDestroy()
  {
    destroy();
    this.rijWatchWordPresenter.a();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.mCommentManager != null) {
      this.mCommentManager.a(paramInt1, paramInt2, paramIntent);
    }
    BridgeModule.ResultAction localResultAction = (BridgeModule.ResultAction)this.mResultActionMap.get(paramInt1);
    if (localResultAction != null) {
      localResultAction.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    AbstractGifImage.resumeAll();
    Activity localActivity = getActivity();
    if ((localActivity != null) && (localActivity.getIntent() != null) && (this.mCommentSeq != -1))
    {
      if (localActivity.getIntent().getBundleExtra("bundle") == null)
      {
        Bundle localBundle = new Bundle();
        localActivity.getIntent().putExtra("bundle", localBundle);
      }
      localActivity.getIntent().getBundleExtra("bundle").putInt("seq", this.mCommentSeq);
    }
  }
  
  @JSMethod
  public void onColumnSubscribeStatusChange(JSONObject paramJSONObject)
  {
    ViolaBizUtils.a(paramJSONObject);
  }
  
  public boolean onFlingLToR()
  {
    if ((this.mCommentManager != null) && (this.mCommentManager.b()))
    {
      this.mCommentManager.a();
      return true;
    }
    return false;
  }
  
  public void openAccountPageMore(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.b(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void openAddVideoView(JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.optInt("topicId");
    String str = paramJSONObject.optString("title");
    int j = paramJSONObject.optInt("fromType");
    paramJSONObject = new ColumnInfo();
    paramJSONObject.columnID = i;
    paramJSONObject.title = str;
    RIJUgcUtils.a(BaseActivity.sTopActivity, paramJSONObject, j, paramString, 124);
  }
  
  @JSMethod
  public void openApp(String paramString)
  {
    openApp(paramString, null, null);
  }
  
  public void openApp(String paramString1, String paramString2, String paramString3)
  {
    BridgeModuleHelper.a(this, paramString1, paramString2, paramString3);
  }
  
  @JSMethod
  public void openCreateTopicView(String paramString)
  {
    RIJUgcUtils.a(BaseActivity.sTopActivity, paramString, 123);
  }
  
  @JSMethod
  public void openEditTopicView(JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.optInt("topicId");
    String str1 = paramJSONObject.optString("iconUrl");
    String str2 = paramJSONObject.optString("title");
    String str3 = paramJSONObject.optString("intro");
    int j = paramJSONObject.optInt("submitPermission");
    RIJUgcUtils.a(BaseActivity.sTopActivity, i, str1, str2, str3, j, paramString, 123);
  }
  
  @JSMethod(uiThread=true)
  public void openLevelDialog(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = getViolaInstance();
    Activity localActivity = null;
    if (localObject != null) {
      localActivity = ((ViolaInstance)localObject).getActivity();
    }
    localObject = localActivity;
    if (localActivity == null) {
      localObject = BaseActivity.sTopActivity;
    }
    RIJJumpUtils.a((Context)localObject, paramJSONObject, new BridgeModule.11(this, paramString));
  }
  
  @JSMethod
  public void openMiniApp(String paramString, JSONObject paramJSONObject)
  {
    BridgeModuleHelper.b(this, paramString, paramJSONObject);
  }
  
  public void openPage(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.c(paramJSONObject, paramString);
  }
  
  public void openPrivateLetter()
  {
    BridgeModuleHelper.a(getViolaInstance().getContext());
  }
  
  @JSMethod
  public void openTopicVideoComment(JSONObject paramJSONObject, String paramString)
  {
    Object localObject3 = null;
    Object localObject2 = paramJSONObject.optString("ref", "");
    boolean bool = paramJSONObject.optBoolean("isRaiseBarrage");
    Object localObject4 = ViolaSDKManager.getInstance().getDomManager();
    Object localObject1 = getViolaInstance();
    if ((localObject1 != null) && ((((ViolaInstance)localObject1).getActivity() instanceof FragmentActivity)))
    {
      localObject2 = ((ViolaDomManager)localObject4).getDomContext(getViolaInstance().getInstanceId()).getComponent((String)localObject2);
      localObject4 = (FragmentActivity)((ViolaInstance)localObject1).getActivity();
    }
    for (;;)
    {
      try
      {
        this.mCommentSeq = bindCommentCallback(paramString);
        if (((FragmentActivity)localObject4).getIntent().getBundleExtra("bundle") == null)
        {
          paramString = new Bundle();
          ((FragmentActivity)localObject4).getIntent().putExtra("bundle", paramString);
        }
        ((FragmentActivity)localObject4).getIntent().getBundleExtra("bundle").putInt("seq", this.mCommentSeq);
        if (localObject2 != null)
        {
          paramString = ((VComponent)localObject2).getHostView();
          if (paramString == null) {
            continue;
          }
          localObject1 = paramString.findViewWithTag("VVideoView");
          if (!(localObject1 instanceof VVideoView)) {
            break label289;
          }
          localObject1 = (VVideoView)localObject1;
          localObject2 = localObject3;
          if (bool)
          {
            localObject2 = localObject3;
            if (getViolaInstance() != null)
            {
              localObject2 = localObject3;
              if ((getViolaInstance().getRootView() instanceof ViewGroup)) {
                localObject2 = (ViewGroup)getViolaInstance().getRootView();
              }
            }
          }
          doPostShowComment((FragmentActivity)localObject4, (VVideoView)localObject1, paramString, (ViewGroup)localObject2, paramJSONObject, ViolaUtils.getBoolean(paramJSONObject.opt("enableFlingGesture")));
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("BridgeModule", 2, paramJSONObject, new Object[0]);
        return;
      }
      paramString = null;
      continue;
      localObject1 = null;
      continue;
      label289:
      localObject1 = null;
    }
  }
  
  @JSMethod
  public void openUrl(String paramString, Bundle paramBundle)
  {
    BridgeModuleHelper.a(paramString, paramBundle);
  }
  
  public void openUrl(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.n(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void openUrlByJumpInfo(JSONObject paramJSONObject)
  {
    ViolaBizUtils.a(this, paramJSONObject);
  }
  
  @JSMethod
  public void openVideo(JSONObject paramJSONObject)
  {
    BridgeModuleHelper.a(paramJSONObject);
  }
  
  public void pageVisibility(String paramString)
  {
    BridgeModuleHelper.d(this, paramString);
  }
  
  @JSMethod
  public void pauseUploadingVideo(JSONObject paramJSONObject, String paramString)
  {
    ViolaBizUtils.d(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void performLikeAnimation(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    if (this.mLikeAnimateManager == null) {
      this.mLikeAnimateManager = new VideoFeedsLikeAnimateManager(getActivity(), 1);
    }
    float f1 = FlexConvertUtils.converPxByViewportToRealPx(paramJSONObject.opt("pageX"), 750);
    float f2 = FlexConvertUtils.converPxByViewportToRealPx(paramJSONObject.opt("pageY"), 750);
    this.mLikeAnimateManager.a(f1, f2);
  }
  
  public void popBack(String paramString)
  {
    BridgeModuleHelper.e(this, paramString);
  }
  
  @JSMethod(uiThread=true)
  public void popFromBottomStateChange(String paramString)
  {
    if ((getViolaInstance() != null) && ((getViolaInstance().getFragment() instanceof ViolaFragment))) {
      ((ViolaFragment)getViolaInstance().getFragment()).setViolaGestureLayoutListener(new BridgeModule.3(this, paramString));
    }
  }
  
  @JSMethod
  public void preLoadAfterAdLoaded(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      GdtLog.a("BridgeModule", paramJSONObject.toString());
      paramJSONObject = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramJSONObject.getJSONObject("adInfo")));
      GdtPreLoader.a().a(paramJSONObject);
      invokeCallJS(paramString, "sucess");
      return;
    }
    catch (Exception paramJSONObject)
    {
      GdtLog.d("BridgeModule", "handleJsCallRequest", paramJSONObject);
      invokeCallJS(paramString, "error");
    }
  }
  
  @JSMethod
  public void preloadLikeAnimation()
  {
    if (this.mLikeAnimateManager == null) {
      this.mLikeAnimateManager = new VideoFeedsLikeAnimateManager(getActivity(), 1);
    }
  }
  
  public void removeEventListener(JSONObject paramJSONObject, String paramString)
  {
    ensureEventHelper();
    this.mEventHelper.b(paramJSONObject, paramString);
  }
  
  public void reportT(JSONObject paramJSONObject)
  {
    BridgeModuleHelper.b(paramJSONObject);
  }
  
  public void reportVideoShareClick(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, String paramString3, String paramString4, String paramString5)
  {
    BridgeModuleHelper.a(this, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramString3, paramString4, paramString5);
  }
  
  public void requestRedPacketContentShareToast(String paramString)
  {
    BridgeModuleHelper.c(this, paramString);
  }
  
  public void resetSatusBarBlackStyle()
  {
    Fragment localFragment = getViolaInstance().getFragment();
    if ((localFragment != null) && ((localFragment instanceof ViolaFragment))) {
      ((ViolaFragment)localFragment).setStatusBarFontColor(Boolean.valueOf(false), true);
    }
  }
  
  public void resetSatusBarWhiteStyle()
  {
    Fragment localFragment = getViolaInstance().getFragment();
    if ((localFragment != null) && ((localFragment instanceof ViolaFragment))) {
      ((ViolaFragment)localFragment).setStatusBarFontColor(Boolean.valueOf(false), true);
    }
  }
  
  @JSMethod
  public void resumeUploadingVideo(JSONObject paramJSONObject, String paramString)
  {
    ViolaBizUtils.c(this, paramJSONObject, paramString);
  }
  
  public void saveImage(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.x(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void savePlayPosition(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("videoTimeMap");
    if (paramJSONObject != null)
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        VideoResumeManager.a.a(str, paramJSONObject.optLong(str));
      }
    }
  }
  
  public void selectAndInviteFriend(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.b(paramJSONObject, paramString);
  }
  
  public void sendRequest(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null) {}
    Object localObject;
    JSONObject localJSONObject;
    String str1;
    QQAppInterface localQQAppInterface;
    String str2;
    do
    {
      for (;;)
      {
        return;
        try
        {
          localObject = paramJSONObject.getString("host");
          localJSONObject = paramJSONObject.getJSONObject("data");
          str1 = paramJSONObject.getString("cmd");
          localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
          if ((localJSONObject != null) && (!TextUtils.isEmpty((CharSequence)localObject)) && (localQQAppInterface != null) && (!TextUtils.isEmpty(str1)))
          {
            str2 = localJSONObject.toString();
            if (ViolaUtils.getBoolean(paramJSONObject.optString("disableFrequency"))) {
              break label201;
            }
            if (this.preTime == 0L) {
              break label194;
            }
            if (System.currentTimeMillis() - this.preTime >= this.minDuration * 1000) {
              break label157;
            }
            paramJSONObject = new JSONObject();
            paramJSONObject.put("cret", 1);
            invokeCallJS(paramString, paramJSONObject);
            return;
          }
        }
        catch (Exception paramJSONObject) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("BridgeModule", 2, "send request error!");
    return;
    label157:
    if (str2.getBytes().length > this.maxSize)
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("cret", 2);
      invokeCallJS(paramString, paramJSONObject);
      return;
      label194:
      this.preTime = System.currentTimeMillis();
    }
    label201:
    String[] arrayOfString = ((String)localObject).split("\\.");
    int i = arrayOfString.length;
    paramJSONObject = "";
    i -= 1;
    for (;;)
    {
      if (i >= 0)
      {
        localObject = paramJSONObject + arrayOfString[i];
        paramJSONObject = (JSONObject)localObject;
        if (i != 0) {
          paramJSONObject = (String)localObject + "_";
        }
      }
      else
      {
        localObject = new NewIntent(localQQAppInterface.getApplication(), ProtoServlet.class);
        ((NewIntent)localObject).putExtra("cmd", "MQUpdateSvc_" + paramJSONObject + ".web." + str1);
        paramJSONObject = new WebSsoBody.WebSsoRequestBody();
        paramJSONObject.type.set(0);
        paramJSONObject.data.set(str2);
        ((NewIntent)localObject).putExtra("data", paramJSONObject.toByteArray());
        if (str1.equals("JsOidbProxy.oidb_0x6cf_4")) {
          ViolaLogUtils.d("BridgeModule", "test dataObj dataObj:" + localJSONObject.toString());
        }
        ((NewIntent)localObject).setObserver(new BridgeModule.7(this, paramString, str1, localQQAppInterface));
        if (localQQAppInterface == null) {
          break;
        }
        localQQAppInterface.startServlet((NewIntent)localObject);
        return;
      }
      i -= 1;
    }
  }
  
  @JSMethod
  public void setColorBallData(JSONObject paramJSONObject)
  {
    ViolaFragment localViolaFragment = getViolaFragment();
    if (localViolaFragment == null) {
      return;
    }
    localViolaFragment.setColorBallData(paramJSONObject);
  }
  
  public void setNavBar(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.q(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void setNavBtn(JSONObject paramJSONObject, String paramString)
  {
    setNavBtnWithFragment(paramJSONObject, paramString, null);
  }
  
  public void setNavBtnWithFragment(JSONObject paramJSONObject, String paramString, Fragment paramFragment)
  {
    BridgeModuleHelper.a(this, paramJSONObject, paramString, paramFragment);
  }
  
  @JSMethod(uiThread=true)
  public void setPresentPopFromBottom(int paramInt)
  {
    boolean bool = true;
    ViolaFragment localViolaFragment;
    if ((getViolaInstance() != null) && ((getViolaInstance().getFragment() instanceof ViolaFragment)))
    {
      localViolaFragment = (ViolaFragment)getViolaInstance().getFragment();
      if (paramInt != 1) {
        break label44;
      }
    }
    for (;;)
    {
      localViolaFragment.setCanCloseFromBottom(bool);
      return;
      label44:
      bool = false;
    }
  }
  
  public void setRightDragToGoBackParams(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.r(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void setStringToPasteboard(String paramString)
  {
    try
    {
      if (getActivity() != null) {
        ((ClipboardManager)getActivity().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, paramString));
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  @JSMethod
  public void setTabBlurEnable(JSONObject paramJSONObject)
  {
    if ((getViolaInstance() != null) && (getViolaInstance().getActivity() != null)) {
      RIJAppSetting.b(getViolaInstance().getActivity(), paramJSONObject.optBoolean("blur_enable", true));
    }
  }
  
  public void setTitle(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.o(this, paramJSONObject, paramString);
  }
  
  public void setTitleClickListener(String paramString)
  {
    BridgeModuleHelper.g(this, paramString);
  }
  
  public void sharePicMessage(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.s(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void shareVideoWithFriend(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BridgeModule", 2, "do shareVideoWithFriend start data: " + paramJSONObject.toString());
    }
    this.shareVideoCallBackId = paramString;
    paramString = new VideoInfo();
    paramString.jdField_c_of_type_JavaLangString = paramJSONObject.optString("article_title", "");
    paramString.jdField_a_of_type_Int = paramJSONObject.optInt("busiType");
    paramString.jdField_a_of_type_JavaLangString = paramJSONObject.optString("vid");
    paramString.f = paramJSONObject.optString("article_url");
    paramString.m = paramJSONObject.optString("aio_share_url");
    paramString.n = paramJSONObject.optString("qzone_share_url");
    paramString.d = paramJSONObject.optInt("duration");
    paramString.g = paramJSONObject.optString("rowkey");
    paramString.jdField_b_of_type_JavaLangString = paramJSONObject.optString("first_page_url");
    paramString.jdField_b_of_type_Int = paramJSONObject.optInt("width");
    paramString.jdField_c_of_type_Int = paramJSONObject.optInt("height");
    paramString.k = paramJSONObject.optString("thridName");
    paramString.o = paramJSONObject.optString("thirdAction");
    paramString.p = paramJSONObject.optString("thirdIcon");
    paramString.j = paramJSONObject.optString("third_uin");
    paramString.q = paramJSONObject.optString("third_uin_name");
    VideoFeedsShareController.a(paramString, getViolaInstance().getActivity(), 1, this.shareToFriendUin, this.shareToFriendUinType, this.shareToFriendUinName);
  }
  
  public void showActionSheet(JSONObject paramJSONObject, String paramString)
  {
    if (this.mActionSheetHelper == null) {
      this.mActionSheetHelper = new ActionSheetHelper(this);
    }
    this.mActionSheetHelper.a(paramJSONObject, paramString);
  }
  
  @JSMethod
  public void showColorBall()
  {
    ColorNoteSmallScreenUtil.a(BaseApplicationImpl.getContext(), 2, true);
  }
  
  public void showCommentEditor(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.i(this, paramJSONObject, paramString);
  }
  
  public void showCommentEditorNative(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.j(this, paramJSONObject, paramString);
  }
  
  public void showDialog(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.a(this, paramJSONObject, paramString);
  }
  
  public void showFailedToast(@NotNull String paramString)
  {
    QQToast.a(getViolaInstance().getActivity(), 1, paramString, 0).a();
  }
  
  @JSMethod
  public void showFollowAlertView(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.k(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void showMotiveAd(String paramString, JSONObject paramJSONObject)
  {
    BridgeModuleHelper.a(paramString, paramJSONObject);
  }
  
  public void showMultiBiuEditPage(JSONObject paramJSONObject, String paramString)
  {
    if ((getViolaInstance() != null) && (getViolaInstance().getActivity() != null)) {
      RIJUserLevelModule.a().a(getViolaInstance().getActivity(), 2, new BridgeModule.4(this, paramJSONObject, paramString));
    }
  }
  
  public void showPicture(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.w(this, paramJSONObject, paramString);
  }
  
  public void showReadinjoyPicture(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.a(this, paramJSONObject, paramString);
  }
  
  public void showShareMenu(JSONObject paramJSONObject, @NonNull String paramString)
  {
    Object localObject = getViolaInstance().getFragment();
    if (localObject != null) {}
    for (localObject = ((Fragment)localObject).getActivity(); localObject == null; localObject = getViolaInstance().getActivity()) {
      return;
    }
    AppInterface localAppInterface = (AppInterface)ReadInJoyUtils.a();
    JSONObject localJSONObject = paramJSONObject.optJSONObject("shareInfo");
    String str = paramJSONObject.optString("menu_title", HardCodeUtil.a(2131701267));
    JSONArray localJSONArray = paramJSONObject.optJSONArray("hide_items");
    if (paramJSONObject.optInt("show_diandian", 0) == 1) {}
    HashSet localHashSet;
    for (boolean bool = true;; bool = false)
    {
      localHashSet = new HashSet();
      if (localJSONArray == null) {
        break;
      }
      i = 0;
      while (i < localJSONArray.length())
      {
        localHashSet.add(localJSONArray.optString(i));
        i += 1;
      }
    }
    this.mShareHelper = new ReadInJoyShareHelperV2((Activity)localObject, localAppInterface, new SheetItemClickProcessor(false, null, null, localJSONObject, new WeakReference(localObject), paramString, this));
    this.mShareHelper.a().setActionSheetTitle(str);
    int i = paramJSONObject.optInt("report_from");
    this.mShareHelper.a(QShareUtils.a(bool, localHashSet), i, "", null);
  }
  
  public void showShareReadInJoyMenu(JSONObject paramJSONObject, String paramString, Fragment paramFragment)
  {
    AppInterface localAppInterface = (AppInterface)ReadInJoyUtils.a();
    Object localObject1 = paramFragment;
    if (paramFragment == null) {
      localObject1 = getViolaInstance().getFragment();
    }
    if (localObject1 != null) {}
    for (paramFragment = ((Fragment)localObject1).getActivity(); paramFragment == null; paramFragment = getViolaInstance().getActivity()) {
      return;
    }
    localObject1 = paramJSONObject.optJSONArray("upline");
    Object localObject2 = paramJSONObject.optJSONArray("belowline");
    String str2 = paramJSONObject.optString("menu_title", "biu出去让更多好友看到");
    if (localObject1 == null)
    {
      localObject1 = ReadInJoyShareHelperV2.b();
      if (localObject2 != null) {
        break label167;
      }
    }
    ArrayList localArrayList1;
    label167:
    for (localObject2 = ReadInJoyShareHelperV2.c();; localObject2 = ReadInJoyShareHelperV2.a((JSONArray)localObject2, paramJSONObject))
    {
      localArrayList1 = new ArrayList();
      localObject3 = ((List)localObject1).iterator();
      while (((Iterator)localObject3).hasNext()) {
        localArrayList1.add(Integer.valueOf(((ActionItem)((Iterator)localObject3).next()).jdField_a_of_type_Int));
      }
      localObject1 = ReadInJoyShareHelperV2.a((JSONArray)localObject1, paramJSONObject);
      break;
    }
    ArrayList localArrayList2 = new ArrayList();
    Object localObject3 = ((List)localObject2).iterator();
    while (((Iterator)localObject3).hasNext()) {
      localArrayList2.add(Integer.valueOf(((ActionItem)((Iterator)localObject3).next()).jdField_a_of_type_Int));
    }
    String str3;
    if (paramJSONObject.optInt("from") == 1)
    {
      str3 = Aladdin.getConfig(273).getString("share_text_channel_list", "");
      str1 = Aladdin.getConfig(273).getString("share_text", "");
      localObject3 = str1;
    }
    try
    {
      if (!TextUtils.isEmpty(str1)) {
        localObject3 = ReadInJoyStringUtils.a(String.format(str1, new Object[] { paramJSONObject.optString("share_url") }), "\\n", '\n');
      }
      paramJSONObject.put("shouldSharePlainTextChannel", str3);
      paramJSONObject.put("shareText", localObject3);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        int j;
        QLog.e("BridgeModule", 2, QLog.getStackTraceString(localException));
      }
    }
    sShareEntryActivity = new WeakReference(paramFragment);
    i = paramJSONObject.optInt("report_from");
    String str1 = paramJSONObject.optString("rowkey", "");
    localObject3 = paramJSONObject.optString("share_url");
    if (localObject3 != null)
    {
      localObject3 = (String)localObject3 + "&rowkey=" + str1;
      this.mShareHelper = new ReadInJoyShareHelperV2(paramFragment, localAppInterface, new SheetItemClickProcessor(true, (List)localObject1, (List)localObject2, paramJSONObject, new WeakReference(paramFragment), paramString, this));
      this.mShareHelper.a(new List[] { localArrayList1, localArrayList2 }, i, (String)localObject3, null);
      this.mShareHelper.a().setActionSheetTitle(str2);
      i = paramJSONObject.optInt("source", -1);
      j = paramJSONObject.optInt("report_from", -1);
      paramFragment = paramJSONObject.optString("vid", "");
      localObject1 = paramJSONObject.optString("algorithmId", "");
      localObject2 = paramJSONObject.optString("articleId", "");
      paramJSONObject = paramJSONObject.optString("topicId", "");
      this.mShareHelper.a().setCancelListener(new BridgeModule.5(this, j, str1, paramFragment, i, (String)localObject1, (String)localObject2, paramJSONObject));
      this.mShareHelper.a().setOnDismissListener(new BridgeModule.6(this, paramString));
      return;
    }
  }
  
  public void showSuccessToast(@NotNull String paramString)
  {
    QQToast.a(getViolaInstance().getActivity(), 2, paramString, 0).a();
  }
  
  public void showTips(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.m(this, paramJSONObject, paramString);
  }
  
  public void showUGCEditPage(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.a(paramJSONObject, paramString);
  }
  
  public void showUGCVideoRecordPage(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.h(this, paramJSONObject, paramString);
  }
  
  public void showVisibleUserList(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.f(this, paramJSONObject, paramString);
  }
  
  public void socailFeedsUpdate(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.c(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void startImagePreDownload(JSONObject paramJSONObject)
  {
    BridgeModuleHelper.i(paramJSONObject);
  }
  
  @JSMethod
  public void startVideoPreDownload(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramJSONObject = (JSONArray)paramJSONObject.get("preload_array");
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = (JSONObject)paramJSONObject.get(i);
        localArrayList.add(new VideoPreDownloadMgr.VideoPreDownloadParam(localJSONObject.optString("videoVid"), localJSONObject.optString("articleID"), localJSONObject.optInt("busiType"), localJSONObject.optInt("duration")));
        i += 1;
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      ViolaLogUtils.e("BridgeModule", "startVideoPreDownload error :" + paramJSONObject.getMessage());
      if ((this.mVideoPreDownloadMgr != null) && (getViolaInstance() != null) && (getViolaInstance().getActivity() != null))
      {
        this.mVideoPreDownloadMgr.a(getViolaInstance().getActivity().getApplicationContext());
        this.mVideoPreDownloadMgr.a = new VideoPreloadReportData(VideoPreloadReportData.d, VideoPreloadReportData.g);
        this.mVideoPreDownloadMgr.a(new BridgeModule.1(this, localArrayList));
        this.mVideoPreDownloadMgr.a(0, true);
      }
    }
  }
  
  @JSMethod
  public void studyModeSelectGrade(JSONObject paramJSONObject, String paramString)
  {
    RIJStudyModeUtils.a(paramJSONObject.optString("selectedGradeList", ""));
    invokeJS(paramString, new JSONObject());
  }
  
  @JSMethod
  public void susCommentViewHide()
  {
    if ((getViolaInstance() != null) && ((getViolaInstance().getFragment() instanceof ViolaFragment)))
    {
      ViolaFragment localViolaFragment = (ViolaFragment)getViolaInstance().getFragment();
      if ((localViolaFragment.isSuspension()) && (localViolaFragment.getCommonSuspensionGestureLayout() != null)) {
        localViolaFragment.getCommonSuspensionGestureLayout().g();
      }
    }
  }
  
  @JSMethod
  public void susCommentViewShow()
  {
    if ((getViolaInstance() != null) && ((getViolaInstance().getFragment() instanceof ViolaFragment)))
    {
      ViolaFragment localViolaFragment = (ViolaFragment)getViolaInstance().getFragment();
      if ((localViolaFragment.isSuspension()) && (localViolaFragment.getCommonSuspensionGestureLayout() != null)) {
        localViolaFragment.getCommonSuspensionGestureLayout().f();
      }
    }
  }
  
  public void suspensionPopBack(String paramString)
  {
    BridgeModuleHelper.f(this, paramString);
  }
  
  public void updateAccountCardFollowInfo(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.d(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void updateColorBallData(JSONObject paramJSONObject, String paramString)
  {
    ViolaFragment localViolaFragment = getViolaFragment();
    if (localViolaFragment == null) {
      return;
    }
    localViolaFragment.updateColorBallData(paramJSONObject);
    invokeJS(paramString, new JSONObject());
  }
  
  public void updateIfNeed(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.z(this, paramJSONObject, paramString);
  }
  
  @JSMethod(uiThread=true)
  public void updateIndepentTabState(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("state")))
    {
      int i = paramJSONObject.optInt("state");
      ReadInJoyLogicEngineEventDispatcher.a().a(i, null);
    }
  }
  
  public void updateRedPacketShareTime() {}
  
  public void updateTopicCardFollowInfo(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.e(this, paramJSONObject, paramString);
  }
  
  @JSMethod(uiThread=false)
  public void vaNetworkChange(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
    if (localQQAppInterface == null) {}
    while (this.netInfoHandler != null) {
      return;
    }
    this.netInfoHandler = new BridgeModule.2(this, paramString);
    AppNetConnInfo.registerConnectionChangeReceiver(localQQAppInterface.getApplication(), this.netInfoHandler);
  }
  
  @JSMethod
  public void videoPlayFeedback(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BridgeModule", 2, "do videoPlayFeedback start data: " + paramJSONObject.toString());
    }
    Object localObject;
    if (sShareEntryActivity == null) {
      localObject = null;
    }
    for (;;)
    {
      PlayFeedbackHelper.a((Activity)localObject, paramJSONObject);
      sShareEntryActivity = null;
      paramJSONObject = getViolaInstance();
      if (paramJSONObject != null) {
        localObject = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject).put("success", 1);
        ViolaBridgeManager.getInstance().callbackJavascript(paramJSONObject.getInstanceId(), MODULE_NAME, "callback", paramString, localObject, true);
        return;
        localObject = (Activity)sShareEntryActivity.get();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule
 * JD-Core Version:    0.7.0.1
 */