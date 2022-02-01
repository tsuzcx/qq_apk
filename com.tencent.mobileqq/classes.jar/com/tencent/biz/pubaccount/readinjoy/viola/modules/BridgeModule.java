package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import aanz;
import aaob;
import ackn;
import acko;
import acqx;
import acqy;
import acrc;
import acrd;
import acre;
import aevv;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import anhk;
import anni;
import anrs;
import aoor;
import arpm;
import aufz;
import bdch;
import bdsh;
import bfhe;
import bggq;
import bgkc;
import bgku;
import bgln;
import bglo;
import bgnw;
import bgpa;
import bhgg;
import bhhb;
import bhhf;
import bhhh;
import bhhk;
import bisa;
import bisz;
import blsb;
import bmqa;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyMessagesActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarFragment;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SubCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasCommentFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyForCanvasFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoCeilingFragment;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.JumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyPrivacyListFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberAQFragment;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLikeAnimate;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideoView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.protofile.cmd0xe36.cmd0xe36.ReqBody;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
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
import java.io.File;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import niq;
import nir;
import nko;
import nlw;
import oat;
import och;
import oqj;
import oql;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ouh;
import ovb;
import ovj;
import pdz;
import pea;
import pfe;
import pgy;
import pha;
import pmh;
import pmk;
import pmm;
import pvl;
import qps;
import qpt;
import qqm;
import rce;
import rcm;
import rcq;
import rgv;
import rgy;
import rhs;
import rht;
import rhu;
import rjh;
import rog;
import rps;
import rqc;
import rqh;
import ryx;
import sce;
import sfk;
import sfl;
import sjo;
import skb;
import skc;
import snh;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tlg;
import tmh;
import tmn;
import tmp;
import tmt;
import tmx;
import tmy;
import tmz;
import tna;
import tnb;
import tnc;
import tnd;
import tne;
import tnf;
import tng;
import tnh;
import tni;
import tnj;
import tnk;
import tnl;
import tnm;
import tnn;
import tno;
import tnp;
import tnq;
import tnr;
import tns;
import tnt;
import tnu;
import tnw;
import tnz;
import toa;
import tob;
import toc;
import tod;
import toe;
import tof;
import tog;
import toh;
import toi;
import toj;
import tok;
import ton;
import too;
import top;
import toq;
import tor;
import tos;
import tot;
import tou;
import tov;
import tow;
import tox;
import tpa;
import tpd;
import tpw;
import trb;
import trw;
import twm;
import uai;
import uam;
import ucb;
import zmi;

public class BridgeModule
  extends BaseModule
  implements aaob, Destroyable, IActivityState, rce
{
  public static final String BRIDGE_LOCAL_JS_URL = "https://viola.qq.com/viola_serve/dev";
  public static final String BRIDGE_METHOD_NAME_ONCLICKBUBBLETIPS = "onClickBubbleTips";
  public static final String BRIDGE_METHOD_NAME_REQUESTBUBBLETIPSWORDING = "requestBubbleTipsWording";
  public static final String BRIDGE_PARAMS = "params";
  public static final String BRIDGE_PARAMS_ACCURATE = "accurate";
  public static final String BRIDGE_PARAMS_ACTION = "action";
  public static final String BRIDGE_PARAMS_ANDROIDID = "androidID";
  public static final String BRIDGE_PARAMS_AUTO_DES = "autoDestroy";
  public static final String BRIDGE_PARAMS_BID = "v_bid";
  public static final String BRIDGE_PARAMS_CHANNELID = "channelId";
  public static final String BRIDGE_PARAMS_FOR_NV = "isForNativeVue";
  public static final String BRIDGE_PARAMS_FROMCALLBACK = "fromCallback";
  public static final String BRIDGE_PARAMS_FROMTYPE = "fromType";
  public static final String BRIDGE_PARAMS_IDENTIFIER = "identifier";
  public static final String BRIDGE_PARAMS_IMSI = "imsi";
  public static final String BRIDGE_PARAMS_JS = "js";
  public static final String BRIDGE_PARAMS_JUMP_BUNDLE = "jumpBundle";
  public static final String BRIDGE_PARAMS_JUMP_CLIPBOARDINFO = "clipboardInfo";
  public static final String BRIDGE_PARAMS_JUMP_COMMONDATA = "commonData";
  public static final String BRIDGE_PARAMS_JUMP_SCHEMA = "jumpSchema";
  public static final String BRIDGE_PARAMS_JUMP_TYPE = "jumpType";
  public static final String BRIDGE_PARAMS_JUMP_URL = "jumpUrl";
  public static final String BRIDGE_PARAMS_PICURL = "picUrl";
  public static final String BRIDGE_PARAMS_QIMEI = "qimei";
  public static final String BRIDGE_PARAMS_QUA = "qua";
  public static final String BRIDGE_PARAMS_RATE = "rate";
  public static final String BRIDGE_PARAMS_RECOMMEND = "showRecommendReason";
  public static final String BRIDGE_PARAMS_REDPACKET_ID = "redPacketId";
  public static final String BRIDGE_PARAMS_REDPACKET_ID_SM = "redpackid";
  public static final String BRIDGE_PARAMS_ROWKEY = "rowkey";
  public static final String BRIDGE_PARAMS_SHOULD_SHOW = "shouldShow";
  public static final String BRIDGE_PARAMS_STATUS = "status";
  public static final String BRIDGE_PARAMS_TID = "v_tid";
  public static final String BRIDGE_PARAMS_TYPE = "type";
  public static final String BRIDGE_PARAMS_VID = "vid";
  public static final String BRIDGE_PARAMS_VIDEOFEEDSJS = "VideoFeeds.js";
  public static final String BRIDGE_PARAMS_VIDEO_ATTACH = "autoAttachVideoView";
  public static final String BRIDGE_PARAMS_VIDEO_HANDATTACH = "handAttachVideoView";
  public static final String BRIDGE_PARAMS_VIDEO_TOKEN = "videoToken";
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
  public static final String KEY_PREDOWNLOAD_MGR = "predownload";
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
  public static String TAG = "BridgeModule";
  public static GdtAppReceiver mGdtAppReceiver;
  private static WeakReference<Activity> sShareEntryActivity;
  public static String shareCallBackId;
  public static String shareCallBackName;
  public static int shareCallBackType;
  private tpw bridgeInvokeHandler = new tpw(this);
  private Map<Long, String> columnToUploadCallbackMap = new HashMap();
  private String commentCallbaclId;
  private ovb dataManager;
  private tmt mActionSheetHelper;
  private trb mBridgeApiHelper;
  private String mCallBack;
  private aanz mClient;
  private trw mCommentManager;
  private DownloadListener mDownloadListener;
  private tox mEventHelper;
  private Map<String, Object> mObjectMap = new ArrayMap();
  private SparseArray<tou> mResultActionMap = new SparseArray();
  protected ShareActionSheetBuilder mShareActionSheet;
  public uai mShareHelper;
  public tpa mShareUtils = new tpa();
  private int mState = -100;
  private String mUploadCallBack;
  private VideoPreDownloadMgr mVideoPreDownloadMgr = new VideoPreDownloadMgr();
  private int maxSize = 204800;
  private int minDuration = 5;
  private INetInfoHandler netInfoHandler;
  private long preTime;
  public rcq rijWatchWordPresenter;
  public String shareToFriendUin = "";
  public String shareToFriendUinName = "";
  public int shareToFriendUinType;
  private String shareVideoCallBackId;
  private rqc videoPublishCallback = new tnw(this);
  private rqh violaVideoUpdateController;
  
  public BridgeModule()
  {
    this.mObjectMap.put("predownload", this.mVideoPreDownloadMgr);
    this.rijWatchWordPresenter = new rcq(new rcm());
    this.rijWatchWordPresenter.a(this);
    registerActivityResultAction();
  }
  
  private void arouseReadInJoyNativeCommentView(JSONObject paramJSONObject, int paramInt)
  {
    for (;;)
    {
      try
      {
        String str1 = paramJSONObject.optString("uniqueKey");
        int i = paramJSONObject.optInt("source", 3);
        Object localObject2 = paramJSONObject.optString("feedsID", "");
        int j = paramJSONObject.optInt("feedsType", -1);
        int k = paramJSONObject.optInt("adTag", -1);
        String str3 = paramJSONObject.optString("title", "");
        String str4 = paramJSONObject.optString("sourceName", "");
        String str5 = paramJSONObject.optString("picUrl", "");
        long l = paramJSONObject.optLong("duration", -1L);
        String str6 = paramJSONObject.optString("articleID", "");
        Object localObject1 = paramJSONObject.optString("commentID");
        String str2 = paramJSONObject.optString("subCommentID");
        bool = paramJSONObject.optBoolean("isAwesome");
        int m = paramJSONObject.optInt("jumpType");
        int n = paramJSONObject.optInt("showType", 0);
        QLog.d(TAG, 1, "startShowComment  uniqueKey = " + str1 + "source = " + i + "feedsId = " + (String)localObject2 + " feedsType=" + j + "adTag = " + k + "title = " + str3 + "sourceName = " + str4 + "picUrl =" + str5 + "duration = " + l + "articleId =" + str6);
        paramJSONObject = new Bundle();
        paramJSONObject.putSerializable("commonCommentData", new CommonCommentData(str6, j, (String)localObject2, k, str3, str4, str5, l));
        paramJSONObject.putInt("source", i);
        paramJSONObject.putString("commentId", (String)localObject1);
        paramJSONObject.putString("subCommentId", str2);
        paramJSONObject.putBoolean("isAwesome", bool);
        paramJSONObject.putInt("jumpType", m);
        paramJSONObject.putInt("seq", paramInt);
        localObject2 = new AnchorData();
        ((AnchorData)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
        ((AnchorData)localObject2).jdField_b_of_type_JavaLangString = str2;
        ((AnchorData)localObject2).jdField_a_of_type_Boolean = bool;
        QLog.d(TAG, 1, "anchorData commentId:" + (String)localObject1 + " ,subCommentId :" + str2);
        localObject1 = BaseActivity.sTopActivity;
        if (n == 1)
        {
          bool = true;
          ReadInJoyAtlasCommentFragment.a((Context)localObject1, str1, null, null, null, (AnchorData)localObject2, false, bool, paramJSONObject);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        boolean bool;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(TAG, 2, QLog.getStackTraceString(paramJSONObject));
      }
      bool = false;
    }
  }
  
  private int bindCommentCallback(String paramString)
  {
    if (this.mClient == null)
    {
      this.mClient = aanz.a();
      this.mClient.a();
    }
    this.commentCallbaclId = paramString;
    return this.mClient.a(this);
  }
  
  private void callJsDeliverResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramIntent == null) {}
    String str1;
    do
    {
      do
      {
        return;
        str1 = paramIntent.getStringExtra("arg_callback");
      } while (TextUtils.isEmpty(str1));
      if (paramInt2 != -1) {
        break;
      }
      paramIntent = paramIntent.getStringExtra("arg_result_json");
    } while (paramIntent == null);
    try
    {
      paramIntent = new JSONObject(paramIntent);
      paramIntent.put("retCode", 0);
      String str2 = paramIntent.toString();
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, getFunctionName(paramInt1) + " result:" + ReadInJoyDeliverUGCActivity.a(str2));
      }
      invokeCallJS(str1, paramIntent);
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.e(TAG, 2, "callJsDeliverResult error:" + paramIntent.getMessage());
      return;
    }
    try
    {
      paramIntent = new JSONObject();
      paramIntent.put("retCode", paramInt2);
      paramIntent = paramIntent.toString();
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, getFunctionName(paramInt1) + " result:" + paramIntent);
      }
      invokeErrorCallJS(str1, "result not ok");
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.e(TAG, 2, "callJsDeliverResult fail error:" + paramIntent.getMessage());
    }
  }
  
  private AnchorData createAnchorData(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("commentID");
    String str2 = paramJSONObject.optString("subCommentID");
    boolean bool = paramJSONObject.optBoolean("isAwesome");
    paramJSONObject = new AnchorData();
    paramJSONObject.jdField_a_of_type_JavaLangString = str1;
    paramJSONObject.jdField_b_of_type_JavaLangString = str2;
    paramJSONObject.jdField_a_of_type_Boolean = bool;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 1, "openTopicVideoComment anchorData commentId:" + str1 + " ,subCommentId :" + str2);
    }
    return paramJSONObject;
  }
  
  private ArticleInfo createArticleInfo(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("rowkey");
    String str2 = paramJSONObject.optString("title", "");
    String str3 = paramJSONObject.optString("cover", "");
    long l1 = paramJSONObject.optLong("articleId", 0L);
    long l2 = paramJSONObject.optLong("feedsID", 0L);
    int i = paramJSONObject.optInt("feedsType", 0);
    ArticleInfo localArticleInfo = new ArticleInfo();
    localArticleInfo.innerUniqueID = str1;
    localArticleInfo.mTitle = str2;
    localArticleInfo.mSummary = null;
    localArticleInfo.mFirstPagePicUrl = str3;
    localArticleInfo.mArticleID = l1;
    localArticleInfo.mFeedId = l2;
    localArticleInfo.mFeedType = i;
    if (!TextUtils.isEmpty(paramJSONObject.optString("vid", ""))) {
      localArticleInfo.mVideoVid = paramJSONObject.optString("vid");
    }
    if (!TextUtils.isEmpty(paramJSONObject.optString("picUrl", ""))) {
      localArticleInfo.mVideoCoverUrl = pha.a(paramJSONObject.optString("picUrl"));
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 1, "openTopicVideoComment  uniqueKey = " + str1 + "feedsId = " + l2 + " feedsType=" + i + "title = " + str2 + "picUrl =" + str3 + "articleId =" + l1);
    }
    return localArticleInfo;
  }
  
  private Intent createIntent(ArticleInfo paramArticleInfo, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, long paramLong1, String paramString4, long paramLong2, int paramInt3, String paramString5, int paramInt4)
  {
    Intent localIntent = new Intent(BaseActivity.sTopActivity, ReadInJoyDeliverBiuActivity.class);
    localIntent.putExtra("arg_article_info", paramArticleInfo);
    if (!TextUtils.isEmpty(paramString1)) {
      localIntent.putExtra("biu_rowkey", paramString1);
    }
    localIntent.putExtra("arg_from_type", paramInt1);
    localIntent.putExtra("arg_type", paramInt2);
    localIntent.putExtra("result_js_callback", paramString2);
    localIntent.putExtra("biu_src", paramInt4);
    localIntent.putExtra("feed_id", paramString3);
    localIntent.putExtra("feedsType", paramLong1);
    localIntent.putExtra("ugc_comment", paramString4);
    localIntent.putExtra("arg_account_id", paramLong2);
    localIntent.putExtra("arg_account_type", paramInt3);
    localIntent.putExtra("arg_source_url", paramString5);
    return localIntent;
  }
  
  private void dealBiuResult(int paramInt, Intent paramIntent)
  {
    boolean bool = true;
    if (paramInt == -1) {}
    for (int i = 0;; i = -1)
    {
      if (paramIntent == null) {
        return;
      }
      String str1 = paramIntent.getStringExtra("result_js_callback");
      String str2 = paramIntent.getStringExtra("feed_id");
      int j = paramIntent.getIntExtra("feedsType", 1);
      if ((str1 != null) && (str2 != null)) {
        paramIntent = new JSONObject();
      }
      try
      {
        paramIntent.put("feedsId", str2);
        paramIntent.put("retCode", i);
        paramIntent.put("feedsType", j);
        invokeCallJS(str1, paramIntent);
        paramIntent = uam.a;
        if (paramInt == -1)
        {
          paramIntent.a(bool);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          QLog.e(TAG, 2, "dealBiuResult error:" + paramIntent.getMessage());
          continue;
          bool = false;
        }
      }
    }
  }
  
  private void dealForwardResult(int paramInt, Intent paramIntent)
  {
    JSONObject localJSONObject;
    if (paramInt == -1)
    {
      if ((getViolaInstance() != null) && (getViolaInstance().getActivity() != null))
      {
        ForwardUtils.a((QQAppInterface)pha.a(), getViolaInstance().getActivity(), getViolaInstance().getActivity(), paramIntent, null);
        QLog.d(TAG, 2, "share video card to aio success。");
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
          QLog.e(TAG, 1, "processClick callback error=" + paramIntent.getMessage());
        }
        localJSONObject = new JSONObject();
      }
    }
    try
    {
      localJSONObject.put("result", 1);
      invokeCallJS(paramIntent, localJSONObject);
      paramIntent = uam.a;
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
        QLog.e(TAG, 2, "do call share friend back error:" + paramIntent.getMessage());
        continue;
        boolean bool = false;
      }
    }
  }
  
  private void dealInviteFriendResult(Intent paramIntent)
  {
    if ((paramIntent == null) || (BaseActivity.sTopActivity == null)) {}
    String str2;
    do
    {
      return;
      str2 = paramIntent.getStringExtra("arg_callback");
    } while (TextUtils.isEmpty(str2));
    int i = paramIntent.getIntExtra("result_code", -1);
    if (i == 0)
    {
      if (Looper.myLooper() == null) {
        Looper.prepare();
      }
      new Handler(BaseActivity.sTopActivity.getMainLooper()).postDelayed(new BridgeModule.21(this), 200L);
    }
    String str1 = "";
    if (paramIntent.hasExtra("result_msg")) {
      str1 = paramIntent.getStringExtra("result_msg");
    }
    paramIntent = new JSONObject();
    try
    {
      paramIntent.put("retCode", i);
      paramIntent.put("msg", str1);
      invokeCallJS(str2, paramIntent);
      return;
    }
    catch (JSONException paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  private void dealRedPacketMVResult(int paramInt, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("arg_callback");
    if (TextUtils.isEmpty(str)) {
      return;
    }
    paramIntent = paramIntent.getExtras();
    long l1 = paramIntent.getLong("duration_time");
    long l2 = paramIntent.getLong("elapsed_time");
    boolean bool1 = paramIntent.getBoolean("profitable_flag", false);
    boolean bool2 = paramIntent.getBoolean("is_end", false);
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "motiveResult: durationTime = " + l1 + "elaspedTime = " + l2 + "profitable =" + bool1);
    }
    paramIntent = new JSONObject();
    if (paramInt == -1) {}
    for (;;)
    {
      try
      {
        paramIntent.put("retCode", 0);
        paramIntent.put("elapsedTime", l2);
        paramIntent.put("totalTime", l1);
        paramIntent.put("profitable", bool1);
        paramIntent.put("isEnd", bool2);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
      }
      invokeCallJS(str, paramIntent);
      return;
      paramIntent.put("retCode", -1);
    }
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
      localObject = uam.a;
      if (paramInt == -1)
      {
        ((uam)localObject).a(bool);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e(TAG, 1, "processClick callback error=" + localJSONException.getMessage());
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
              paramIntent.put("msg", anni.a(2131699995));
              if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "selectAndUploadAvatar  result:" + ReadInJoyDeliverUGCActivity.a(paramIntent.toString()));
              }
              if (!TextUtils.isEmpty(this.mUploadCallBack)) {
                invokeCallJS(this.mUploadCallBack, paramIntent);
              }
              return;
            }
            catch (Exception paramIntent)
            {
              while (!QLog.isColorLevel()) {}
              QLog.e(TAG, 2, QLog.getStackTraceString(paramIntent));
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
            QLog.d(TAG, 2, "selectAndUploadAvatar  result:" + ReadInJoyDeliverUGCActivity.a(localJSONObject.toString()));
          }
          invokeCallJS(str, localJSONObject);
          return;
        }
        catch (Exception paramIntent) {}
      } while (!QLog.isColorLevel());
      QLog.e(TAG, 2, QLog.getStackTraceString(paramIntent));
      return;
      try
      {
        paramIntent = new JSONObject();
        paramIntent.put("retCode", -1);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, " selectAndUploadAvatar result:" + paramIntent.toString());
        }
        invokeCallJS(str, paramIntent);
        return;
      }
      catch (Exception paramIntent) {}
    } while (!QLog.isColorLevel());
    QLog.e(TAG, 2, QLog.getStackTraceString(paramIntent));
  }
  
  private void doPostShowComment(FragmentActivity paramFragmentActivity, VVideoView paramVVideoView, View paramView, JSONObject paramJSONObject)
  {
    int j = 0;
    Object localObject;
    if (this.mCommentManager == null)
    {
      localObject = paramFragmentActivity.getSupportFragmentManager();
      if ((getViolaInstance() == null) || (!((ViolaFragment)getViolaInstance().getFragment()).a()) || (!((ViolaFragment)getViolaInstance().getFragment()).a().d())) {
        break label256;
      }
    }
    int k;
    label256:
    for (int i = ((ViolaFragment)getViolaInstance().getFragment()).a().a();; i = 0)
    {
      this.mCommentManager = new trw(paramFragmentActivity, (FragmentManager)localObject, i);
      if ((getViolaInstance() != null) && ((getViolaInstance().getFragment() instanceof ViolaFragment)))
      {
        paramFragmentActivity = (ViolaFragment)getViolaInstance().getFragment();
        if ((paramFragmentActivity.a()) && (paramFragmentActivity.a() != null)) {
          paramFragmentActivity.a().f();
        }
      }
      this.mCommentManager.a(new tnk(this));
      paramFragmentActivity = createArticleInfo(paramJSONObject);
      localObject = createAnchorData(paramJSONObject);
      float f = ViolaUtils.getFloat(paramJSONObject.optString("offset"), Float.valueOf(0.0F));
      this.mCommentManager.a(paramView, f);
      k = ColorParseUtils.parseColor(paramJSONObject.optString("backgroundColor"), -16777216);
      i = j;
      if (paramJSONObject.optInt("directComment") == 1) {
        i = 1;
      }
      if (i == 0) {
        break;
      }
      this.mCommentManager.b(paramVVideoView, paramView, paramFragmentActivity, (AnchorData)localObject, k);
      return;
    }
    this.mCommentManager.a(paramVVideoView, paramView, paramFragmentActivity, (AnchorData)localObject, k);
  }
  
  private void ensureEventHelper()
  {
    if (this.mEventHelper == null) {
      this.mEventHelper = new tox(this);
    }
  }
  
  private void fireGetLocationFromCache(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    paramString1 = aoor.a(paramString1);
    if ((paramString1 != null) && (paramString1.a != null))
    {
      fireLocationSuccessCallback(paramString1, paramString2);
      return;
    }
    fireLocationErrorCallback(paramString2, "fail to get locationInfo from cache");
  }
  
  private void fireGetLocationFromSso(String paramString1, String paramString2)
  {
    aoor.a(new tod(this, paramString1, paramString2));
  }
  
  private void fireLocationErrorCallback(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (paramString2 != null) {}
    for (;;)
    {
      try
      {
        paramString2 = getFailInvokeObj(paramString2);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("ret", 1).put("authroized", false);
        paramString2.put("data", localJSONObject);
        invokeJS(paramString1, paramString2);
        return;
      }
      catch (JSONException paramString1)
      {
        QLog.e(TAG, 1, "fireLocationErrorCallbackError: " + paramString1.getMessage());
        return;
      }
      paramString2 = "";
    }
  }
  
  private void fireLocationSuccessCallback(SosoInterface.SosoLbsInfo paramSosoLbsInfo, String paramString)
  {
    if ((paramSosoLbsInfo == null) || (paramSosoLbsInfo.a == null)) {
      return;
    }
    double d1 = paramSosoLbsInfo.a.a;
    double d2 = 1000000;
    double d3 = paramSosoLbsInfo.a.b;
    double d4 = 1000000;
    double d5 = paramSosoLbsInfo.a.a;
    double d6 = paramSosoLbsInfo.a.b;
    String str;
    if (paramSosoLbsInfo.a.e != null)
    {
      str = paramSosoLbsInfo.a.e;
      if (paramSosoLbsInfo.a.f == null) {
        break label244;
      }
    }
    label244:
    for (paramSosoLbsInfo = paramSosoLbsInfo.a.f;; paramSosoLbsInfo = "")
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("authroized", true);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("ret", 0).put("latitude", d1 * d2).put("longitude", d3 * d4).put("origin_latitude", d5).put("origin_longitude", d6).put("city", str).put("cityCode", paramSosoLbsInfo).put("status", localJSONObject1);
        invokeCallJS(paramString, localJSONObject2.toString());
        return;
      }
      catch (JSONException paramSosoLbsInfo)
      {
        QLog.e(TAG, 1, "fireLocationSuccessCallbackError: " + paramSosoLbsInfo.getMessage());
        return;
      }
      str = "";
      break;
    }
  }
  
  private static HashMap<String, Object> generateMapFromInvokeJsUrl(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      HashMap localHashMap = new HashMap();
      if (TextUtils.isEmpty(paramJSONObject.optString("bgclr"))) {
        localHashMap.put(tmn.d, paramJSONObject.optString("bgclr"));
      }
      if (TextUtils.isEmpty(paramJSONObject.optString("txtclr"))) {
        localHashMap.put(tmn.jdField_c_of_type_JavaLangString, paramJSONObject.optString("txtclr"));
      }
      if (!TextUtils.isEmpty(paramJSONObject.optString("titleclr"))) {
        localHashMap.put(tmn.e, paramJSONObject.optString("titleclr"));
      }
      if (!TextUtils.isEmpty(paramJSONObject.optString("alpha"))) {
        localHashMap.put(tmn.f, paramJSONObject.optString("alpha"));
      }
      if (!TextUtils.isEmpty(paramJSONObject.optString("statusBarColor"))) {
        localHashMap.put(tmn.g, paramJSONObject.optString("statusBarColor"));
      }
      return localHashMap;
    }
    return null;
  }
  
  private int getBiuSrc(int paramInt)
  {
    int i;
    if (paramInt == 5) {
      i = 4;
    }
    do
    {
      return i;
      if (paramInt == 11) {
        return 5;
      }
      if (paramInt == 6) {
        return 6;
      }
      if (paramInt == 12) {
        return 7;
      }
      if (paramInt == 13) {
        return 8;
      }
      i = paramInt;
    } while (paramInt >= 15);
    if (paramInt == 8) {
      return 2;
    }
    return 3;
  }
  
  @NotNull
  private String getFunctionName(int paramInt)
  {
    switch (paramInt)
    {
    case 117: 
    case 118: 
    case 119: 
    case 120: 
    case 121: 
    default: 
      return "";
    case 114: 
      return "showUGCEditPage";
    case 115: 
      return "showUGCVideoUploadPage";
    case 116: 
      return "showUGCVideoRecordPage";
    }
    return "showQAAskEditor";
  }
  
  private String getNickName(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = paramQQAppInterface.getCurrentNickname();
    if (!TextUtils.isEmpty(paramString))
    {
      paramQQAppInterface = (anrs)paramQQAppInterface.getManager(56);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.c(paramString);
        if (paramQQAppInterface != null) {
          return paramQQAppInterface.name;
        }
      }
    }
    return str;
  }
  
  private int getRecommendFlag()
  {
    int i = 1;
    if (bdch.a()) {
      i = 8193;
    }
    return i;
  }
  
  private void getUploadingVideoList(@NotNull QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    rps.a(paramQQAppInterface).a(paramLong, new tnq(this, paramLong, paramString));
  }
  
  private void handleCommentEditorNativeResult(int paramInt, Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramIntent == null) {}
    String str1;
    Object localObject1;
    String str2;
    int i;
    do
    {
      for (;;)
      {
        return;
        localObject2 = paramIntent.getStringExtra("arg_callback");
        str1 = paramIntent.getStringExtra("arg_result_json");
        try
        {
          localJSONObject = new JSONObject(str1);
          if (localJSONObject != null) {
            if (paramInt == -1) {}
          }
        }
        catch (JSONException localJSONException)
        {
          try
          {
            JSONObject localJSONObject;
            localJSONObject.put("retCode", -1);
            localJSONObject.put("commentId", 0);
            invokeCallJS((String)localObject2, localJSONObject);
            return;
            localJSONException = localJSONException;
            QLog.e(TAG, 1, "handleCommentEditorNativeResult result parse error.");
            localObject1 = null;
          }
          catch (JSONException paramIntent)
          {
            for (;;)
            {
              QLog.e(TAG, 1, "handleCommentEditorNativeResult put user cancel result error.");
            }
          }
          paramInt = ((JSONObject)localObject1).optInt("biuAfterComment");
          str2 = new String(Base64.decode(((JSONObject)localObject1).optString("comment"), 0));
          i = ((JSONObject)localObject1).optInt("feedsType");
          localObject1 = new tnj(this, (JSONObject)localObject1, (String)localObject2);
          paramIntent = paramIntent.getParcelableExtra("comment_create_data");
          if ((paramIntent instanceof FirstCommentCreateData))
          {
            paramIntent = (FirstCommentCreateData)paramIntent;
            paramIntent.a(str2);
            localObject2 = pdz.a;
            if (paramInt == 1) {}
            for (;;)
            {
              ((pdz)localObject2).a(paramIntent, (pea)localObject1, str1, i, false, bool1);
              return;
              bool1 = false;
            }
          }
        }
      }
    } while (!(paramIntent instanceof SubCommentCreateData));
    paramIntent = (SubCommentCreateData)paramIntent;
    paramIntent.d(str2);
    Object localObject2 = pdz.a;
    if (paramInt == 1) {}
    for (bool1 = bool2;; bool1 = false)
    {
      ((pdz)localObject2).a(paramIntent, (pea)localObject1, str1, i, false, bool1);
      return;
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
      this.dataManager = new ovb();
      UiApiPlugin.a(paramIntent, this.dataManager, str, new tni(this));
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
            break label177;
          }
          paramIntent.put("retCode", 0);
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "ReadInJoyDeliverUGCActivity.replaceUrlInLog result:" + ReadInJoyDeliverUGCActivity.a(paramIntent.toString()));
          }
          invokeCallJS(str, paramIntent);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e(TAG, 1, "handleCommentEditorResult json put data exception.");
        return;
      }
      paramIntent = new JSONObject();
      continue;
      label177:
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
      QLog.d(TAG, 1, "ReadInJoyAddUgcVideo fail ! " + paramIntent.toString());
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
        QLog.d(TAG, 1, "ReadInJoyManageUgcColumn fail ! " + paramIntent.toString());
        return;
      }
      paramInt = -1;
    }
  }
  
  @SuppressLint({"NewApi"})
  private boolean hasAuthorizeLocation()
  {
    if (!VersionUtils.isM()) {}
    BaseActivity localBaseActivity;
    do
    {
      return true;
      localBaseActivity = BaseActivity.sTopActivity;
      if (localBaseActivity == null) {
        return false;
      }
    } while (localBaseActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0);
    return false;
  }
  
  private void initPgcBiuInfo(JSONObject paramJSONObject, ArticleInfo paramArticleInfo, long paramLong1, long paramLong2)
  {
    if (paramJSONObject == null) {}
    do
    {
      return;
      paramJSONObject = paramJSONObject.getJSONArray("biuLevelList");
      paramArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
      paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy = new rgy();
      paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy.jdField_a_of_type_JavaLangLong = Long.valueOf(paramLong1);
      paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy.jdField_b_of_type_JavaLangLong = Long.valueOf(paramLong2);
      paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy.jdField_a_of_type_JavaUtilList = new ArrayList();
    } while (paramJSONObject == null);
    int i = 0;
    while (i < paramJSONObject.length())
    {
      SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = new SocializeFeedsInfo.BiuCommentInfo();
      Object localObject = paramJSONObject.getJSONObject(i);
      localBiuCommentInfo.jdField_a_of_type_JavaLangLong = Long.valueOf(((JSONObject)localObject).optLong("uin"));
      localBiuCommentInfo.jdField_b_of_type_JavaLangString = new String(bgku.decode(((JSONObject)localObject).optString("comment"), 0));
      localBiuCommentInfo.jdField_a_of_type_JavaLangString = localBiuCommentInfo.jdField_b_of_type_JavaLangString;
      localBiuCommentInfo.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("biuTime");
      localBiuCommentInfo.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("feeds_type", 1);
      localBiuCommentInfo.jdField_c_of_type_Int = ((JSONObject)localObject).optInt("op_type");
      String str1 = ((JSONObject)localObject).optString("jumpName");
      String str2 = ((JSONObject)localObject).optString("jumpUrl");
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
        localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo = new SocializeFeedsInfo.JumpInfo(0L, new String(bgku.decode(str1, 0)), str2);
      }
      try
      {
        localObject = ((JSONObject)localObject).optString("feedsId");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localBiuCommentInfo.jdField_b_of_type_JavaLangLong = Long.valueOf(new BigInteger((String)localObject).longValue());
        }
        paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy.jdField_a_of_type_JavaUtilList.add(localBiuCommentInfo);
        i += 1;
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
  
  private int initTypeWhenUgc(int paramInt, JSONObject paramJSONObject)
  {
    int j = 2;
    int i;
    if ((paramInt == 3) || (paramInt == 2)) {
      i = 1;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (paramInt == 4);
      i = j;
    } while (paramInt == 5);
    return paramJSONObject.optInt("type");
  }
  
  private void initUgcAtComments(JSONObject paramJSONObject, ArticleInfo paramArticleInfo)
  {
    paramJSONObject = paramJSONObject.optJSONArray("ugcAtLevelList");
    if (paramJSONObject != null)
    {
      paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs.jdField_a_of_type_Rgy = new rgy();
      paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs.jdField_a_of_type_Rgy.jdField_a_of_type_JavaUtilList = new ArrayList();
      int i = 0;
      for (;;)
      {
        if (i < paramJSONObject.length())
        {
          SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = new SocializeFeedsInfo.BiuCommentInfo();
          Object localObject = paramJSONObject.getJSONObject(i);
          localBiuCommentInfo.jdField_a_of_type_JavaLangLong = Long.valueOf(((JSONObject)localObject).optLong("uin"));
          localBiuCommentInfo.jdField_b_of_type_JavaLangString = new String(bgku.decode(((JSONObject)localObject).optString("comment"), 0));
          localBiuCommentInfo.jdField_a_of_type_JavaLangString = localBiuCommentInfo.jdField_b_of_type_JavaLangString;
          localBiuCommentInfo.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("biuTime");
          localBiuCommentInfo.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("feeds_type", 1);
          localBiuCommentInfo.jdField_c_of_type_Int = ((JSONObject)localObject).optInt("op_type");
          String str1 = ((JSONObject)localObject).optString("jumpName");
          String str2 = ((JSONObject)localObject).optString("jumpUrl");
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
            localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo = new SocializeFeedsInfo.JumpInfo(0L, new String(bgku.decode(str1, 0)), str2);
          }
          try
          {
            localObject = ((JSONObject)localObject).optString("feedsId");
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              localBiuCommentInfo.jdField_b_of_type_JavaLangLong = Long.valueOf(new BigInteger((String)localObject).longValue());
            }
            paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs.jdField_a_of_type_Rgy.jdField_a_of_type_JavaUtilList.add(localBiuCommentInfo);
            i += 1;
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
  }
  
  private void initUgcFeedsInfo(ArticleInfo paramArticleInfo, JSONObject paramJSONObject, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong)
  {
    paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs = new rhs();
    initUgcAtComments(paramJSONObject, paramArticleInfo);
    paramArticleInfo.mTitle = new String(bgku.decode(paramString1, 0));
    paramArticleInfo.mSummary = "";
    if ((paramInt1 == 3) || (paramInt1 == 2))
    {
      paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      paramString1 = new rht();
      paramJSONObject = paramJSONObject.optJSONArray("ugcPicInfo");
      if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
      {
        paramString1.jdField_c_of_type_JavaLangString = paramJSONObject.getJSONObject(0).optString("ugcPicUrl");
        paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs.jdField_a_of_type_JavaUtilArrayList.add(paramString1);
      }
    }
    for (;;)
    {
      if (paramInt2 == 22)
      {
        paramJSONObject = new rgv();
        paramJSONObject.jdField_a_of_type_JavaLangString = paramString3;
        paramJSONObject.jdField_b_of_type_JavaLangString = paramString4;
        paramJSONObject.jdField_c_of_type_JavaLangString = paramString5;
        paramJSONObject.jdField_a_of_type_Long = paramLong;
        paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs.jdField_a_of_type_Rgv = paramJSONObject;
      }
      paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs.jdField_a_of_type_Int = paramInt1;
      paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs.jdField_a_of_type_JavaLangString = paramArticleInfo.mTitle;
      return;
      if ((paramInt1 == 4) || (paramInt1 == 5))
      {
        paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs.b = new ArrayList();
        paramString1 = new rhu();
        paramJSONObject = paramJSONObject.optJSONObject("ugcVideoInfo");
        if (paramJSONObject != null)
        {
          paramString1.d = paramJSONObject.optString("ugcVideoCoverUrl");
          paramString1.jdField_a_of_type_Long = paramJSONObject.optInt("ugcVideoDuration");
          paramString1.e = paramString2;
          paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs.b.add(paramString1);
        }
      }
      else if (paramInt1 == 1)
      {
        paramArticleInfo.mFirstPagePicUrl = "";
      }
    }
  }
  
  private boolean isPageShareInfoEmpty(int paramInt, String paramString, ArticleInfo paramArticleInfo)
  {
    return (paramInt == 23) && ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(paramArticleInfo.mSubscribeName)));
  }
  
  private void jumpUrl(Context paramContext, String paramString, Bundle paramBundle)
  {
    pha.a(paramContext, paramString, paramBundle);
  }
  
  private void onFetchUserInfoSuccess(ReadInJoyUserInfo paramReadInJoyUserInfo, String paramString)
  {
    if (paramReadInJoyUserInfo == null)
    {
      QLog.e(TAG, 1, "[onLoadUserInfoSucceed]: userInfo is null");
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", Long.parseLong(paramReadInJoyUserInfo.uin)).put("nickName", paramReadInJoyUserInfo.nick).put("headUrl", ReadInJoyUserInfoModule.a(paramReadInJoyUserInfo));
      invokeJS(paramString, localJSONObject);
      return;
    }
    catch (JSONException paramReadInJoyUserInfo)
    {
      ViolaLogUtils.e(TAG, paramReadInJoyUserInfo.getMessage());
    }
  }
  
  private void performBiu(ArticleInfo paramArticleInfo, JSONObject paramJSONObject, Intent paramIntent, long paramLong1, long paramLong2, int paramInt1, String paramString, int paramInt2)
  {
    int i = paramJSONObject.optInt("hiddenBiuComponent");
    String str = "";
    if (i == 1) {
      str = new String(bgku.decode(paramJSONObject.optString("newComment"), 2));
    }
    if (i == 1)
    {
      paramJSONObject = str;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy.jdField_a_of_type_JavaUtilList != null)
      {
        paramJSONObject = str;
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy.jdField_a_of_type_JavaUtilList.size() > 0) {
          paramJSONObject = str + "//";
        }
      }
      paramJSONObject = "：" + paramJSONObject;
      paramIntent = (QQAppInterface)pha.a();
      if (paramIntent != null) {
        ((pmm)paramIntent.getManager(163)).a().a(pha.a(), paramLong1, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy, 0L, paramJSONObject, paramLong2, -1L, paramInt1, paramString, paramInt2, paramArticleInfo);
      }
      return;
    }
    if (paramJSONObject.optInt("hideSuccessToast") == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramIntent.putExtra("hideSuccessToast", bool);
      BaseActivity.sTopActivity.startActivityForResult(paramIntent, 113);
      BaseActivity.sTopActivity.overridePendingTransition(0, 0);
      return;
    }
  }
  
  private void registerActivityResultAction()
  {
    this.mResultActionMap.put(114, new top(this));
    this.mResultActionMap.put(115, new top(this));
    this.mResultActionMap.put(116, new top(this));
    this.mResultActionMap.put(122, new top(this));
    this.mResultActionMap.put(113, new tok(this));
    this.mResultActionMap.put(119, new tor(this));
    this.mResultActionMap.put(118, new tow(this));
    this.mResultActionMap.put(121, new tow(this));
    this.mResultActionMap.put(117, new ton(this));
    this.mResultActionMap.put(126, new too(this));
    this.mResultActionMap.put(21, new toq(this));
    this.mResultActionMap.put(123, new tos(this));
    this.mResultActionMap.put(124, new toj(this));
    this.mResultActionMap.put(101, new tot(this));
    this.mResultActionMap.put(125, new tov(this));
  }
  
  private void responseUploadingVideoList(long paramLong, @NotNull List<UgcVideo> paramList, String paramString1, int paramInt, String paramString2)
  {
    responseUploadingVideoList(paramLong, paramList, paramString1, paramInt, paramString2, false);
  }
  
  private void responseUploadingVideoList(long paramLong, @NotNull List<UgcVideo> paramList, String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    ThreadManagerV2.excute(new BridgeModule.36(this, paramList, paramInt, paramString2, paramBoolean, paramString1), 16, null, false);
  }
  
  public static void saveImageToLocal(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      try
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("?client=androidQQ");
        ((StringBuilder)localObject).append("&version=8.4.1.4680");
        ((StringBuilder)localObject).append("&system=" + Build.VERSION.RELEASE);
        ((StringBuilder)localObject).append("&device=" + Build.DEVICE);
        ((StringBuilder)localObject).append("&uin=" + pha.a());
        paramString = arpm.a("VIP_xingying", ((StringBuilder)localObject).toString());
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "saveImageToLocal imageUrl=" + paramString);
        }
        localObject = System.currentTimeMillis() + ".jpg";
        ThreadManager.executeOnNetWorkThread(new BridgeModule.16(paramString, new File(bhgg.a(anhk.bg), (String)localObject)));
        return;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e(TAG, 2, "saveImageToLocal imageUrl error=" + paramString.getMessage());
  }
  
  private void selectAndUploadAvatar(JSONObject paramJSONObject, String paramString)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity == null) {
      return;
    }
    int n = paramJSONObject.optInt("type", 1);
    int j;
    if (paramJSONObject.has("width")) {
      j = paramJSONObject.optInt("width");
    }
    for (int i = bggq.a(localBaseActivity, j / 2);; i = 640)
    {
      int m;
      if (paramJSONObject.has("height")) {
        m = paramJSONObject.optInt("height");
      }
      for (int k = bggq.a(localBaseActivity, m / 2);; k = 640)
      {
        selectPhotoFromGallery(1, n, (byte)118, i, k, j, m, paramString);
        return;
        m = 640;
      }
      j = 640;
    }
  }
  
  private void selectPhotoFromGallery(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString)
  {
    Object localObject = (QQAppInterface)pha.a();
    Activity localActivity = getViolaInstance().getActivity();
    if ((localObject != null) && (localActivity != null))
    {
      localObject = new Intent(localActivity, NewPhotoListActivity.class);
      ((Intent)localObject).putExtra("enter_from", 25);
      ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ReadInJoyUploadAvatarFragment.class.getName());
      ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      ((Intent)localObject).putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
      ((Intent)localObject).putExtra("PhotoConst.IS_SINGLE_MODE", true);
      ((Intent)localObject).putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
      ((Intent)localObject).putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
      ((Intent)localObject).putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      ((Intent)localObject).putExtra("key_from_kandian_uploadimg", true);
      String str = bhgg.a(anhk.ba + "readinjoy_avatar_upload/");
      ((Intent)localObject).putExtra("PhotoConst.TARGET_PATH", str + System.currentTimeMillis() + ".jpg");
      ((Intent)localObject).putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      ((Intent)localObject).putExtra("PhotoConst.CLIP_WIDTH", paramInt3);
      ((Intent)localObject).putExtra("PhotoConst.CLIP_HEIGHT", paramInt4);
      ((Intent)localObject).putExtra("PhotoConst.TARGET_WIDTH", paramInt5);
      ((Intent)localObject).putExtra("PhotoConst.TARGET_HEIGHT", paramInt6);
      ((Intent)localObject).putExtra("from", paramInt1);
      ((Intent)localObject).putExtra("type", paramInt2);
      ((Intent)localObject).putExtra("finish", true);
      ((Intent)localObject).putExtra("callbackId", paramString);
      localActivity.startActivityForResult((Intent)localObject, paramByte);
      bgkc.anim(localActivity, false, true);
    }
  }
  
  public static void unRegisterReceiver()
  {
    if ((BaseApplicationImpl.getContext() != null) && (mGdtAppReceiver != null))
    {
      BaseApplicationImpl.getContext().unregisterReceiver(mGdtAppReceiver);
      mGdtAppReceiver = null;
    }
  }
  
  private void uploadTopicPic(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = BaseActivity.sTopActivity;
    if (localObject == null) {}
    int n;
    int i;
    int j;
    int k;
    int m;
    do
    {
      return;
      localObject = ((Context)localObject).getResources().getDisplayMetrics();
      n = paramJSONObject.optInt("type");
      i = Utils.rp2px(((DisplayMetrics)localObject).widthPixels, 360.0D);
      j = Utils.rp2px(((DisplayMetrics)localObject).widthPixels, 200.0D);
      k = 750;
      m = 416;
      if (n == 1)
      {
        j = Utils.rp2px(((DisplayMetrics)localObject).widthPixels, 360.0D);
        m = 160;
        k = 160;
        i = j;
      }
    } while ((n != 1) && (n != 2));
    selectPhotoFromGallery(2, 0, (byte)121, i, j, k, m, paramString);
  }
  
  public void addEventListener(JSONObject paramJSONObject, String paramString)
  {
    ensureEventHelper();
    this.mEventHelper.a(paramJSONObject, paramString);
  }
  
  @JSMethod
  public void addFavorite(JSONObject paramJSONObject)
  {
    Object localObject = (QQAppInterface)pha.a();
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    Bundle localBundle;
    if (localObject != null)
    {
      str1 = paramJSONObject.optString("rowkey", "");
      str2 = paramJSONObject.optString("article_title", "");
      str3 = paramJSONObject.optString("article_title", "");
      str4 = paramJSONObject.optString("first_page_url", "");
      i = paramJSONObject.optInt("duration", 0);
      str5 = paramJSONObject.optString("article_url", "") + "&sourcefrom=6";
      int j = paramJSONObject.optInt("publishAccountUin", 0);
      String str6 = paramJSONObject.optString("publishAccountName", "");
      localObject = ((QQAppInterface)localObject).getAccount();
      localBundle = new Bundle();
      localBundle.putInt("videoDuration", i);
      localBundle.putLong("publishAccountUin", j);
      localBundle.putString("publishAccountName", str6);
      if (paramJSONObject.optInt("busiType", 6) != 6) {
        break label221;
      }
    }
    label221:
    for (int i = 1;; i = 2)
    {
      localBundle.putInt("videoType", i);
      pvl.a().a(getViolaInstance().getActivity(), (String)localObject, 2, str1, str2, str3, str4, str5, localBundle, true);
      return;
    }
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
      QLog.e(TAG, 1, "arouseReadInJoyNativeCommentView Exception:", paramJSONObject);
    }
  }
  
  public void batchCheckUpdate(JSONObject paramJSONObject, String paramString)
  {
    int i = 0;
    paramJSONObject = paramJSONObject.optJSONArray("bids");
    ArrayList localArrayList;
    if (paramJSONObject != null) {
      localArrayList = new ArrayList();
    }
    try
    {
      while (i < paramJSONObject.length())
      {
        localArrayList.add(i, paramJSONObject.get(i).toString());
        i += 1;
      }
      nko.a(localArrayList, pha.a(), new tnf(this, paramString), true, false);
      return;
    }
    catch (Exception paramJSONObject)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(TAG, 2, "batchCheckUpdate error" + paramJSONObject.getMessage());
      invokeErrorCallJS(paramString, null);
    }
  }
  
  @JSMethod
  public void c2sReport(JSONObject paramJSONObject)
  {
    try
    {
      acqy.a(TAG, paramJSONObject.toString());
      acre.a(paramJSONObject.optInt("operationType"), paramJSONObject.optInt("businessType"), (qq_ad_get.QQAdGetRsp.AdInfo)acqx.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramJSONObject.getJSONObject("adInfo")));
      return;
    }
    catch (Exception paramJSONObject)
    {
      acqy.d(TAG, "handleJsCallRequest", paramJSONObject);
    }
  }
  
  public void callback(Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getString("action");
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
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public void canOpenPage(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = paramJSONObject.optString("url");
    if (TextUtils.isEmpty(paramJSONObject)) {}
    BaseActivity localBaseActivity;
    do
    {
      return;
      localBaseActivity = BaseActivity.sTopActivity;
    } while (localBaseActivity == null);
    tlg.a(localBaseActivity, paramJSONObject, new tnd(this, paramString));
  }
  
  @JSMethod
  public void cancelUploadingVideo(JSONObject paramJSONObject, String paramString)
  {
    String str = paramJSONObject.optString("vid");
    int i = paramJSONObject.optInt("pageType");
    int j = paramJSONObject.optInt("topicId");
    QLog.i(TAG, 1, "cancelUploadingVideo, content=" + paramJSONObject.toString() + ",callbackId=" + paramString);
    paramJSONObject = pha.a();
    if (paramJSONObject != null) {
      rps.a(paramJSONObject).a(j, new tnt(this, str, paramJSONObject, i, j, paramString));
    }
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
    paramString1 = bisz.a("QQ_" + pha.a() + "_" + paramString1).toLowerCase();
    if (getViolaInstance() != null) {
      ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), getModuleName(), "callback", paramString2, paramString1, true);
    }
  }
  
  @JSMethod
  public void chooseVideoAddToTopic(JSONObject paramJSONObject, String paramString)
  {
    QLog.i(TAG, 1, "chooseVideoAddToTopic, callback = " + paramString + ", jsonObject = " + paramJSONObject.toString());
    JSONArray localJSONArray = paramJSONObject.optJSONArray("videoList");
    ArrayList localArrayList = new ArrayList();
    JSONObject localJSONObject = new JSONObject();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < localJSONArray.length())
        {
          String str = localJSONArray.getString(i);
          if (!TextUtils.isEmpty(str)) {
            localArrayList.add(str);
          } else {
            QLog.i(TAG, 1, "chooseVideoAddToTopic index = " + i + "rowkey is empty.");
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        invokeJS(paramString, localJSONObject);
        QLog.e(TAG, 1, "chooseVideoAddToTopic error! e = " + paramJSONObject.toString());
        return;
      }
      i = paramJSONObject.optInt("topicId");
      if ((!localArrayList.isEmpty()) && (i != 0))
      {
        rog.a(localArrayList, i, new tno(this, localJSONObject, paramString));
        return;
      }
      localJSONObject.put("errCode", -1);
      localJSONObject.put("errMsg", "rowkeys.isEmpty() || columnId == 0");
      invokeJS(paramString, localJSONObject);
      return;
      i += 1;
    }
  }
  
  @JSMethod
  public void clearMessageBoxData()
  {
    pmk.a().e();
  }
  
  @JSMethod
  public void closeTopicVideoComment()
  {
    this.mCommentManager.c();
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
    QQAppInterface localQQAppInterface = pha.a();
    if (localQQAppInterface != null) {
      rps.a(localQQAppInterface).b(this.videoPublishCallback);
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "destroy by instance");
    }
    if (this.dataManager != null) {
      this.dataManager.a();
    }
  }
  
  public void detailLog(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = (QQAppInterface)pha.a();
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localObject == null) || (localBaseActivity == null)) {}
    StringBuilder localStringBuilder1;
    label243:
    label255:
    do
    {
      return;
      localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = localStringBuilder1.append(paramJSONObject.optString("id")).append("|").append(paramJSONObject.optString("subid")).append("|").append(paramJSONObject.optString("content")).append("|").append("ANDROID").append("|").append("8.4.1.4680").append("|").append(bgln.e()).append("|").append(((QQAppInterface)localObject).getCurrentAccountUin()).append("|").append(Build.MODEL).append("|");
      if (TextUtils.isEmpty(bgln.a(localBaseActivity).jdField_c_of_type_JavaLangString))
      {
        localObject = "未知";
        localStringBuilder2 = localStringBuilder2.append((String)localObject).append("|");
        if (!TextUtils.isEmpty(bgln.a(localBaseActivity).jdField_a_of_type_JavaLangString)) {
          break label243;
        }
      }
      for (localObject = "未知";; localObject = bgln.a(localBaseActivity).jdField_a_of_type_JavaLangString)
      {
        localStringBuilder2.append((String)localObject);
        if (!paramJSONObject.optBoolean("isall", false)) {
          break label255;
        }
        QLog.w("ViolaLog", 1, localStringBuilder1.toString());
        invokeCallJS(paramString, null);
        return;
        localObject = bgln.a(localBaseActivity).jdField_c_of_type_JavaLangString;
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("ViolaLog", 2, localStringBuilder1.toString());
    invokeCallJS(paramString, null);
  }
  
  public void dispatchEvent(JSONObject paramJSONObject, String paramString)
  {
    ensureEventHelper();
    this.mEventHelper.c(paramJSONObject, paramString);
  }
  
  public void doSelectAndUploadAvatar(JSONObject paramJSONObject, String paramString)
  {
    this.mUploadCallBack = paramString;
    selectAndUploadAvatar(paramJSONObject, paramString);
  }
  
  public void doUploadTopicPic(JSONObject paramJSONObject, String paramString)
  {
    this.mUploadCallBack = paramString;
    uploadTopicPic(paramJSONObject, paramString);
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
        this.mDownloadListener = new tna(this, str, paramString);
      }
      bisa.a().a(this.mDownloadListener);
      localDownloadInfo.a();
      bisa.a().b(localDownloadInfo);
    }
  }
  
  public void downloadApkAction(JSONObject paramJSONObject)
  {
    int i;
    if ((paramJSONObject != null) && (paramJSONObject.optString("apkUrl") != null) && (paramJSONObject.optInt("action", -1) != -1))
    {
      i = paramJSONObject.optInt("action", -1);
      if (i != 1) {
        break label44;
      }
      downloadApkPause(paramJSONObject);
    }
    label44:
    do
    {
      return;
      if (i == 2)
      {
        downloadApkResume(paramJSONObject);
        return;
      }
    } while (i != 3);
    downloadApkCancel(paramJSONObject);
  }
  
  public void downloadApkCancel(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("apkUrl"))))
    {
      paramJSONObject = paramJSONObject.optString("apkUrl");
      bisa.a().b(paramJSONObject, true);
    }
  }
  
  public void downloadApkPause(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("apkUrl"))))
    {
      paramJSONObject = paramJSONObject.optString("apkUrl");
      bisa.a().a(paramJSONObject);
    }
  }
  
  public void downloadApkResume(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("apkUrl"))))
    {
      paramJSONObject = paramJSONObject.optString("apkUrl");
      DownloadInfo localDownloadInfo = new DownloadInfo();
      localDownloadInfo.d = paramJSONObject;
      localDownloadInfo.m = "biz_src_feeds_kandianads";
      localDownloadInfo.a();
      bisa.a().b(localDownloadInfo);
    }
  }
  
  public void downloadApp(String paramString)
  {
    Context localContext = getViolaInstance().getContext();
    if ((localContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      Object localObject = ucb.b(paramString);
      if (localObject != null)
      {
        ((DownloadInfo)localObject).a();
        bisa.a().b((DownloadInfo)localObject);
        return;
      }
      try
      {
        paramString = new JSONObject(paramString);
        localObject = new Intent(localContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("big_brother_source_key", pha.f(0));
        ((Intent)localObject).putExtra("url", paramString.optString("url"));
        localContext.startActivity((Intent)localObject);
        return;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e(TAG, 2, "downloadApp error" + paramString.getMessage());
  }
  
  public void downloadForGooglePlay(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addCategory("android.intent.category.BROWSABLE");
      localIntent.setData(Uri.parse(paramString));
      paramString = BaseActivity.sTopActivity;
      if (paramString != null) {
        paramString.startActivity(localIntent);
      }
    }
  }
  
  @JSMethod
  public void dwellTimeMillisReport(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("dwellTimeMillis");
      paramJSONObject = (qq_ad_get.QQAdGetRsp.AdInfo)acqx.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramJSONObject.getJSONObject("adInfo"));
      acrd localacrd = new acrd();
      localacrd.jdField_a_of_type_ComTencentAdTangramAd = new GdtAd(paramJSONObject);
      localacrd.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.set(42);
      localacrd.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(i);
      acrc.a(localacrd);
      return;
    }
    catch (Exception paramJSONObject)
    {
      acqy.d(TAG, "handleJsCallRequest", paramJSONObject);
    }
  }
  
  public void feedsRefreshMessage(JSONObject paramJSONObject)
  {
    qqm.a().a(paramJSONObject);
  }
  
  @JSMethod
  public void fetchReadInJoyAccountInfoList(JSONObject paramJSONObject, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramJSONObject == null)) {}
    ReadInJoyUserInfoModule localReadInJoyUserInfoModule;
    ArrayList localArrayList;
    do
    {
      do
      {
        do
        {
          return;
          localReadInJoyUserInfoModule = pha.a();
        } while (localReadInJoyUserInfoModule == null);
        paramJSONObject = paramJSONObject.optJSONArray("uins");
      } while (paramJSONObject == null);
      localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJSONObject.length())
      {
        String str = paramJSONObject.optString(i);
        if (!TextUtils.isEmpty(str)) {
          localArrayList.add(str);
        }
        i += 1;
      }
    } while (localArrayList.isEmpty());
    localReadInJoyUserInfoModule.a(localArrayList, new tof(this, localArrayList, paramString));
  }
  
  @JSMethod
  public void fetchReadInJoyUserInfo(String paramString)
  {
    try
    {
      ReadInJoyUserInfoModule.a(pha.a(), new toe(this, paramString), true);
      return;
    }
    catch (Exception paramString)
    {
      ViolaLogUtils.e(TAG, paramString.getMessage());
    }
  }
  
  public void fireGetLocation(JSONObject paramJSONObject, String paramString)
  {
    int i = -1;
    if (paramJSONObject != null) {
      i = ViolaUtils.getInt(Integer.valueOf(paramJSONObject.optInt("allowCacheTime")));
    }
    if (hasAuthorizeLocation())
    {
      if (i > 0)
      {
        fireGetLocationFromCache("webview", paramString);
        return;
      }
      fireGetLocationFromSso("webview", paramString);
      return;
    }
    fireLocationErrorCallback(paramString, "no authorize");
  }
  
  @JSMethod(uiThread=false)
  public void getALDConfig(JSONObject paramJSONObject, String paramString)
  {
    if ((!TextUtils.isEmpty(paramJSONObject.optString("key", ""))) && (paramJSONObject.has("id")) && (!TextUtils.isEmpty(paramString))) {
      paramJSONObject = Aladdin.getConfig(paramJSONObject.optInt("id")).getString(paramJSONObject.optString("key", ""), "");
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("value", paramJSONObject);
      ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), getModuleName(), "callback", paramString, localJSONObject, true);
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
  
  public void getBiuTriggerType(JSONObject paramJSONObject, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (ouh.a() == 1)
        {
          paramJSONObject = "fastBiu";
          String str;
          if (ouh.b() == 1)
          {
            str = "fastBiu";
            localJSONObject.put("retCode", 0);
            localJSONObject.put("click", paramJSONObject);
            localJSONObject.put("longClick", str);
            if (!TextUtils.isEmpty(paramString)) {
              invokeCallJS(paramString, localJSONObject);
            }
          }
          else
          {
            str = "normalBiu";
            continue;
          }
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e(TAG, 1, "[getBiuTriggerType] ", paramJSONObject);
      }
      paramJSONObject = "normalBiu";
    }
  }
  
  public void getCUKingStatus(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", bhhb.a());
      invokeCallJS(paramString, localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e(TAG, 1, "getCUKingStatus error e = ", paramString);
    }
  }
  
  public void getClientInfo(String paramString)
  {
    Object localObject = BaseActivity.sTopActivity;
    if (localObject == null) {
      return;
    }
    localObject = bgln.a((Context)localObject);
    String str = bgln.c();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("qqVersion", str);
      localJSONObject.put("qqBuild", localObject);
      invokeCallJS(paramString, localJSONObject);
      return;
    }
    catch (JSONException paramString) {}
  }
  
  public void getClipboard(String paramString)
  {
    Object localObject = BaseActivity.sTopActivity;
    if (localObject == null) {}
    do
    {
      do
      {
        return;
        localObject = ((ClipboardManager)((Context)localObject).getSystemService("clipboard")).getPrimaryClip();
      } while (localObject == null);
      localObject = ((ClipData)localObject).getItemAt(0).getText().toString();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("result", localObject);
        invokeCallJS(paramString, localJSONObject);
        return;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e(TAG, 2, "getClipboard error" + paramString.getMessage());
  }
  
  @JSMethod
  public void getCreateTopicPermission(JSONObject paramJSONObject, String paramString)
  {
    getReadInJoyUgcPermission(paramJSONObject, paramString, 1);
  }
  
  protected JSONObject getDeviceInfo()
  {
    JSONObject localJSONObject = new JSONObject();
    String str1 = bgln.f();
    String str2 = bgln.a();
    try
    {
      localJSONObject.put("imsi", pha.i());
      localJSONObject.put("androidID", str1);
      localJSONObject.put("identifier", str2);
      localJSONObject.put("qimei", UserAction.getQIMEI());
      localJSONObject.put("qua", blsb.a());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  @JSMethod(uiThread=false)
  public void getDeviceInfo(String paramString)
  {
    getDeviceInfo(paramString, false);
  }
  
  public void getDeviceInfo(String paramString, boolean paramBoolean)
  {
    JSONObject localJSONObject = getDeviceInfo();
    if (paramBoolean)
    {
      invokeCallJS(paramString, localJSONObject);
      return;
    }
    ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), getModuleName(), "callback", paramString, localJSONObject, true);
  }
  
  public void getDownloadApkState(JSONObject paramJSONObject, String paramString)
  {
    Object localObject;
    int j;
    int i;
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("apkUrl"))))
    {
      paramJSONObject = paramJSONObject.optString("apkUrl");
      localObject = bisa.a().b(paramJSONObject);
      j = -1;
      i = 0;
      if (localObject != null)
      {
        j = ((DownloadInfo)localObject).a();
        i = ((DownloadInfo)localObject).f;
      }
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("state", j);
      ((JSONObject)localObject).put("data", i);
      invokeCallJS(paramString, localObject);
      ViolaLogUtils.d(TAG, "downloadApk getDownloadApkState :" + j + " ,apkUrl : " + paramJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ViolaLogUtils.e("downloadApk", "getDownloadApkState error:" + paramString.getMessage());
      }
    }
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
    AdThreadManager.INSTANCE.post(new BridgeModule.6(this, paramJSONObject, paramBoolean, paramString), 4);
  }
  
  public void getGdtInfo(String paramString)
  {
    ThreadManager.post(new BridgeModule.11(this, paramString), 8, null, true);
  }
  
  @JSMethod
  public void getMotiveAd(String paramString, JSONObject paramJSONObject)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    paramString = new toh(this, paramString);
    if (localBaseActivity == null)
    {
      paramString.onAdFailedToLoad(null, new ackn(5));
      return;
    }
    String str = paramJSONObject.optString("posId", "1041305064862972");
    long l1 = paramJSONObject.optLong("publicId", 0L);
    long l2 = paramJSONObject.optLong("articleId", 0L);
    int i = paramJSONObject.optInt("sourceFrom", 0);
    int j = paramJSONObject.optInt("shareRate", 0);
    oql.a().a(localBaseActivity, str, l1, l2, i, j, paramString);
  }
  
  @JSMethod(uiThread=false)
  public void getNetType(String paramString)
  {
    getNetType(paramString, false);
  }
  
  public void getNetType(String paramString, boolean paramBoolean)
  {
    int i = nlw.a();
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getNetType,netType:" + i);
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("result", i);
      label56:
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
      break label56;
    }
  }
  
  public JSONObject getNetworkInfo()
  {
    int k = nlw.a();
    String str = nlw.a();
    int j = 0;
    Object localObject = bgln.b();
    int i = j;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      i = j;
      if (((String)localObject).length() > 5)
      {
        i = j;
        if (((String)localObject).startsWith("460"))
        {
          localObject = ((String)localObject).substring(3, 5);
          if ((!((String)localObject).equals("00")) && (!((String)localObject).equals("02")) && (!((String)localObject).equals("04")) && (!((String)localObject).equals("07"))) {
            break label147;
          }
          i = 1;
        }
      }
    }
    for (;;)
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("type", k);
        ((JSONObject)localObject).put("radio", str);
        ((JSONObject)localObject).put("carriertype", i);
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        label147:
        localJSONException.printStackTrace();
      }
      if ((((String)localObject).equals("01")) || (((String)localObject).equals("06")) || (((String)localObject).equals("09")))
      {
        i = 2;
      }
      else if ((((String)localObject).equals("03")) || (((String)localObject).equals("05")))
      {
        i = 3;
      }
      else
      {
        i = j;
        if (((String)localObject).equals("20")) {
          i = 4;
        }
      }
    }
    return localObject;
  }
  
  public void getNetworkInfo(String paramString, boolean paramBoolean)
  {
    invokeCallJS(paramString, getNetworkInfo());
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
    JSONObject localJSONObject = new JSONObject();
    QQAppInterface localQQAppInterface = (QQAppInterface)pha.a();
    if (localQQAppInterface != null) {}
    for (;;)
    {
      boolean bool;
      try
      {
        long l = paramJSONObject.optLong("uin", 0L);
        if ((l == 0L) || (l != localQQAppInterface.getLongAccountUin()))
        {
          localJSONObject.put("hasPermission", 0);
          invokeJS(paramString, localJSONObject);
          return;
        }
        if (paramInt != 1) {
          break label138;
        }
        bool = rjh.c();
      }
      catch (JSONException paramJSONObject)
      {
        invokeJS(paramString, localJSONObject);
        QLog.e(TAG, 1, "BridgeModule: getReadInJoyUgcPermission type =" + paramInt + paramJSONObject.toString());
        return;
      }
      localJSONObject.put("hasPermission", i);
      continue;
      label138:
      if (paramInt == 2) {
        bool = rjh.d();
      }
      while (!bool)
      {
        i = 0;
        break;
        QLog.e(TAG, 1, "BridgeModule: getReadInJoyUgcPermission app is null!");
        return;
        bool = false;
      }
      int i = 1;
    }
  }
  
  public void getRecommendFlag(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("recommendFlag", getRecommendFlag());
      invokeCallJS(paramString, localJSONObject);
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
    QLog.i(TAG, 1, "getUploadingVideoInfo,callback=" + paramString + ", content=" + paramJSONObject.toString());
    int i = paramJSONObject.optInt("topicId");
    this.columnToUploadCallbackMap.put(Long.valueOf(i), paramString);
    paramJSONObject = pha.a();
    if (paramJSONObject != null) {
      rps.a(paramJSONObject).a(this.videoPublishCallback);
    }
    if (this.violaVideoUpdateController == null) {
      this.violaVideoUpdateController = new rqh(new BridgeModule.30(this, i, paramString), 500L);
    }
    this.violaVideoUpdateController.a();
  }
  
  protected JSONObject getUserInfo()
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject3 = (QQAppInterface)pha.a();
    String str;
    if (localObject3 != null)
    {
      localObject1 = (TicketManager)((QQAppInterface)localObject3).getManager(2);
      str = ((QQAppInterface)localObject3).getAccount();
      if (localObject1 == null) {
        break label131;
      }
    }
    label131:
    Object localObject2;
    for (Object localObject1 = ((TicketManager)localObject1).getSkey(((QQAppInterface)localObject3).getCurrentAccountUin());; localObject2 = null)
    {
      localObject3 = getNickName((QQAppInterface)localObject3, str);
      try
      {
        localJSONObject.put("uin", str);
        localJSONObject.put("skey", localObject1);
        localJSONObject.put("nick", localObject3);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e(TAG, 2, "getReportInfo() JSONException" + localJSONException.getMessage());
        return localJSONObject;
      }
    }
  }
  
  @JSMethod(uiThread=false)
  public void getUserInfo(String paramString)
  {
    getUserInfo(paramString, false);
  }
  
  public void getUserInfo(String paramString, boolean paramBoolean)
  {
    JSONObject localJSONObject;
    if (!TextUtils.isEmpty(paramString))
    {
      localJSONObject = getUserInfo();
      if (paramBoolean) {
        invokeCallJS(paramString, localJSONObject);
      }
    }
    else
    {
      return;
    }
    ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), getModuleName(), "callback", paramString, localJSONObject, true);
  }
  
  @JSMethod
  public void getUserLiveStatus(String paramString1, String paramString2)
  {
    try
    {
      ReadInJoyUserInfo localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(Long.parseLong(paramString1), null);
      if ((localReadInJoyUserInfo != null) && (localReadInJoyUserInfo.isLiving())) {}
      for (boolean bool = true;; bool = false)
      {
        paramString1 = "";
        if (localReadInJoyUserInfo != null) {
          paramString1 = localReadInJoyUserInfo.getLiveUrl();
        }
        invokeCallJS(paramString2, new JSONObject().put("isLiving", bool).put("liveUrl", paramString1));
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      ViolaLogUtils.e(TAG, paramString1.getMessage());
    }
  }
  
  @JSMethod
  public void getVideoFrameInfo(JSONObject paramJSONObject, String paramString)
  {
    Object localObject;
    float f;
    if (paramJSONObject != null)
    {
      localObject = getViolaInstance().getActivity();
      paramJSONObject = ryx.a((Activity)localObject, paramJSONObject.optInt("width"), paramJSONObject.optInt("height"));
      f = 750.0F / ryx.b(localObject)[0];
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("x", paramJSONObject.left * f);
      ((JSONObject)localObject).put("y", paramJSONObject.top * f);
      ((JSONObject)localObject).put("width", paramJSONObject.width() * f);
      ((JSONObject)localObject).put("height", f * paramJSONObject.height());
      invokeJS(paramString, (JSONObject)localObject);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  @JSMethod
  public void handleClick(JSONObject paramJSONObject)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    try
    {
      acqy.b(TAG, paramJSONObject.toString());
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
      paramJSONObject = (qq_ad_get.QQAdGetRsp.AdInfo)acqx.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramJSONObject.getJSONObject("adInfo"));
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
      acqy.d(TAG, "handleJsCallRequest error", paramJSONObject);
    }
  }
  
  @JSMethod
  public void hasApp(String paramString1, String paramString2)
  {
    hasApp(paramString1, paramString2, false);
  }
  
  public void hasApp(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 1;
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity == null) {
      return;
    }
    boolean bool;
    if (("weishi://feed".equals(paramString1)) || ("weishi".equals(paramString1))) {
      bool = zmi.a(localBaseActivity);
    }
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject();
        if (!bool) {
          break label124;
        }
        paramString1.put("result", i);
        if (!paramBoolean) {
          break label130;
        }
        invokeCallJS(paramString2, paramString1);
        return;
      }
      catch (JSONException paramString1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(TAG, 2, "hasApp error" + paramString1.getMessage());
      return;
      bool = bgnw.a(localBaseActivity, paramString1);
      continue;
      label124:
      i = 0;
    }
    label130:
    ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), getModuleName(), "callback", paramString2, paramString1, true);
  }
  
  public void hasRedPacketPermission(String paramString)
  {
    try
    {
      if (RIJRedPacketManager.a().c())
      {
        RIJRedPacketManager.a().a(2, new tnn(this, paramString));
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 0);
      invokeCallJS(paramString, localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e(TAG, 1, "isInkanDianTab exception e = ", paramString);
    }
  }
  
  public void hasRedPacketSharePermission(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (!bmqa.n()) {
          continue;
        }
        i = 1;
        localJSONObject.put("result", i);
      }
      catch (JSONException localJSONException)
      {
        int i;
        localJSONException.printStackTrace();
        continue;
      }
      invokeCallJS(paramString, localJSONObject);
      return;
      i = 0;
    }
  }
  
  @JSMethod
  public void hideFollowAlertView(JSONObject paramJSONObject, String paramString)
  {
    boolean bool = paramJSONObject.optBoolean("animated", true);
    qps.a.a().a(bool, "MATCH_ALL_UIN");
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
  public void invoke(JSONObject paramJSONObject, String paramString)
  {
    String str2 = paramJSONObject.optString("ns");
    String str3 = paramJSONObject.optString("method");
    if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)))
    {
      invokeErrorCallJS(paramString, anni.a(2131700006));
      QLog.d(TAG, 1, "ns or method not exists");
      return;
    }
    String str4 = TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("ns: ").append(str2).append(" method: ").append(str3).append(" params: ");
    if (paramJSONObject != null) {}
    for (String str1 = paramJSONObject.toString();; str1 = " null ")
    {
      QLog.d(str4, 1, str1);
      if (this.bridgeInvokeHandler.a(str2, str3, paramJSONObject, paramString)) {
        break;
      }
      invokeErrorCallJS(paramString, "ns:" + str2 + anni.a(2131700002) + str3 + anni.a(2131699997));
      return;
    }
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
  
  public void isInkanDianTab(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (ReadinjoyTabFrame.d_()) {}
      for (int i = 1;; i = 0)
      {
        localJSONObject.put("result", i);
        invokeCallJS(paramString, localJSONObject);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e(TAG, 1, "isInkanDianTab exception e = ", paramString);
    }
  }
  
  @JSMethod(uiThread=false)
  public void isKindCard(String paramString)
  {
    boolean bool = true;
    if (getViolaInstance() != null) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (bhhb.a() == 1)
        {
          localJSONObject.put("value", bool);
          ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), getModuleName(), "callback", paramString, localJSONObject, true);
          return;
        }
      }
      catch (JSONException paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(TAG, 2, "isKindCard error" + paramString.getMessage());
      }
      bool = false;
    }
  }
  
  public void isNightMode(String paramString)
  {
    int i = 0;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        i = 1;
      }
      localJSONObject.put("isNightMode", i);
      invokeCallJS(paramString, localJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
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
    tou localtou = (tou)this.mResultActionMap.get(paramInt1);
    if (localtou != null) {
      localtou.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    AbstractGifImage.resumeAll();
  }
  
  public void onClickBubbleTips(JSONObject paramJSONObject, String paramString)
  {
    if ((getViolaInstance() != null) && (getViolaInstance().getActivity() != null)) {
      RIJRedPacketManager.a().a(getViolaInstance().getActivity(), 4, paramJSONObject.optString("redPacketId"), paramJSONObject.optString("rowkey"), new toc(this, paramString), false, null);
    }
  }
  
  @JSMethod
  public void onColumnSubscribeStatusChange(JSONObject paramJSONObject)
  {
    long l = paramJSONObject.optLong("uin");
    int i = paramJSONObject.optInt("columnId");
    int j = paramJSONObject.optInt("action");
    int k = paramJSONObject.optInt("currentFollowCount");
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "onColumnAttentionStatusChange, uin=" + l + " columnId=" + i + " action=" + j + " subscribeCount=" + k);
    }
    if (l == pha.a())
    {
      pmk.a().a(i, j, k);
      return;
    }
    QLog.e(TAG, 1, "onColumnAttentionStatusChange current uin not equals to " + l);
  }
  
  public void openAccountPageMore(JSONObject paramJSONObject, String paramString)
  {
    Activity localActivity = getViolaInstance().getActivity();
    if ((paramJSONObject != null) && (localActivity != null)) {}
    try
    {
      long l = paramJSONObject.getLong("puin");
      paramJSONObject = new Intent(localActivity, AccountDetailActivity.class);
      paramJSONObject.putExtra("uin", "" + l);
      paramJSONObject.putExtra("from_js", true);
      localActivity.startActivity(paramJSONObject);
      invokeCallJS(paramString, null);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.d(TAG, 2, "openAccountPageMore->error:" + paramJSONObject);
    }
    invokeErrorCallJS(paramString, "params error");
    return;
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
    rjh.a(BaseActivity.sTopActivity, paramJSONObject, j, paramString, 124);
  }
  
  @JSMethod
  public void openApp(String paramString)
  {
    openApp(paramString, null, null);
  }
  
  public void openApp(String paramString1, String paramString2, String paramString3)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity == null) {}
    for (;;)
    {
      return;
      if (TextUtils.isEmpty(paramString1))
      {
        if (!TextUtils.isEmpty(paramString2)) {
          invokeErrorCallJS(paramString2, anni.a(2131699999));
        }
      }
      else
      {
        if ((paramString1.contains("weishi")) || (paramString1.contains("weishi://feed"))) {
          if (zmi.a(localBaseActivity)) {
            ucb.a(localBaseActivity, "video_type_videopublic");
          }
        }
        while (!TextUtils.isEmpty(paramString2))
        {
          invokeCallJS(paramString2, null);
          return;
          QQToast.a(localBaseActivity, -1, anni.a(2131700005), 0).b(localBaseActivity.getResources().getDimensionPixelSize(2131298998));
          ucb.b(localBaseActivity, "video_type_videopublic");
          continue;
          if (!oqj.a(localBaseActivity, paramString1))
          {
            Intent localIntent = new Intent();
            localIntent.setAction("android.intent.action.VIEW");
            String str = paramString3;
            if (TextUtils.isEmpty(paramString3)) {
              str = pha.f(0);
            }
            localIntent.putExtra("big_brother_source_key", str);
            localIntent.putExtra("big_brother_ref_source_key", pha.f(0));
            localIntent.setData(Uri.parse(paramString1));
            localBaseActivity.startActivity(localIntent);
          }
        }
      }
    }
  }
  
  @JSMethod
  public void openCreateTopicView(String paramString)
  {
    rjh.a(BaseActivity.sTopActivity, paramString, 123);
  }
  
  @JSMethod
  public void openEditTopicView(JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.optInt("topicId");
    String str1 = paramJSONObject.optString("iconUrl");
    String str2 = paramJSONObject.optString("title");
    String str3 = paramJSONObject.optString("intro");
    int j = paramJSONObject.optInt("submitPermission");
    rjh.a(BaseActivity.sTopActivity, i, str1, str2, str3, j, paramString, 123);
  }
  
  @JSMethod
  public void openMiniApp(String paramString, JSONObject paramJSONObject)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("res", 1);
      if (MiniAppLauncher.startMiniApp(localBaseActivity, paramJSONObject.optString("miniAppUrl"), 2103, null))
      {
        localJSONObject.put("res", 0);
        invokeCallJS(paramString, localJSONObject);
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      invokeCallJS(paramString, localJSONObject);
      return;
    }
    invokeCallJS(paramString, localJSONObject);
  }
  
  public void openPage(JSONObject paramJSONObject, String paramString)
  {
    paramString = paramJSONObject.optString("url");
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Bundle localBundle = new Bundle();
    if (paramJSONObject.optJSONObject("param") != null) {
      localBundle.putString("param", paramJSONObject.optJSONObject("param").toString());
    }
    tlg.a(BaseActivity.sTopActivity, "", paramString, localBundle);
  }
  
  public void openPrivateLetter()
  {
    Context localContext = getViolaInstance().getContext();
    if (localContext == null) {
      return;
    }
    Intent localIntent = new Intent(localContext, ReadInJoyMessagesActivity.class);
    localIntent.setFlags(67108864);
    localContext.startActivity(localIntent);
  }
  
  @JSMethod
  public void openTopicVideoComment(JSONObject paramJSONObject, String paramString)
  {
    Object localObject2 = paramJSONObject.optString("ref", "");
    Object localObject3 = ViolaSDKManager.getInstance().getDomManager();
    Object localObject1 = getViolaInstance();
    if ((localObject1 != null) && ((((ViolaInstance)localObject1).getActivity() instanceof FragmentActivity)))
    {
      localObject3 = ((ViolaDomManager)localObject3).getDomContext(getViolaInstance().getInstanceId()).getComponent((String)localObject2);
      localObject2 = (FragmentActivity)((ViolaInstance)localObject1).getActivity();
    }
    for (;;)
    {
      try
      {
        int i = bindCommentCallback(paramString);
        if (((FragmentActivity)localObject2).getIntent().getBundleExtra("bundle") == null)
        {
          paramString = new Bundle();
          ((FragmentActivity)localObject2).getIntent().putExtra("bundle", paramString);
        }
        ((FragmentActivity)localObject2).getIntent().getBundleExtra("bundle").putInt("seq", i);
        if (localObject3 != null)
        {
          paramString = ((VComponent)localObject3).getHostView();
          if (paramString == null) {
            continue;
          }
          localObject1 = paramString.findViewWithTag("VVideoView");
          if (!(localObject1 instanceof VVideoView)) {
            break label213;
          }
          localObject1 = (VVideoView)localObject1;
          doPostShowComment((FragmentActivity)localObject2, (VVideoView)localObject1, paramString, paramJSONObject);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(TAG, 2, paramJSONObject, new Object[0]);
        return;
      }
      paramString = null;
      continue;
      localObject1 = null;
      continue;
      label213:
      localObject1 = null;
    }
  }
  
  @JSMethod
  public void openUrl(String paramString, Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(paramString)) {
      jumpUrl(BaseActivity.sTopActivity, paramString, paramBundle);
    }
  }
  
  public void openUrl(JSONObject paramJSONObject, String paramString)
  {
    String str1;
    if (paramJSONObject != null)
    {
      str1 = paramJSONObject.optString("url");
      String str2 = paramJSONObject.optString("businessId", null);
      if (!TextUtils.isEmpty(str1))
      {
        if (TextUtils.isEmpty(str2)) {
          break label78;
        }
        paramJSONObject = new Bundle();
        paramJSONObject.putString("big_brother_source_key", str2);
        paramJSONObject.putString("big_brother_ref_source_key", pha.f(0));
      }
    }
    for (;;)
    {
      openUrl(str1, paramJSONObject);
      invokeCallJS(paramString, null);
      return;
      label78:
      paramJSONObject = null;
    }
  }
  
  @JSMethod
  public void openUrlByJumpInfo(JSONObject paramJSONObject)
  {
    if ((getViolaInstance() != null) && (getViolaInstance().getActivity() != null))
    {
      UrlJumpInfo localUrlJumpInfo = new UrlJumpInfo();
      localUrlJumpInfo.jdField_a_of_type_Int = paramJSONObject.optInt("jumpType", 1);
      localUrlJumpInfo.jdField_a_of_type_JavaLangString = paramJSONObject.optString("jumpUrl", "");
      localUrlJumpInfo.jdField_b_of_type_JavaLangString = paramJSONObject.optString("jumpBundle", "");
      localUrlJumpInfo.jdField_c_of_type_JavaLangString = paramJSONObject.optString("jumpSchema", "");
      localUrlJumpInfo.d = paramJSONObject.optString("clipboardInfo", "");
      localUrlJumpInfo.e = paramJSONObject.optString("commonData", "");
      ryx.a(getViolaInstance().getActivity(), localUrlJumpInfo);
    }
  }
  
  @JSMethod
  public void openVideo(JSONObject paramJSONObject)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null) {
      tlg.a(localBaseActivity, paramJSONObject);
    }
  }
  
  public void pageVisibility(String paramString)
  {
    Object localObject = getViolaInstance().getFragment();
    boolean bool;
    if (localObject != null)
    {
      bool = ((Fragment)localObject).getUserVisibleHint();
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("result", bool);
      invokeCallJS(paramString, localObject);
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(TAG, 2, "pageVisibility error" + paramString.getMessage());
    }
  }
  
  @JSMethod
  public void pauseUploadingVideo(JSONObject paramJSONObject, String paramString)
  {
    String str = paramJSONObject.optString("vid");
    int i = paramJSONObject.optInt("pageType");
    int j = paramJSONObject.optInt("topicId");
    QLog.i(TAG, 1, "pauseUploadingVideo, content=" + paramJSONObject.toString() + ",callbackId=" + paramString);
    paramJSONObject = pha.a();
    if (paramJSONObject != null) {
      rps.a(paramJSONObject).a(j, new tnr(this, str, paramJSONObject, i, j, paramString));
    }
  }
  
  @JSMethod
  public void performLikeAnimation(JSONObject paramJSONObject)
  {
    ViolaInstance localViolaInstance = getViolaInstance();
    if ((paramJSONObject == null) || (localViolaInstance == null) || (localViolaInstance.getRenderContainer() == null)) {
      return;
    }
    float f1 = FlexConvertUtils.converPxByViewportToRealPx(paramJSONObject.opt("pageX"), 750);
    float f2 = FlexConvertUtils.converPxByViewportToRealPx(paramJSONObject.opt("pageY"), 750);
    paramJSONObject = new VideoFeedsLikeAnimate(localViolaInstance.getRenderContainer(), f1, f2, new Random());
    paramJSONObject.a(5);
    paramJSONObject.a();
  }
  
  public void popBack(String paramString)
  {
    Fragment localFragment = getViolaInstance().getFragment();
    if (localFragment != null)
    {
      if (!(localFragment instanceof ViolaFragment)) {
        break label33;
      }
      ((ViolaFragment)localFragment).a();
    }
    for (;;)
    {
      invokeCallJS(paramString, null);
      return;
      label33:
      localFragment.getActivity().doOnBackPressed();
    }
  }
  
  @JSMethod(uiThread=true)
  public void popFromBottomStateChange(String paramString)
  {
    if ((getViolaInstance() != null) && ((getViolaInstance().getFragment() instanceof ViolaFragment))) {
      ((ViolaFragment)getViolaInstance().getFragment()).a(new tog(this, paramString));
    }
  }
  
  public void removeEventListener(JSONObject paramJSONObject, String paramString)
  {
    ensureEventHelper();
    this.mEventHelper.b(paramJSONObject, paramString);
  }
  
  public void reportT(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("code");
    Object localObject3 = paramJSONObject.optJSONObject("params");
    Object localObject1;
    Object localObject2;
    if ((!TextUtils.isEmpty(str)) && (localObject3 != null))
    {
      paramJSONObject = ((JSONObject)localObject3).optJSONObject("r2");
      localObject1 = ((JSONObject)localObject3).optJSONObject("r3");
      localObject2 = ((JSONObject)localObject3).optJSONObject("r4");
      localObject3 = ((JSONObject)localObject3).optJSONObject("r5");
      if (paramJSONObject == null) {
        break label124;
      }
      paramJSONObject = paramJSONObject.toString();
      if (localObject1 == null) {
        break label131;
      }
      localObject1 = ((JSONObject)localObject1).toString();
      label85:
      if (localObject2 == null) {
        break label138;
      }
      localObject2 = ((JSONObject)localObject2).toString();
      label94:
      if (localObject3 == null) {
        break label145;
      }
    }
    label131:
    label138:
    label145:
    for (localObject3 = ((JSONObject)localObject3).toString();; localObject3 = "")
    {
      oat.a(null, null, str, str, 0, 0, paramJSONObject, (String)localObject1, (String)localObject2, (String)localObject3, false);
      return;
      label124:
      paramJSONObject = "";
      break;
      localObject1 = "";
      break label85;
      localObject2 = "";
      break label94;
    }
  }
  
  public void reportVideoShareClick(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, String paramString3, String paramString4, String paramString5)
  {
    String str = "";
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("network", pfe.a(getViolaInstance().getActivity()));
        localJSONObject.put("os", "1");
        localJSONObject.put("uin", String.valueOf(pha.a()));
        localJSONObject.put("rowkey", paramString1);
        if (paramInt1 >= 0) {
          localJSONObject.put("source", String.valueOf(paramInt1));
        }
        localJSONObject.put("version", och.jdField_a_of_type_JavaLangString);
        localJSONObject.put("vid", paramString2);
        if (paramBoolean) {
          localJSONObject.put("cancel", "1");
        }
        if (paramInt2 >= 0) {
          localJSONObject.put("sourcefrom", String.valueOf(paramInt2));
        }
        if (paramInt3 >= 0) {
          localJSONObject.put("share_unit", String.valueOf(paramInt3));
        }
        if (paramInt4 != 4) {
          continue;
        }
        localJSONObject.put("type", 3);
        paramString1 = localJSONObject.toString();
      }
      catch (Exception paramString2)
      {
        JSONObject localJSONObject;
        paramString1 = str;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(TAG, 2, "shareReport:" + paramString2.toString());
        paramString1 = str;
        continue;
        if (paramInt4 != 11) {
          continue;
        }
        oat.a(null, "", "0X8009546", "0X8009546", 0, 0, "", paramString5, "", paramString1.a().a(), false);
      }
      paramString1 = new skc(paramString1);
      if (paramInt4 != 4) {
        continue;
      }
      oat.a(null, "", "0X8009546", "0X8009546", 0, 0, "", paramString4, paramString3, paramString1.a().a(), false);
      return;
      if (paramInt4 == 11) {
        localJSONObject.put("type", 4);
      }
    }
  }
  
  public void requestBubbleTipsWording(JSONObject paramJSONObject, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramJSONObject != null)) {
      RIJRedPacketManager.a().a(paramJSONObject.optString("rowkey"), paramJSONObject.optString("redPacketId"), 4, new toa(this, paramString));
    }
  }
  
  public void requestRedPacketContentShareToast(String paramString)
  {
    QLog.i(TAG, 1, "request yyy_0xe36");
    cmd0xe36.ReqBody localReqBody = new cmd0xe36.ReqBody();
    localReqBody.nothing.set(1);
    nir.a(pha.a(), new tnz(this, paramString), localReqBody.toByteArray(), "OidbSvc.0xe36", 3638, 1, new Bundle(), 5000L);
  }
  
  public void resetSatusBarBlackStyle()
  {
    Fragment localFragment = getViolaInstance().getFragment();
    if ((localFragment != null) && ((localFragment instanceof ViolaFragment))) {
      ((ViolaFragment)localFragment).a(Boolean.valueOf(false), true);
    }
  }
  
  public void resetSatusBarWhiteStyle()
  {
    Fragment localFragment = getViolaInstance().getFragment();
    if ((localFragment != null) && ((localFragment instanceof ViolaFragment))) {
      ((ViolaFragment)localFragment).a(Boolean.valueOf(false), true);
    }
  }
  
  @JSMethod
  public void resumeUploadingVideo(JSONObject paramJSONObject, String paramString)
  {
    String str = paramJSONObject.optString("vid");
    int i = paramJSONObject.optInt("pageType");
    int j = paramJSONObject.optInt("topicId");
    QLog.i(TAG, 1, "resumeUploadingVideo, vid=" + str + "pageType=" + i);
    paramJSONObject = pha.a();
    if (paramJSONObject != null) {
      rps.a(paramJSONObject).a(j, new tnu(this, str, paramJSONObject, i, j, paramString));
    }
  }
  
  public void saveImage(JSONObject paramJSONObject, String paramString)
  {
    Activity localActivity = getViolaInstance().getActivity();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    if (!CheckPermission.isHasStoragePermission(localActivity))
    {
      CheckPermission.requestSDCardPermission((AppActivity)localActivity, new tnl(this, paramJSONObject, paramString));
      return;
    }
    saveImagePermission(paramJSONObject, paramString);
  }
  
  public void saveImagePermission(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject = paramJSONObject.getString("content");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramJSONObject);
      ((StringBuilder)localObject).append("?client=androidQQ");
      ((StringBuilder)localObject).append("&version=8.4.1.4680");
      ((StringBuilder)localObject).append("&system=" + Build.VERSION.RELEASE);
      ((StringBuilder)localObject).append("&device=" + Build.DEVICE);
      ((StringBuilder)localObject).append("&uin=" + pha.a());
      paramJSONObject = arpm.a("VIP_xingying", ((StringBuilder)localObject).toString());
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "saveImage imageUrl=" + paramJSONObject);
      }
      localObject = System.currentTimeMillis() + ".jpg";
      ThreadManager.executeOnNetWorkThread(new BridgeModule.26(this, paramJSONObject, new File(anhk.bg, (String)localObject), paramString));
      return;
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "saveImage imageUrl error=" + paramJSONObject.getMessage());
      }
      invokeErrorCallJS(paramString, "saveImage error");
    }
  }
  
  public void selectAndInviteFriend(JSONObject paramJSONObject, String paramString)
  {
    if (BaseActivity.sTopActivity == null) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        String str = paramJSONObject.optString("rowkey", "");
        int j = paramJSONObject.optInt("maxSelect");
        int k = paramJSONObject.optInt("maxCount");
        Object localObject = paramJSONObject.optString("invitedUins", "[]");
        paramJSONObject = new StringBuilder();
        if ((localObject != null) && (((String)localObject).trim().length() > 0))
        {
          localObject = new JSONArray(((String)localObject).trim());
          i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            paramJSONObject.append(((JSONArray)localObject).get(i));
            if (i >= ((JSONArray)localObject).length() - 1) {
              break label262;
            }
            paramJSONObject.append(",");
            break label262;
          }
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("opentype", 1);
        ((Intent)localObject).putExtra("filterUins", paramJSONObject.toString());
        ((Intent)localObject).putExtra("maxSelect", j);
        if (k > 0) {
          ((Intent)localObject).putExtra("maxCount", k);
        }
        ((Intent)localObject).putExtra("rowkey", str);
        ((Intent)localObject).putExtra("callback", paramString);
        PublicFragmentActivity.a(BaseActivity.sTopActivity, (Intent)localObject, ReadInJoySelectMemberAQFragment.class, 119);
        return;
      }
      catch (Exception paramJSONObject)
      {
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, "selectAndInviteFriend e = " + paramJSONObject);
        }
        paramJSONObject.printStackTrace();
        return;
      }
      label262:
      i += 1;
    }
  }
  
  public void sendRequest(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null) {}
    Object localObject1;
    Object localObject2;
    String str;
    QQAppInterface localQQAppInterface;
    do
    {
      for (;;)
      {
        return;
        try
        {
          localObject1 = paramJSONObject.getString("host");
          localObject2 = paramJSONObject.getJSONObject("data");
          str = paramJSONObject.getString("cmd");
          localQQAppInterface = (QQAppInterface)pha.a();
          if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (localQQAppInterface != null) && (!TextUtils.isEmpty(str)))
          {
            localObject2 = ((JSONObject)localObject2).toString();
            if (ViolaUtils.getBoolean(paramJSONObject.optString("disableFrequency"))) {
              break label202;
            }
            if (this.preTime == 0L) {
              break label195;
            }
            if (System.currentTimeMillis() - this.preTime >= this.minDuration * 1000) {
              break label158;
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
    QLog.d(TAG, 2, "send request error!");
    return;
    label158:
    if (((String)localObject2).getBytes().length > this.maxSize)
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("cret", 2);
      invokeCallJS(paramString, paramJSONObject);
      return;
      label195:
      this.preTime = System.currentTimeMillis();
    }
    label202:
    String[] arrayOfString = ((String)localObject1).split("\\.");
    int i = arrayOfString.length;
    paramJSONObject = "";
    i -= 1;
    for (;;)
    {
      if (i >= 0)
      {
        localObject1 = paramJSONObject + arrayOfString[i];
        paramJSONObject = (JSONObject)localObject1;
        if (i != 0) {
          paramJSONObject = (String)localObject1 + "_";
        }
      }
      else
      {
        localObject1 = new NewIntent(localQQAppInterface.getApplication(), niq.class);
        ((NewIntent)localObject1).putExtra("cmd", "MQUpdateSvc_" + paramJSONObject + ".web." + str);
        paramJSONObject = new WebSsoBody.WebSsoRequestBody();
        paramJSONObject.type.set(0);
        paramJSONObject.data.set((String)localObject2);
        ((NewIntent)localObject1).putExtra("data", paramJSONObject.toByteArray());
        ((NewIntent)localObject1).setObserver(new tmz(this, paramString));
        if (localQQAppInterface == null) {
          break;
        }
        localQQAppInterface.startServlet((NewIntent)localObject1);
        return;
      }
      i -= 1;
    }
  }
  
  public void setClipboard(String paramString1, String paramString2)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity == null) {}
    do
    {
      return;
      ((ClipboardManager)localBaseActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("article", paramString1));
      try
      {
        paramString1 = new JSONObject();
        paramString1.put("result", true);
        invokeCallJS(paramString2, paramString1);
        return;
      }
      catch (Exception paramString1) {}
    } while (!QLog.isColorLevel());
    QLog.e(TAG, 2, "setClipboard error" + paramString1.getMessage());
  }
  
  public void setNavBar(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = generateMapFromInvokeJsUrl(paramJSONObject);
    if (paramJSONObject != null)
    {
      Fragment localFragment = getViolaInstance().getFragment();
      if ((localFragment != null) && ((localFragment instanceof ViolaFragment)))
      {
        ((ViolaFragment)localFragment).a(paramJSONObject, null);
        invokeCallJS(paramString, null);
      }
    }
  }
  
  @JSMethod
  public void setNavBtn(JSONObject paramJSONObject, String paramString)
  {
    setNavBtnWithFragment(paramJSONObject, paramString, null);
  }
  
  public void setNavBtnWithFragment(JSONObject paramJSONObject, String paramString, Fragment paramFragment)
  {
    if (paramFragment == null) {
      paramFragment = getViolaInstance().getFragment();
    }
    for (;;)
    {
      if (paramFragment == null) {}
      label120:
      for (;;)
      {
        return;
        if ((paramFragment instanceof ViolaFragment)) {}
        for (paramFragment = ((ViolaFragment)paramFragment).a();; paramFragment = null)
        {
          if (paramFragment == null) {
            break label120;
          }
          String str = paramJSONObject.optString("position");
          paramJSONObject = paramJSONObject.optString("text");
          if (TextUtils.isEmpty(str)) {
            break;
          }
          if (str.equals("right"))
          {
            paramFragment.a(paramJSONObject, new tnp(this, paramString));
            return;
          }
          if (!str.equals("left")) {
            break;
          }
          paramFragment.b(paramJSONObject, new tob(this, paramString));
          return;
        }
      }
    }
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
      localViolaFragment.b(bool);
      return;
      label44:
      bool = false;
    }
  }
  
  public void setRightDragToGoBackParams(JSONObject paramJSONObject, String paramString)
  {
    boolean bool = paramJSONObject.optBoolean("enable", true);
    if ((getViolaInstance() != null) && ((getViolaInstance().getFragment() instanceof ViolaFragment)))
    {
      ((ViolaFragment)getViolaInstance().getFragment()).a(bool);
      invokeCallJS(paramString, new JSONObject());
      return;
    }
    invokeErrorCallJS(paramString, anni.a(2131700007));
  }
  
  public void setTitle(JSONObject paramJSONObject, String paramString)
  {
    if (getViolaInstance() == null) {}
    Fragment localFragment;
    String str1;
    do
    {
      do
      {
        return;
        localFragment = getViolaInstance().getFragment();
      } while ((localFragment == null) || (!(localFragment instanceof ViolaFragment)));
      String str2 = paramJSONObject.optString("title");
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = paramJSONObject.optString("text");
      }
    } while (TextUtils.isEmpty(str1));
    ((ViolaFragment)localFragment).a(str1);
    invokeCallJS(paramString, new JSONObject());
  }
  
  public void setTitleClickListener(String paramString)
  {
    Object localObject = getViolaInstance();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((ViolaInstance)localObject).getFragment();
    } while (!(localObject instanceof ViolaFragment));
    ((ViolaFragment)localObject).a(new tnh(this, paramString));
  }
  
  protected void shareImageToAIO(String paramString)
  {
    Object localObject1 = getViolaInstance().getActivity();
    if ((localObject1 == null) || (((Activity)localObject1).isFinishing())) {
      return;
    }
    if (!AppNetConnInfo.isNetSupport())
    {
      QQToast.a(pha.a().getApplication(), 1, anni.a(2131700004), 0).a();
      return;
    }
    Object localObject2 = new File(bdsh.d(paramString));
    if (((File)localObject2).exists())
    {
      shareImageToAIOInner((File)localObject2);
      return;
    }
    localObject1 = new Bundle();
    localObject2 = new bhhf(paramString, (File)localObject2);
    ((bhhf)localObject2).d = 60L;
    ((bhhh)pha.a().getManager(47)).a(1).a((bhhf)localObject2, new tnm(this, paramString), (Bundle)localObject1);
  }
  
  protected void shareImageToAIOInner(File paramFile)
  {
    Activity localActivity = getViolaInstance().getActivity();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    Object localObject = paramFile.getAbsolutePath();
    paramFile = new Bundle();
    paramFile.putInt("forward_type", 1);
    paramFile.putString("forward_urldrawable_thumb_url", (String)localObject);
    paramFile.putString("forward_filepath", (String)localObject);
    paramFile.putString("forward_extra", (String)localObject);
    localObject = new Intent();
    ((Intent)localObject).putExtras(paramFile);
    aufz.a(localActivity, (Intent)localObject, 18);
  }
  
  public void sharePicMessage(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject = paramJSONObject.optString("imageUrl");
      JSONObject localJSONObject = new JSONObject();
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        shareImageToAIO(paramJSONObject);
        localJSONObject.put("retCode", 0);
        invokeCallJS(paramString, localJSONObject);
        return;
      }
      localJSONObject.put("retCode", 1);
      invokeCallJS(paramString, localJSONObject);
      QQToast.a(pha.a().getApplication(), 1, anni.a(2131700008), 0).a();
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e(TAG, 1, "sharePicMessage exception e = ", paramJSONObject);
    }
  }
  
  @JSMethod
  public void shareVideoWithFriend(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "do shareVideoWithFriend start data: " + paramJSONObject.toString());
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
    sce.a(paramString, getViolaInstance().getActivity(), 1, this.shareToFriendUin, this.shareToFriendUinType, this.shareToFriendUinName);
  }
  
  public void showActionSheet(JSONObject paramJSONObject, String paramString)
  {
    if (this.mActionSheetHelper == null) {
      this.mActionSheetHelper = new tmt(this);
    }
    this.mActionSheetHelper.a(paramJSONObject, paramString);
  }
  
  public void showCommentEditor(JSONObject paramJSONObject, String paramString)
  {
    if (getViolaInstance().getFragment() != null) {}
    for (Object localObject1 = getViolaInstance().getFragment().getActivity(); localObject1 == null; localObject1 = getViolaInstance().getActivity()) {
      return;
    }
    boolean bool1 = paramJSONObject.optBoolean("enableAnonymous", false);
    boolean bool2 = paramJSONObject.optBoolean("canBiu", true);
    int i = paramJSONObject.optInt("maxLength", -1);
    int j = paramJSONObject.optInt("commentType", 0);
    int k = paramJSONObject.optInt("sourceType", 0);
    int m = paramJSONObject.optInt("openAt", 0);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("defaultCommentAtLevel");
    localObject2 = paramJSONObject.optString("placeholder");
    try
    {
      localObject3 = new String(bgku.decode((String)localObject2, 0));
      localObject2 = localObject3;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject3;
        QLog.e(TAG, 1, "showCommentEditor | comment_placeholder decode error! | comment_placeholder: " + (String)localObject2);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "showCommentEditor | comment_placeholder after decode: " + (String)localObject2);
    }
    paramJSONObject = paramJSONObject.optString("defaultTxt");
    try
    {
      localObject3 = new String(bgku.decode(paramJSONObject, 0));
      paramJSONObject = (JSONObject)localObject3;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        QLog.e(TAG, 1, "showCommentEditor | defaultTxt decode error! | defaultTxt: " + paramJSONObject);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "showCommentEditor | defaultTxt after decode: " + paramJSONObject);
    }
    localObject3 = new Intent();
    ((Intent)localObject3).putExtra("comment_type", false);
    ((Intent)localObject3).putExtra("arg_comment_enable_anonymous", bool1);
    ((Intent)localObject3).putExtra("arg_comment_placeholder", (String)localObject2);
    ((Intent)localObject3).putExtra("arg_comment_default_txt", paramJSONObject);
    ((Intent)localObject3).putExtra("arg_comment_max_length", i);
    ((Intent)localObject3).putExtra("arg_comment_comment_type", j);
    ((Intent)localObject3).putExtra("arg_comment_source_type", k);
    ((Intent)localObject3).putExtra("arg_callback", paramString);
    ((Intent)localObject3).putExtra("arg_comment_open_at", m);
    ((Intent)localObject3).putExtra("comment_can_biu", bool2);
    ((Intent)localObject3).putExtra("public_fragment_window_feature", 1);
    if (localJSONArray != null) {
      ((Intent)localObject3).putExtra("arg_comment_default_comment_at", localJSONArray.toString());
    }
    PublicTransFragmentActivity.b((Activity)localObject1, (Intent)localObject3, ReadInJoyCommentComponentFragment.class, 117);
  }
  
  public void showCommentEditorNative(JSONObject paramJSONObject, String paramString)
  {
    if (getViolaInstance().getFragment() != null) {}
    for (Object localObject1 = getViolaInstance().getFragment().getActivity(); (localObject1 == null) || (paramJSONObject == null); localObject1 = getViolaInstance().getActivity()) {
      return;
    }
    boolean bool1 = paramJSONObject.optBoolean("enableAnonymous", false);
    boolean bool2 = paramJSONObject.optBoolean("canBiu", true);
    int i = paramJSONObject.optInt("maxLength", -1);
    int j = paramJSONObject.optInt("commentType", 0);
    int k = paramJSONObject.optInt("sourceType", 0);
    int m = paramJSONObject.optInt("openAt", 0);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("defaultCommentAtLevel");
    localObject2 = paramJSONObject.optString("placeholder");
    try
    {
      localObject3 = new String(bgku.decode((String)localObject2, 0));
      localObject2 = localObject3;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject3;
        QLog.e(TAG, 1, "showCommentEditorNative | comment_placeholder decode error! | comment_placeholder: " + (String)localObject2);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "showCommentEditorNative | comment_placeholder after decode: " + (String)localObject2);
    }
    localObject3 = paramJSONObject.optString("defaultTxt");
    try
    {
      str1 = new String(bgku.decode((String)localObject3, 0));
      localObject3 = str1;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        String str1;
        String str2;
        int n;
        int i1;
        String str4;
        String str3;
        long l;
        String str5;
        QLog.e(TAG, 1, "showCommentEditorNative | defaultTxt decode error! | defaultTxt: " + localException1);
        continue;
        paramString = new SubCommentCreateData(i1, str4);
        paramString.a(str3);
        paramString.b(localException2);
        paramString.c(str2);
        paramString.a(l);
        paramString.e(str5);
        paramString.b(n);
        paramJSONObject.putExtra("comment_create_data", paramString);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "showCommentEditorNative | defaultTxt after decode: " + (String)localObject3);
    }
    str1 = paramJSONObject.optString("rowkey");
    str2 = paramJSONObject.optString("articleId");
    n = paramJSONObject.optInt("scene");
    i1 = paramJSONObject.optInt("entry");
    str4 = paramJSONObject.optString("businessInfo");
    str3 = paramJSONObject.optString("firstCommentId");
    l = paramJSONObject.optLong("repliedSubAuthorId");
    str5 = paramJSONObject.optString("repliedSubCommentId");
    paramJSONObject = new Intent();
    paramJSONObject.putExtra("comment_type", false);
    paramJSONObject.putExtra("arg_comment_enable_anonymous", bool1);
    paramJSONObject.putExtra("arg_comment_placeholder", (String)localObject2);
    paramJSONObject.putExtra("arg_comment_default_txt", (String)localObject3);
    paramJSONObject.putExtra("arg_comment_max_length", i);
    paramJSONObject.putExtra("arg_comment_comment_type", j);
    paramJSONObject.putExtra("arg_comment_source_type", k);
    paramJSONObject.putExtra("arg_callback", paramString);
    paramJSONObject.putExtra("arg_comment_open_at", m);
    paramJSONObject.putExtra("comment_can_biu", bool2);
    paramJSONObject.putExtra("public_fragment_window_feature", 1);
    if (localJSONArray != null) {
      paramJSONObject.putExtra("arg_comment_default_comment_at", localJSONArray.toString());
    }
    if (str3.isEmpty())
    {
      paramString = new FirstCommentCreateData(i1, str4);
      paramString.b(str1);
      paramString.c(str2);
      paramString.b(n);
      paramJSONObject.putExtra("comment_create_data", paramString);
      aevv.a((Activity)localObject1, paramJSONObject, PublicTransFragmentActivity.class, ReadInJoyCommentComponentFragment.class, 126);
      return;
    }
  }
  
  public void showDialog(JSONObject paramJSONObject, String paramString)
  {
    BaseActivity localBaseActivity;
    if (paramJSONObject != null)
    {
      localBaseActivity = BaseActivity.sTopActivity;
      if (localBaseActivity != null) {}
    }
    else
    {
      return;
    }
    bgpa localbgpa = new bgpa(localBaseActivity, 2131755823);
    localbgpa.setContentView(2131558985);
    localbgpa.getMessageTextView().setMovementMethod(new ScrollingMovementMethod());
    localbgpa.getMessageTextView().setMaxHeight(bggq.a(localBaseActivity, 200.0F));
    localbgpa.setTitle(paramJSONObject.optString("title"));
    localbgpa.setMessage(paramJSONObject.optString("text"));
    localbgpa.setCanceledOnTouchOutside(false);
    if (paramJSONObject.optBoolean("needOkBtn", true)) {
      localbgpa.setPositiveButton(paramJSONObject.optString("okBtnText", anni.a(2131699998)), new tnb(this, paramJSONObject, paramString));
    }
    if (paramJSONObject.optBoolean("needCancelBtn", true)) {
      localbgpa.setNegativeButton(paramJSONObject.optString("cancelBtnText", anni.a(2131699994)), new tnc(this, paramJSONObject, paramString));
    }
    localbgpa.show();
  }
  
  public void showFailedToast(@NotNull String paramString)
  {
    QQToast.a(getViolaInstance().getActivity(), 1, paramString, 0).a();
  }
  
  @JSMethod
  public void showFollowAlertView(JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.optInt("type", 0);
    boolean bool1 = paramJSONObject.optBoolean("blackScene", false);
    boolean bool2 = paramJSONObject.optBoolean("isNightMode", false);
    String str = paramJSONObject.optString("avatarUrl", "");
    int j = paramJSONObject.optInt("bizType", 1);
    paramJSONObject = paramJSONObject.optString("uniqueID", "");
    qps.a.a().a(i, bool1, bool2, str, j, paramJSONObject, new tns(this, paramString));
  }
  
  @JSMethod
  public void showMotiveAd(String paramString, JSONObject paramJSONObject)
  {
    int k = 0;
    int j = 0;
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    Object localObject = "";
    String str2 = "";
    for (;;)
    {
      try
      {
        int i = paramJSONObject.optInt("orientation");
        j = k;
        String str1;
        QLog.e(TAG, 1, "showMotiveAd e", paramJSONObject);
      }
      catch (Exception paramJSONObject)
      {
        try
        {
          str1 = paramJSONObject.optString("adInfo");
          localObject = str1;
          j = k;
          k = paramJSONObject.optInt("rewardTime", 0);
          localObject = str1;
          j = k;
          paramJSONObject = paramJSONObject.optString("rewardText");
          j = k;
          localObject = str1;
          oql.a().a(localBaseActivity, i, (String)localObject, j, paramString, paramJSONObject);
          return;
        }
        catch (Exception paramJSONObject)
        {
          break label103;
        }
        paramJSONObject = paramJSONObject;
        i = 0;
      }
      label103:
      paramJSONObject = str2;
    }
  }
  
  public void showMultiBiuEditPage(JSONObject paramJSONObject, String paramString)
  {
    if (BaseActivity.sTopActivity == null) {
      return;
    }
    try
    {
      localObject8 = paramJSONObject.optString("title");
      localObject3 = paramJSONObject.optString("sourceName");
      localObject1 = paramJSONObject.optString("sourceUrl");
      localObject7 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject7 = "";
      }
      l3 = 0L;
      l2 = 0L;
      l4 = 0L;
      l7 = 0L;
      l11 = 0L;
      localObject6 = "";
    }
    catch (JSONException paramJSONObject)
    {
      Object localObject4;
      label582:
      String str1;
      String str2;
      JSONObject localJSONObject;
      label829:
      ViolaLogUtils.e(TAG, paramJSONObject.getMessage());
      return;
    }
    try
    {
      localObject1 = new String(bgku.decode((String)localObject8, 0));
    }
    catch (Exception localException1)
    {
      localObject2 = localObject3;
      localObject1 = "";
      localObject3 = localObject8;
      l10 = l11;
      localException1.printStackTrace();
      localObject8 = localObject1;
      l1 = l4;
      i = 0;
      localObject1 = localObject6;
      Object localObject5 = localObject2;
      l4 = l10;
      localObject2 = localObject8;
      break label582;
      n = getBiuSrc(k);
      performBiu((ArticleInfo)localObject8, paramJSONObject, createIntent((ArticleInfo)localObject8, (String)localObject1, k, j, paramString, (String)localObject2, m, (String)localObject3, l4, i, (String)localObject7, n), l3, l2, n, (String)localObject1, m);
      return;
    }
    try
    {
      localObject2 = new String(bgku.decode((String)localObject3, 0));
    }
    catch (Exception localException2)
    {
      localObject8 = localObject1;
      localObject1 = "";
      localObject2 = localObject3;
      l10 = l11;
      localObject3 = localObject8;
      break label917;
    }
    try
    {
      localObject3 = paramJSONObject.optString("feedsId");
      localObject4 = paramJSONObject.optString("rowkey");
      localObject6 = localObject4;
      l1 = l3;
      l10 = l11;
      l9 = l7;
      l8 = l4;
      l6 = l2;
      l5 = l3;
    }
    catch (Exception localException3)
    {
      localObject8 = "";
      localObject3 = localObject1;
      localObject1 = localObject8;
      l10 = l11;
      break label917;
    }
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        l10 = l11;
        l9 = l7;
        l8 = l4;
        l6 = l2;
        l5 = l3;
        l1 = new BigInteger((String)localObject3).longValue();
      }
      l10 = l11;
      l9 = l7;
      l8 = l4;
      l6 = l2;
      l5 = l1;
      localObject4 = paramJSONObject.optString("ariticleId");
      l3 = l2;
      l10 = l11;
      l9 = l7;
      l8 = l4;
      l6 = l2;
      l5 = l1;
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        l10 = l11;
        l9 = l7;
        l8 = l4;
        l6 = l2;
        l5 = l1;
        l3 = new BigInteger((String)localObject4).longValue();
      }
      l10 = l11;
      l9 = l7;
      l8 = l4;
      l6 = l3;
      l5 = l1;
      localObject4 = paramJSONObject.optString("originFeedsId");
      l2 = l4;
      l10 = l11;
      l9 = l7;
      l8 = l4;
      l6 = l3;
      l5 = l1;
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        l10 = l11;
        l9 = l7;
        l8 = l4;
        l6 = l3;
        l5 = l1;
        l2 = new BigInteger((String)localObject4).longValue();
      }
      l10 = l11;
      l9 = l7;
      l8 = l2;
      l6 = l3;
      l5 = l1;
      localObject4 = paramJSONObject.optString("businessId");
      l4 = l7;
      l10 = l11;
      l9 = l7;
      l8 = l2;
      l6 = l3;
      l5 = l1;
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        l10 = l11;
        l9 = l7;
        l8 = l2;
        l6 = l3;
        l5 = l1;
        l4 = new BigInteger((String)localObject4).longValue();
      }
      l10 = l11;
      l9 = l4;
      l8 = l2;
      l6 = l3;
      l5 = l1;
      l7 = paramJSONObject.optLong("accountID");
      l10 = l7;
      l9 = l4;
      l8 = l2;
      l6 = l3;
      l5 = l1;
      i = paramJSONObject.optInt("accountType");
      localObject8 = localObject3;
      l5 = l3;
      l3 = l1;
      l1 = l7;
      l6 = l2;
      localObject4 = localObject2;
      localObject3 = localObject1;
      l2 = l5;
      l7 = l4;
      localObject2 = localObject8;
      localObject1 = localObject6;
      l4 = l1;
      l1 = l6;
      l5 = paramJSONObject.optLong("originFeedsType", 1L);
      j = paramJSONObject.optInt("type");
      k = paramJSONObject.optInt("adtag");
      str1 = paramJSONObject.optString("picurl");
      n = paramJSONObject.optInt("duration");
      str2 = new String(bgku.decode(paramJSONObject.optString("accountDesc"), 0));
      m = paramJSONObject.optInt("feedsType", 1);
      localObject8 = new ArticleInfo();
      ((ArticleInfo)localObject8).mArticleID = l2;
      ((ArticleInfo)localObject8).mTitle = ((String)localObject3);
      ((ArticleInfo)localObject8).mSubscribeName = ((String)localObject4);
      ((ArticleInfo)localObject8).mFirstPagePicUrl = str1;
      ((ArticleInfo)localObject8).mVideoDuration = n;
      ((ArticleInfo)localObject8).mFeedId = l3;
      ((ArticleInfo)localObject8).mSummary = str2;
      ((ArticleInfo)localObject8).businessId = l7;
      ((ArticleInfo)localObject8).mFeedType = m;
      ((ArticleInfo)localObject8).innerUniqueID = ((String)localObject1);
      initPgcBiuInfo(paramJSONObject, (ArticleInfo)localObject8, l1, l5);
      localJSONObject = paramJSONObject.optJSONObject("ugcInfo");
      if ((localJSONObject == null) || (!snh.c(m, l5))) {
        break label1085;
      }
      localObject6 = localJSONObject.optString("ugcComment");
      j = localJSONObject.optInt("ugcType", 0);
      initUgcFeedsInfo((ArticleInfo)localObject8, localJSONObject, (String)localObject6, j, k, (String)localObject3, (String)localObject4, str1, str2, l4);
      j = initTypeWhenUgc(j, paramJSONObject);
      localObject3 = localObject6;
    }
    catch (Exception localException4)
    {
      localObject8 = localObject1;
      localObject1 = localObject3;
      l7 = l9;
      l4 = l8;
      l2 = l6;
      l3 = l5;
      localObject3 = localObject8;
      break label917;
      localObject3 = "";
      break label829;
    }
    ((ArticleInfo)localObject8).mSocialFeedInfo.jdField_a_of_type_JavaLangString = "";
    ((ArticleInfo)localObject8).mSocialFeedInfo.jdField_c_of_type_JavaLangString = "";
    ((ArticleInfo)localObject8).mSocialFeedInfo.jdField_b_of_type_JavaLangString = "";
    if (isPageShareInfoEmpty(k, (String)localObject7, (ArticleInfo)localObject8))
    {
      QLog.d(TAG, 1, "web page share but core info empty !");
      return;
    }
  }
  
  public void showPicture(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      JSONArray localJSONArray = paramJSONObject.optJSONArray("imageIDs");
      int j = paramJSONObject.optInt("index");
      Object localObject2 = paramJSONObject.optString("srcID", "1");
      Object localObject1 = localObject2;
      if ("1".equals(localObject2)) {
        localObject1 = "4";
      }
      boolean bool = paramJSONObject.optBoolean("isNotShowIndex", true);
      if ((localJSONArray == null) || (localJSONArray.length() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "imageList is null or length is 0");
        }
      }
      else
      {
        paramJSONObject = new ArrayList();
        int i = 0;
        while (i < localJSONArray.length())
        {
          paramJSONObject.add(localJSONArray.get(i).toString());
          i += 1;
        }
        localObject2 = getViolaInstance().getActivity();
        if (localObject2 != null)
        {
          bfhe.a((Activity)localObject2, j, paramJSONObject, null, null, false, bool, (String)localObject1, 100, null, null, null, null, "", true);
          invokeCallJS(paramString, null);
          return;
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel())
      {
        QLog.e(TAG, 2, "showPicture error" + paramJSONObject.getMessage());
        invokeErrorCallJS(paramString, null);
      }
    }
  }
  
  public void showReadinjoyPicture(JSONObject paramJSONObject, String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject2 = paramJSONObject.optJSONArray("imageIDs");
        int k = paramJSONObject.optInt("index");
        String str1 = paramJSONObject.optString("srcID");
        boolean bool1 = paramJSONObject.optBoolean("isNotShowIndex", true);
        boolean bool2 = paramJSONObject.optBoolean("showTitle", false);
        String str2 = new String(bgku.decode(paramJSONObject.optString("title", ""), 0));
        String str3 = paramJSONObject.optString("articleUrl", "");
        boolean bool3 = paramJSONObject.optBoolean("isReport", false);
        long l1 = paramJSONObject.optLong("touin");
        long l2 = paramJSONObject.optLong("feeds_id");
        int m = paramJSONObject.optInt("feeds_type");
        long l3 = paramJSONObject.optLong("articleId");
        int n = paramJSONObject.optInt("source");
        int i = 0;
        if (localObject2 != null) {
          i = ((JSONArray)localObject2).length();
        }
        if (Boolean.valueOf(bool3).booleanValue())
        {
          Object localObject1 = new PublicAccountShowPictureReport();
          ((PublicAccountShowPictureReport)localObject1).parse(paramJSONObject);
          paramJSONObject = (JSONObject)localObject1;
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, new Object[] { "KANDIAN Grid Image title: ", str2, ", articleUrl: ", str3, ", showTitle: ", Boolean.valueOf(bool2) });
          }
          if ((localObject2 == null) || (((JSONArray)localObject2).length() == 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "imageList is null or length is 0");
            }
            invokeErrorCallJS(paramString, "imageList is null or length is 0");
            return;
          }
          localObject1 = new ArrayList();
          int j = 0;
          if (j < ((JSONArray)localObject2).length())
          {
            ((ArrayList)localObject1).add(((JSONArray)localObject2).get(j).toString());
            j += 1;
            continue;
          }
          localObject2 = getViolaInstance().getActivity();
          if (localObject2 == null) {
            break;
          }
          Intent localIntent = new Intent((Context)localObject2, TroopAvatarWallPreviewActivity.class);
          Bundle localBundle = new Bundle();
          localBundle.putInt("index", k);
          localBundle.putStringArrayList("seqNum", (ArrayList)localObject1);
          localBundle.putBoolean("needBottomBar", false);
          localBundle.putBoolean("IS_EDIT", false);
          localBundle.putBoolean("is_use_path", true);
          localBundle.putBoolean("is_show_action", true);
          localBundle.putBoolean("is_not_show_index", bool1);
          localBundle.putBoolean("is_grid_image_report", true);
          localBundle.putString("to_uin", Long.toString(l1));
          localBundle.putString("feeds_id", Long.toString(l2));
          localBundle.putString("article_id", Long.toString(l3));
          localBundle.putString("scroll_image_r5", pha.a(i, -1, Integer.toString(n), m, "", "", null));
          localBundle.putString("read_article_r5", pha.a(i, -1, Integer.toString(n), m, "", null));
          if (!TextUtils.isEmpty(str1)) {
            localBundle.putString("src_id", str1);
          }
          if ((bool2) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)))
          {
            localBundle.putBoolean("is_show_content_url", true);
            localBundle.putString("article_url", str3);
            localBundle.putString("article_title", str2);
          }
          if ((paramJSONObject != null) && (paramJSONObject.isReport)) {
            localBundle.putString("PublicAccountShowPictureReport", paramJSONObject.toString());
          }
          localIntent.putExtras(localBundle);
          ((Activity)localObject2).startActivityForResult(localIntent, 100);
          invokeCallJS(paramString, null);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
      paramJSONObject = null;
    }
  }
  
  public void showShareMenu(JSONObject paramJSONObject, @NonNull String paramString)
  {
    Object localObject = getViolaInstance().getFragment();
    if (localObject != null) {}
    for (localObject = ((Fragment)localObject).getActivity(); localObject == null; localObject = getViolaInstance().getActivity()) {
      return;
    }
    AppInterface localAppInterface = (AppInterface)pha.a();
    JSONObject localJSONObject = paramJSONObject.optJSONObject("shareInfo");
    String str = paramJSONObject.optString("menu_title", anni.a(2131699996));
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
    this.mShareHelper = new uai((Activity)localObject, localAppInterface, new tpd(false, null, null, localJSONObject, new WeakReference(localObject), paramString, this));
    this.mShareHelper.a().setActionSheetTitle(str);
    int i = paramJSONObject.optInt("report_from");
    this.mShareHelper.a(tpa.a(bool, localHashSet), i);
  }
  
  public void showShareReadInJoyMenu(JSONObject paramJSONObject, String paramString, Fragment paramFragment)
  {
    AppInterface localAppInterface = (AppInterface)pha.a();
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
      localObject1 = uai.b();
      if (localObject2 != null) {
        break label167;
      }
    }
    ArrayList localArrayList1;
    label167:
    for (localObject2 = uai.c();; localObject2 = uai.a((JSONArray)localObject2, paramJSONObject))
    {
      localArrayList1 = new ArrayList();
      localObject3 = ((List)localObject1).iterator();
      while (((Iterator)localObject3).hasNext()) {
        localArrayList1.add(Integer.valueOf(((twm)((Iterator)localObject3).next()).jdField_a_of_type_Int));
      }
      localObject1 = uai.a((JSONArray)localObject1, paramJSONObject);
      break;
    }
    ArrayList localArrayList2 = new ArrayList();
    Object localObject3 = ((List)localObject2).iterator();
    while (((Iterator)localObject3).hasNext()) {
      localArrayList2.add(Integer.valueOf(((twm)((Iterator)localObject3).next()).jdField_a_of_type_Int));
    }
    String str3;
    String str1;
    if (paramJSONObject.optInt("from") == 1)
    {
      str3 = Aladdin.getConfig(273).getString("share_text_channel_list", "");
      str1 = Aladdin.getConfig(273).getString("share_text", "");
      localObject3 = str1;
    }
    try
    {
      if (!TextUtils.isEmpty(str1)) {
        localObject3 = pgy.a(String.format(str1, new Object[] { paramJSONObject.optString("share_url") }), "\\n", '\n');
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
        QLog.e(TAG, 2, QLog.getStackTraceString(localException));
      }
    }
    sShareEntryActivity = new WeakReference(getViolaInstance().getActivity());
    i = paramJSONObject.optInt("report_from");
    this.mShareHelper = new uai(paramFragment, localAppInterface, new tpd(true, (List)localObject1, (List)localObject2, paramJSONObject, new WeakReference(paramFragment), paramString, this));
    this.mShareHelper.a(new List[] { localArrayList1, localArrayList2 }, i);
    this.mShareHelper.a().setActionSheetTitle(str2);
    paramFragment = paramJSONObject.optString("rowkey", "");
    i = paramJSONObject.optInt("source", -1);
    j = paramJSONObject.optInt("report_from", -1);
    localObject1 = paramJSONObject.optString("vid", "");
    localObject2 = paramJSONObject.optString("algorithmId", "");
    localObject3 = paramJSONObject.optString("articleId", "");
    paramJSONObject = paramJSONObject.optString("topicId", "");
    this.mShareHelper.a().setCancelListener(new toi(this, j, paramFragment, (String)localObject1, i, (String)localObject2, (String)localObject3, paramJSONObject));
    this.mShareHelper.a().setOnDismissListener(new tmy(this, paramString));
  }
  
  public void showSuccessToast(@NotNull String paramString)
  {
    QQToast.a(getViolaInstance().getActivity(), 2, paramString, 0).a();
  }
  
  public void showTips(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = (QQAppInterface)pha.a();
    if (localObject == null) {
      return;
    }
    localObject = ((QQAppInterface)localObject).getApplication();
    String str = paramJSONObject.optString("text");
    int i = paramJSONObject.optInt("iconMode", 2);
    if (!TextUtils.isEmpty(str))
    {
      switch (i)
      {
      case 4: 
      case 5: 
      default: 
        i = 2;
      }
      for (;;)
      {
        QQToast.a((Context)localObject, i, str, 0).b(((Context)localObject).getResources().getDimensionPixelSize(2131298998));
        invokeCallJS(paramString, new JSONObject());
        return;
        i = 0;
        continue;
        i = 2;
        continue;
        i = 1;
        continue;
        i = 6;
      }
    }
    invokeErrorCallJS(paramString, "text为null!!");
  }
  
  public void showUGCEditPage(JSONObject paramJSONObject, String paramString)
  {
    boolean bool2 = true;
    if (BaseActivity.sTopActivity == null) {
      return;
    }
    String str1 = paramJSONObject.optString("topicId");
    Object localObject = paramJSONObject.optString("topicName");
    String str2 = paramJSONObject.optString("cookie");
    int i;
    if (paramJSONObject.optInt("isQuestion", 0) == 1) {
      i = 1;
    }
    for (;;)
    {
      int j;
      int k;
      if (paramJSONObject.optInt("isAnswer", 0) == 1)
      {
        j = 1;
        k = paramJSONObject.optInt("adtag");
      }
      try
      {
        paramJSONObject = new String(bgku.decode((String)localObject, 0));
        localObject = new Intent(BaseActivity.sTopActivity, ReadInJoyDeliverUGCActivity.class);
        ((Intent)localObject).putExtra("arg_topic_id", str1);
        if ((i != 0) || (j != 0))
        {
          i = 1;
          if (i != 0) {
            break label243;
          }
          bool1 = true;
          ((Intent)localObject).putExtra("support_topic", bool1);
          if (i != 0) {
            break label249;
          }
          bool1 = bool2;
          ((Intent)localObject).putExtra("support_linkify", bool1);
          ((Intent)localObject).putExtra("arg_topic_name", paramJSONObject);
          ((Intent)localObject).putExtra("arg_ad_tag", k);
          ((Intent)localObject).putExtra("arg_callback", paramString);
          ((Intent)localObject).putExtra("arg_ugc_edit_cookie", str2);
          BaseActivity.sTopActivity.startActivityForResult((Intent)localObject, 114);
          return;
          i = 0;
          continue;
          j = 0;
        }
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject.printStackTrace();
          paramJSONObject = (JSONObject)localObject;
          continue;
          i = 0;
          continue;
          label243:
          boolean bool1 = false;
          continue;
          label249:
          bool1 = false;
        }
      }
    }
  }
  
  public void showUGCVideoRecordPage(JSONObject paramJSONObject, String paramString)
  {
    Object localObject1 = (AppInterface)pha.a();
    localObject1 = getViolaInstance().getFragment();
    if (localObject1 != null) {}
    for (localObject1 = ((Fragment)localObject1).getActivity(); localObject1 == null; localObject1 = getViolaInstance().getActivity()) {
      return;
    }
    String str1 = paramJSONObject.optString("topicId");
    int i = paramJSONObject.optInt("adtag");
    paramJSONObject.optInt("mode");
    paramJSONObject.optString("vid");
    paramJSONObject.optString("videourl");
    paramJSONObject.optString("coverurl");
    paramJSONObject.optString("md5");
    Object localObject2 = paramJSONObject.optString("topicName");
    String str2 = paramJSONObject.optString("cookie");
    try
    {
      paramJSONObject = new String(bgku.decode((String)localObject2, 0));
      if (pha.g() >= 2)
      {
        QQToast.a((Context)localObject1, 0, ((Activity)localObject1).getString(2131716998), 0).b(((Activity)localObject1).getResources().getDimensionPixelSize(2131298998));
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject.printStackTrace();
        paramJSONObject = (JSONObject)localObject2;
      }
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("arg_topic_id", str1);
      ((Bundle)localObject2).putString("mTaskID", String.valueOf(System.currentTimeMillis() + (Math.random() * 10000.0D)));
      ((Bundle)localObject2).putString("arg_topic_id", str1);
      ((Bundle)localObject2).putString("arg_topic_name", paramJSONObject);
      ((Bundle)localObject2).putInt("arg_ad_tag", i);
      ((Bundle)localObject2).putString("arg_callback", paramString);
      ((Bundle)localObject2).putString("arg_ugc_edit_cookie", str2);
      ovj.a((Activity)localObject1, (Bundle)localObject2, (byte)116);
      pha.a("2", "2");
    }
  }
  
  public void showVisibleUserList(JSONObject paramJSONObject, String paramString)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity == null) {
      return;
    }
    paramJSONObject = paramJSONObject.optString("feedsId");
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      QLog.d(TAG, 2, "showVisibleUserList feedsId " + paramJSONObject);
      Intent localIntent = new Intent();
      localIntent.putExtra("feeds_id", new BigInteger(paramJSONObject).longValue());
      PublicFragmentActivity.a(localBaseActivity, localIntent, ReadInJoyPrivacyListFragment.class);
      invokeCallJS(paramString, null);
      return;
    }
    invokeErrorCallJS(paramString, "params error");
  }
  
  public void socailFeedsUpdate(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null) {}
    try
    {
      String str = paramJSONObject.getString("feeds_id");
      paramJSONObject = paramJSONObject.optString("feeds_type", "1");
      pmh.a().a(str, Integer.valueOf(paramJSONObject).intValue());
      invokeCallJS(paramString, null);
      return;
    }
    catch (Exception paramJSONObject)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.d(TAG, 2, "openAccountPageMore->error:" + paramJSONObject);
    }
    invokeErrorCallJS(paramString, "params error");
    return;
  }
  
  @JSMethod
  public void startImagePreDownload(JSONObject paramJSONObject)
  {
    float f2 = 100.0F;
    String str;
    boolean bool;
    if (!TextUtils.isEmpty(paramJSONObject.optString("url", "")))
    {
      str = paramJSONObject.optString("url", "");
      bool = paramJSONObject.optBoolean("isGif", false);
      if (!paramJSONObject.has("width")) {
        break label169;
      }
    }
    label169:
    for (float f1 = FlexConvertUtils.converPxByViewportToRealPx(paramJSONObject.opt("width"), 750);; f1 = 100.0F)
    {
      if (paramJSONObject.has("height")) {
        f2 = FlexConvertUtils.converPxByViewportToRealPx(paramJSONObject.opt("height"), 750);
      }
      paramJSONObject = URLDrawable.getDrawable(str, tmh.a(bool, (int)f1, (int)f2));
      QLog.d(TAG, 2, "preload image, ur: " + str + ".isGif:" + bool + ",reqWidth:" + f1 + ",reqHeight:" + f2);
      paramJSONObject.startDownload();
      return;
    }
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
        localArrayList.add(new sfk(localJSONObject.optString("videoVid"), localJSONObject.optString("articleID"), localJSONObject.optInt("busitype"), localJSONObject.optInt("duration")));
        i += 1;
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      ViolaLogUtils.e(TAG, "startVideoPreDownload error :" + paramJSONObject.getMessage());
      if ((this.mVideoPreDownloadMgr != null) && (getViolaInstance() != null) && (getViolaInstance().getActivity() != null))
      {
        this.mVideoPreDownloadMgr.a(getViolaInstance().getActivity().getApplicationContext());
        this.mVideoPreDownloadMgr.a = new sfl(sfl.d, sfl.f);
        this.mVideoPreDownloadMgr.a(new tmx(this, localArrayList));
      }
      this.mVideoPreDownloadMgr.a(0, true);
    }
  }
  
  @JSMethod
  public void studyModeSelectGrade(JSONObject paramJSONObject, String paramString)
  {
    pha.c(paramJSONObject.optString("selectedGradeList", ""));
    invokeJS(paramString, new JSONObject());
  }
  
  @JSMethod
  public void susCommentViewHide()
  {
    if ((getViolaInstance() != null) && ((getViolaInstance().getFragment() instanceof ViolaFragment)))
    {
      ViolaFragment localViolaFragment = (ViolaFragment)getViolaInstance().getFragment();
      if ((localViolaFragment.a()) && (localViolaFragment.a() != null)) {
        localViolaFragment.a().g();
      }
    }
  }
  
  @JSMethod
  public void susCommentViewShow()
  {
    if ((getViolaInstance() != null) && ((getViolaInstance().getFragment() instanceof ViolaFragment)))
    {
      ViolaFragment localViolaFragment = (ViolaFragment)getViolaInstance().getFragment();
      if ((localViolaFragment.a()) && (localViolaFragment.a() != null)) {
        localViolaFragment.a().f();
      }
    }
  }
  
  public void suspensionPopBack(String paramString)
  {
    Fragment localFragment = getViolaInstance().getFragment();
    if (localFragment != null)
    {
      if (!(localFragment instanceof ViolaFragment)) {
        break label81;
      }
      if (((ViolaFragment)localFragment).a() == null) {
        break label71;
      }
      if (!((ViolaFragment)localFragment).a().a()) {
        break label56;
      }
      localFragment.getActivity().doOnBackPressed();
    }
    for (;;)
    {
      invokeCallJS(paramString, null);
      return;
      label56:
      ((ViolaFragment)localFragment).a().a(0, 3);
      continue;
      label71:
      localFragment.getActivity().doOnBackPressed();
      continue;
      label81:
      localFragment.getActivity().doOnBackPressed();
    }
  }
  
  public void updateAccountCardFollowInfo(JSONObject paramJSONObject, String paramString)
  {
    boolean bool = true;
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        long l = paramJSONObject.getLong("followUin");
        int i = paramJSONObject.getInt("followInfo");
        if ((i == 2) || (i == 1))
        {
          paramJSONObject = pmk.a();
          if (i != 2) {
            break label120;
          }
          paramJSONObject.b(l, bool);
          ThreadManager.post(new BridgeModule.8(this, l, i), 8, null, true);
        }
        invokeCallJS(paramString, null);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(TAG, 2, "openAccountPageMore -> error:" + paramJSONObject);
        return;
      }
      invokeErrorCallJS(paramString, "params error");
      return;
      label120:
      bool = false;
    }
  }
  
  public void updateIfNeed(JSONObject paramJSONObject, String paramString)
  {
    tlg.a(String.valueOf(paramJSONObject.optInt("bid", 3256)), new tne(this, paramString));
  }
  
  @JSMethod(uiThread=true)
  public void updateIndepentTabState(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("state")))
    {
      int i = paramJSONObject.optInt("state");
      pmk.a().a(i, null);
    }
  }
  
  public void updateRedPacketShareTime() {}
  
  public void updateTopicCardFollowInfo(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null) {}
    try
    {
      int i = paramJSONObject.getInt("topicId");
      int j = paramJSONObject.getInt("followInfo");
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "topic id = " + i + "\t follow info =" + j);
      }
      if (!pmh.a().a(i, j)) {
        pmh.a().d(i, j);
      }
      invokeCallJS(paramString, null);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.d(TAG, 2, "openAccountPageMore->error:" + paramJSONObject);
    }
    invokeErrorCallJS(paramString, "params error");
    return;
  }
  
  @JSMethod(uiThread=false)
  public void vaNetworkChange(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)pha.a();
    if (localQQAppInterface == null) {}
    while (this.netInfoHandler != null) {
      return;
    }
    this.netInfoHandler = new tng(this, paramString);
    AppNetConnInfo.registerConnectionChangeReceiver(localQQAppInterface.getApplication(), this.netInfoHandler);
  }
  
  @JSMethod
  public void videoPlayFeedback(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "do videoPlayFeedback start data: " + paramJSONObject.toString());
    }
    Object localObject;
    if (sShareEntryActivity == null) {
      localObject = null;
    }
    for (;;)
    {
      sjo.a((Activity)localObject, paramJSONObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule
 * JD-Core Version:    0.7.0.1
 */