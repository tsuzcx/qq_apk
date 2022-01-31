package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import aaio;
import aaip;
import aano;
import aanp;
import aant;
import aanu;
import aanv;
import aljq;
import alpo;
import aluw;
import amkv;
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
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import apih;
import arum;
import asyy;
import azwu;
import bame;
import bcch;
import bcwh;
import bdar;
import bdbi;
import bdcb;
import bdcc;
import bddb;
import bdds;
import bdem;
import bdfq;
import bduw;
import bdvr;
import bdvv;
import bdvx;
import bdwa;
import bfgi;
import bfhh;
import bfka;
import bhou;
import bizm;
import bjxj;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyMessagesActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarActivity;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasCommentFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyForCanvasFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoCeilingFragment;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.JumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
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
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.protofile.cmd0xe36.cmd0xe36.ReqBody;
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
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import cooperation.liveroom.LiveRoomProxyActivity;
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
import mzx;
import mzy;
import nbv;
import ndd;
import nrt;
import oee;
import oeg;
import ohq;
import oik;
import ois;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import orq;
import ors;
import owy;
import oxb;
import oxd;
import pej;
import pxe;
import qlz;
import qmc;
import qmw;
import qmx;
import qmy;
import qok;
import qte;
import qun;
import qux;
import qvc;
import rhf;
import rjx;
import rjz;
import roi;
import rqj;
import smk;
import sni;
import sno;
import snq;
import snu;
import sny;
import snz;
import soa;
import sob;
import soc;
import sod;
import soe;
import sof;
import sog;
import soh;
import soi;
import soj;
import sok;
import sol;
import som;
import son;
import soo;
import sop;
import soq;
import sor;
import sos;
import sot;
import sou;
import sov;
import sox;
import spa;
import spb;
import spc;
import spd;
import spe;
import spf;
import spg;
import sph;
import spi;
import spk;
import spl;
import spm;
import spp;
import sps;
import spu;
import sqo;
import sxe;
import syq;
import tam;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import xoo;
import ymk;
import ymm;

public class BridgeModule
  extends BaseModule
  implements Destroyable, IActivityState, ymm
{
  public static final String BRIDGE_METHOD_NAME_ONCLICKBUBBLETIPS = "onClickBubbleTips";
  public static final String BRIDGE_METHOD_NAME_REQUESTBUBBLETIPSWORDING = "requestBubbleTipsWording";
  public static final String BRIDGE_PARAMS = "params";
  public static final String BRIDGE_PARAMS_ACTION = "action";
  public static final String BRIDGE_PARAMS_ANDROIDID = "androidID";
  public static final String BRIDGE_PARAMS_CHANNELID = "channelId";
  public static final String BRIDGE_PARAMS_FROMCALLBACK = "fromCallback";
  public static final String BRIDGE_PARAMS_IDENTIFIER = "identifier";
  public static final String BRIDGE_PARAMS_IMSI = "imsi";
  public static final String BRIDGE_PARAMS_PICURL = "picUrl";
  public static final String BRIDGE_PARAMS_QIMEI = "qimei";
  public static final String BRIDGE_PARAMS_QUA = "qua";
  public static final String BRIDGE_PARAMS_RECOMMEND = "showRecommendReason";
  public static final String BRIDGE_PARAMS_REDPACKET_ID = "redPacketId";
  public static final String BRIDGE_PARAMS_REDPACKET_ID_SM = "redpackid";
  public static final String BRIDGE_PARAMS_ROWKEY = "rowkey";
  public static final String BRIDGE_PARAMS_SHOULD_SHOW = "shouldShow";
  public static final String BRIDGE_PARAMS_STATUS = "status";
  public static final String BRIDGE_PARAMS_TYPE = "type";
  public static final String BRIDGE_PARAMS_VID = "vid";
  public static final String BRIDGE_PARAMS_WORDING = "wording";
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
  public static final byte REQ_CODE_DELIVER = 113;
  public static final byte REQ_CODE_DELIVER_QUESTION = 122;
  public static final byte REQ_CODE_DELIVER_TopicPic = 121;
  public static final byte REQ_CODE_DELIVER_UGC = 114;
  public static final byte REQ_CODE_SELECT_AND_UPLOAD_AVATAR = 118;
  public static final byte REQ_CODE_SHARE_QZONE = 125;
  public static final byte REQ_CODE_UGC_ADD_VIDEO = 124;
  public static final byte REQ_CODE_UGC_CAMERA_CAPTURE = 116;
  public static final byte REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM = 115;
  public static final byte REQ_CODE_UGC_MANAGE_COLUMN = 123;
  public static String TAG = "BridgeModule";
  public static GdtAppReceiver mGdtAppReceiver;
  public static String shareCallBackId;
  public static String shareCallBackName;
  public static int shareCallBackType;
  private Map<Long, String> columnToUploadCallbackMap = new HashMap();
  private String commentCallbaclId;
  private oik dataManager;
  private boolean hasShareItemClick;
  private snu mActionSheetHelper;
  private spu mBridgeApiHelper;
  private String mCallBack;
  private ymk mClient;
  private sqo mCommentManager;
  private bfka mDownloadListener;
  private spm mEventHelper;
  private Map<String, Object> mObjectMap = new ArrayMap();
  protected ShareActionSheetBuilder mShareActionSheet;
  private syq mShareHelper;
  private spp mShareUtils = new spp();
  private int mState = -100;
  private String mUploadCallBack;
  private VideoPreDownloadMgr mVideoPreDownloadMgr = new VideoPreDownloadMgr();
  private int maxSize = 204800;
  private int minDuration = 5;
  private INetInfoHandler netInfoHandler;
  private long preTime;
  private String shareVideoCallBackId;
  private qux videoPublishCallback = new sox(this);
  private qvc violaVideoUpdateController;
  
  public BridgeModule()
  {
    this.mObjectMap.put("predownload", this.mVideoPreDownloadMgr);
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
  
  private void arouseReadInJoyNativeCommentView(JSONObject paramJSONObject, String paramString)
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
  
  private void batchCheckUpdate(JSONObject paramJSONObject, String paramString)
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
      nbv.a(localArrayList, ors.a(), new soj(this, paramString), true, false);
      return;
    }
    catch (Exception paramJSONObject)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(TAG, 2, "batchCheckUpdate error" + paramJSONObject.getMessage());
      invokeErrorCallJS(paramString, null);
    }
  }
  
  private int bindCommentCallback(String paramString)
  {
    if (this.mClient == null)
    {
      this.mClient = ymk.a();
      this.mClient.a();
    }
    this.commentCallbaclId = paramString;
    return this.mClient.a(this);
  }
  
  private void canOpenPage(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = paramJSONObject.optString("url");
    if (TextUtils.isEmpty(paramJSONObject)) {}
    BaseActivity localBaseActivity;
    do
    {
      return;
      localBaseActivity = BaseActivity.sTopActivity;
    } while (localBaseActivity == null);
    smk.a(localBaseActivity, paramJSONObject, new soh(this, paramString));
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
      localArticleInfo.mVideoCoverUrl = ors.a(paramJSONObject.optString("picUrl"));
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 1, "openTopicVideoComment  uniqueKey = " + str1 + "feedsId = " + l2 + " feedsType=" + i + "title = " + str2 + "picUrl =" + str3 + "articleId =" + l1);
    }
    return localArticleInfo;
  }
  
  private void detailLog(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = (QQAppInterface)ors.a();
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localObject == null) || (localBaseActivity == null)) {}
    StringBuilder localStringBuilder1;
    label243:
    label255:
    do
    {
      return;
      localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = localStringBuilder1.append(paramJSONObject.optString("id")).append("|").append(paramJSONObject.optString("subid")).append("|").append(paramJSONObject.optString("content")).append("|").append("ANDROID").append("|").append("8.3.3.4515").append("|").append(bdcb.e()).append("|").append(((QQAppInterface)localObject).getCurrentAccountUin()).append("|").append(Build.MODEL).append("|");
      if (TextUtils.isEmpty(bdcb.a(localBaseActivity).jdField_c_of_type_JavaLangString))
      {
        localObject = "未知";
        localStringBuilder2 = localStringBuilder2.append((String)localObject).append("|");
        if (!TextUtils.isEmpty(bdcb.a(localBaseActivity).jdField_a_of_type_JavaLangString)) {
          break label243;
        }
      }
      for (localObject = "未知";; localObject = bdcb.a(localBaseActivity).jdField_a_of_type_JavaLangString)
      {
        localStringBuilder2.append((String)localObject);
        if (!paramJSONObject.optBoolean("isall", false)) {
          break label255;
        }
        QLog.w("ViolaLog", 1, localStringBuilder1.toString());
        invokeCallJS(paramString, null);
        return;
        localObject = bdcb.a(localBaseActivity).jdField_c_of_type_JavaLangString;
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("ViolaLog", 2, localStringBuilder1.toString());
    invokeCallJS(paramString, null);
  }
  
  private void doPostShowComment(FragmentActivity paramFragmentActivity, VVideoView paramVVideoView, View paramView, JSONObject paramJSONObject)
  {
    Object localObject;
    if (this.mCommentManager == null)
    {
      localObject = paramFragmentActivity.getSupportFragmentManager();
      if ((getViolaInstance() == null) || (!((ViolaFragment)getViolaInstance().getFragment()).a()) || (!((ViolaFragment)getViolaInstance().getFragment()).a().d())) {
        break label214;
      }
    }
    label214:
    for (int i = ((ViolaFragment)getViolaInstance().getFragment()).a().a();; i = 0)
    {
      this.mCommentManager = new sqo(paramFragmentActivity, (FragmentManager)localObject, i);
      if ((getViolaInstance() != null) && ((getViolaInstance().getFragment() instanceof ViolaFragment)))
      {
        paramFragmentActivity = (ViolaFragment)getViolaInstance().getFragment();
        if ((paramFragmentActivity.a()) && (paramFragmentActivity.a() != null)) {
          paramFragmentActivity.a().f();
        }
      }
      this.mCommentManager.a(new som(this));
      paramFragmentActivity = createArticleInfo(paramJSONObject);
      localObject = createAnchorData(paramJSONObject);
      float f = ViolaUtils.getFloat(paramJSONObject.optString("offset"), Float.valueOf(0.0F));
      this.mCommentManager.a(paramView, f);
      this.mCommentManager.a(paramVVideoView, paramView, paramFragmentActivity, (AnchorData)localObject, -16777216);
      return;
    }
  }
  
  private void downloadApk(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("apkUrl"))))
    {
      DownloadInfo localDownloadInfo = new DownloadInfo();
      String str = paramJSONObject.optString("apkUrl");
      localDownloadInfo.d = str;
      localDownloadInfo.e = paramJSONObject.optString("packageName", null);
      localDownloadInfo.m = "biz_src_feeds_kandianads";
      if (this.mDownloadListener == null) {
        this.mDownloadListener = new soc(this, str, paramString);
      }
      bfgi.a().a(this.mDownloadListener);
      localDownloadInfo.a();
      bfgi.a().b(localDownloadInfo);
    }
  }
  
  private void downloadApkAction(JSONObject paramJSONObject)
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
  
  private void downloadApkCancel(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("apkUrl"))))
    {
      paramJSONObject = paramJSONObject.optString("apkUrl");
      bfgi.a().b(paramJSONObject, true);
    }
  }
  
  private void downloadApkPause(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("apkUrl"))))
    {
      paramJSONObject = paramJSONObject.optString("apkUrl");
      bfgi.a().a(paramJSONObject);
    }
  }
  
  private void downloadApkResume(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("apkUrl"))))
    {
      paramJSONObject = paramJSONObject.optString("apkUrl");
      DownloadInfo localDownloadInfo = new DownloadInfo();
      localDownloadInfo.d = paramJSONObject;
      localDownloadInfo.m = "biz_src_feeds_kandianads";
      localDownloadInfo.a();
      bfgi.a().b(localDownloadInfo);
    }
  }
  
  private void downloadApp(String paramString)
  {
    Context localContext = getViolaInstance().getContext();
    if ((localContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      Object localObject = tam.b(paramString);
      if (localObject != null)
      {
        ((DownloadInfo)localObject).a();
        bfgi.a().b((DownloadInfo)localObject);
        return;
      }
      try
      {
        paramString = new JSONObject(paramString);
        localObject = new Intent(localContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("big_brother_source_key", ors.f(0));
        ((Intent)localObject).putExtra("url", paramString.optString("url"));
        localContext.startActivity((Intent)localObject);
        return;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e(TAG, 2, "downloadApp error" + paramString.getMessage());
  }
  
  private void downloadForGooglePlay(String paramString)
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
  
  private void ensureEventHelper()
  {
    if (this.mEventHelper == null) {
      this.mEventHelper = new spm(this);
    }
  }
  
  private void feedsRefreshMessage(JSONObject paramJSONObject)
  {
    pxe.a().a(paramJSONObject);
  }
  
  private void fireGetLocation(JSONObject paramJSONObject, String paramString)
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
  
  private void fireGetLocationFromCache(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    paramString1 = amkv.a(paramString1);
    if ((paramString1 != null) && (paramString1.a != null))
    {
      fireLocationSuccessCallback(paramString1, paramString2);
      return;
    }
    fireLocationErrorCallback(paramString2, "fail to get locationInfo from cache");
  }
  
  private void fireGetLocationFromSso(String paramString1, String paramString2)
  {
    amkv.a(new spe(this, paramString1, paramString2));
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
        localHashMap.put(sno.d, paramJSONObject.optString("bgclr"));
      }
      if (TextUtils.isEmpty(paramJSONObject.optString("txtclr"))) {
        localHashMap.put(sno.jdField_c_of_type_JavaLangString, paramJSONObject.optString("txtclr"));
      }
      if (!TextUtils.isEmpty(paramJSONObject.optString("titleclr"))) {
        localHashMap.put(sno.e, paramJSONObject.optString("titleclr"));
      }
      if (!TextUtils.isEmpty(paramJSONObject.optString("alpha"))) {
        localHashMap.put(sno.f, paramJSONObject.optString("alpha"));
      }
      if (!TextUtils.isEmpty(paramJSONObject.optString("statusBarColor"))) {
        localHashMap.put(sno.g, paramJSONObject.optString("statusBarColor"));
      }
      return localHashMap;
    }
    return null;
  }
  
  private void getCUKingStatus(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", bdvr.a());
      invokeCallJS(paramString, localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e(TAG, 1, "getCUKingStatus error e = ", paramString);
    }
  }
  
  private void getClientInfo(String paramString)
  {
    Object localObject = BaseActivity.sTopActivity;
    if (localObject == null) {
      return;
    }
    localObject = bdcb.a((Context)localObject);
    String str = bdcb.c();
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
  
  private void getClipboard(String paramString)
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
  
  private JSONObject getDeviceInfo()
  {
    JSONObject localJSONObject = new JSONObject();
    String str1 = bdcb.f();
    String str2 = bdcb.a();
    try
    {
      localJSONObject.put("imsi", ors.g());
      localJSONObject.put("androidID", str1);
      localJSONObject.put("identifier", str2);
      localJSONObject.put("qimei", UserAction.getQIMEI());
      localJSONObject.put("qua", bizm.a());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  private void getDownloadApkState(JSONObject paramJSONObject, String paramString)
  {
    Object localObject;
    int j;
    int i;
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("apkUrl"))))
    {
      paramJSONObject = paramJSONObject.optString("apkUrl");
      localObject = bfgi.a().b(paramJSONObject);
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
  
  private void getGdtInfo(String paramString)
  {
    ThreadManager.post(new BridgeModule.14(this, paramString), 8, null, true);
  }
  
  private String getNickName(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = paramQQAppInterface.getCurrentNickname();
    if (!TextUtils.isEmpty(paramString))
    {
      paramQQAppInterface = (aluw)paramQQAppInterface.getManager(56);
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
  
  private void getPerformance(String paramString)
  {
    ViolaInstance localViolaInstance = getViolaInstance();
    if (localViolaInstance == null) {
      return;
    }
    invokeCallJS(paramString, localViolaInstance.getMainPerformance());
  }
  
  private void getReadInJoyUgcPermission(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    QQAppInterface localQQAppInterface = (QQAppInterface)ors.a();
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
        bool = qok.a();
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
        bool = qok.b();
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
  
  private int getRecommendFlag()
  {
    int i = 1;
    if (azwu.a()) {
      i = 8193;
    }
    return i;
  }
  
  private void getRecommendFlag(String paramString)
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
  
  private void getUploadingVideoList(@NotNull QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    qun.a(paramQQAppInterface).a(paramLong, new sos(this, paramLong, paramString));
  }
  
  private JSONObject getUserInfo()
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject3 = (QQAppInterface)ors.a();
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
  
  @SuppressLint({"NewApi"})
  private boolean hasAuthorizeLocation()
  {
    if (!bhou.k()) {}
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
  
  private boolean invokeBridgeApi(JSONObject paramJSONObject, String paramString)
  {
    return false;
  }
  
  private void isNightMode(String paramString)
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
  
  private void jumpUrl(Context paramContext, String paramString, Bundle paramBundle)
  {
    ors.a(paramContext, paramString, paramBundle);
  }
  
  private void openPage(JSONObject paramJSONObject, String paramString)
  {
    paramString = paramJSONObject.optString("url");
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Bundle localBundle = new Bundle();
    if (paramJSONObject.optJSONObject("param") != null) {
      localBundle.putString("param", paramJSONObject.optJSONObject("param").toString());
    }
    smk.a(BaseActivity.sTopActivity, "", paramString, localBundle);
  }
  
  private void openPrivateLetter()
  {
    Context localContext = getViolaInstance().getContext();
    if (localContext == null) {
      return;
    }
    Intent localIntent = new Intent(localContext, ReadInJoyMessagesActivity.class);
    localIntent.setFlags(67108864);
    localContext.startActivity(localIntent);
  }
  
  private void openUrl(JSONObject paramJSONObject, String paramString)
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
        paramJSONObject.putString("big_brother_ref_source_key", ors.f(0));
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
  
  private void pageVisibility(String paramString)
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
  
  private void popBack(String paramString)
  {
    Fragment localFragment = getViolaInstance().getFragment();
    if (localFragment != null)
    {
      if (!(localFragment instanceof ViolaFragment)) {
        break label33;
      }
      ((ViolaFragment)localFragment).c();
    }
    for (;;)
    {
      invokeCallJS(paramString, null);
      return;
      label33:
      localFragment.getActivity().doOnBackPressed();
    }
  }
  
  private void reportT(JSONObject paramJSONObject)
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
      nrt.a(null, null, str, str, 0, 0, paramJSONObject, (String)localObject1, (String)localObject2, (String)localObject3, false);
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
  
  private void responseUploadingVideoList(long paramLong, @NotNull List<UgcVideo> paramList, String paramString1, int paramInt, String paramString2)
  {
    responseUploadingVideoList(paramLong, paramList, paramString1, paramInt, paramString2, false);
  }
  
  private void responseUploadingVideoList(long paramLong, @NotNull List<UgcVideo> paramList, String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    ThreadManagerV2.excute(new BridgeModule.38(this, paramList, paramInt, paramString2, paramBoolean, paramString1), 16, null, false);
  }
  
  private void saveImageToLocal(String paramString)
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
        ((StringBuilder)localObject).append("&version=8.3.3.4515");
        ((StringBuilder)localObject).append("&system=" + Build.VERSION.RELEASE);
        ((StringBuilder)localObject).append("&device=" + Build.DEVICE);
        ((StringBuilder)localObject).append("&uin=" + ors.a());
        paramString = apih.a("VIP_xingying", ((StringBuilder)localObject).toString());
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "saveImageToLocal imageUrl=" + paramString);
        }
        localObject = System.currentTimeMillis() + ".jpg";
        ThreadManager.executeOnNetWorkThread(new BridgeModule.20(this, paramString, new File(bduw.a(aljq.bd), (String)localObject)));
        return;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e(TAG, 2, "saveImageToLocal imageUrl error=" + paramString.getMessage());
  }
  
  private void selectAndInviteFriend(JSONObject paramJSONObject, String paramString)
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
    for (int i = bcwh.a(localBaseActivity, j / 2);; i = 640)
    {
      int m;
      if (paramJSONObject.has("height")) {
        m = paramJSONObject.optInt("height");
      }
      for (int k = bcwh.a(localBaseActivity, m / 2);; k = 640)
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
    Object localObject = (QQAppInterface)ors.a();
    Activity localActivity = getViolaInstance().getActivity();
    if ((localObject != null) && (localActivity != null))
    {
      localObject = new Intent(localActivity, NewPhotoListActivity.class);
      ((Intent)localObject).putExtra("enter_from", 25);
      ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ReadInJoyUploadAvatarActivity.class.getName());
      ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      ((Intent)localObject).putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
      ((Intent)localObject).putExtra("PhotoConst.IS_SINGLE_MODE", true);
      ((Intent)localObject).putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
      ((Intent)localObject).putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
      ((Intent)localObject).putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      ((Intent)localObject).putExtra("key_from_kandian_uploadimg", true);
      String str = bduw.a(aljq.aX + "readinjoy_avatar_upload/");
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
      bdar.anim(localActivity, false, true);
    }
  }
  
  private void setClipboard(String paramString1, String paramString2)
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
  
  private void setNavBar(JSONObject paramJSONObject, String paramString)
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
  
  private void setRightDragToGoBackParams(JSONObject paramJSONObject, String paramString)
  {
    boolean bool = paramJSONObject.optBoolean("enable", true);
    if ((getViolaInstance() != null) && ((getViolaInstance().getFragment() instanceof ViolaFragment)))
    {
      ((ViolaFragment)getViolaInstance().getFragment()).a(bool);
      invokeCallJS(paramString, new JSONObject());
      return;
    }
    invokeErrorCallJS(paramString, alpo.a(2131701571));
  }
  
  private void setTitle(JSONObject paramJSONObject, String paramString)
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
  
  private void setTitleClickListener(String paramString)
  {
    Object localObject = getViolaInstance();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((ViolaInstance)localObject).getFragment();
    } while (!(localObject instanceof ViolaFragment));
    ((ViolaFragment)localObject).a(new sok(this, paramString));
  }
  
  private void sharePicMessage(JSONObject paramJSONObject, String paramString)
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
      QQToast.a(ors.a().getApplication(), 1, alpo.a(2131701572), 0).a();
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e(TAG, 1, "sharePicMessage exception e = ", paramJSONObject);
    }
  }
  
  private void showCommentEditor(JSONObject paramJSONObject, String paramString)
  {
    Object localObject1 = getViolaInstance().getFragment();
    if (localObject1 != null) {}
    for (Object localObject2 = ((Fragment)localObject1).getActivity(); localObject2 == null; localObject2 = getViolaInstance().getActivity()) {
      return;
    }
    boolean bool1 = false;
    if (paramJSONObject.has("enableAnonymous")) {
      bool1 = paramJSONObject.optBoolean("enableAnonymous");
    }
    boolean bool2 = true;
    if (paramJSONObject.has("canBiu")) {
      bool2 = paramJSONObject.optBoolean("canBiu");
    }
    Object localObject3 = "";
    if (paramJSONObject.has("placeholder"))
    {
      localObject1 = paramJSONObject.optString("placeholder");
      QLog.d(TAG, 2, "ph5 | comment_placeholder: " + (String)localObject1);
    }
    try
    {
      localObject3 = new String(bdbi.decode((String)localObject1, 0));
      localObject1 = localObject3;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localException1.printStackTrace();
      }
    }
    QLog.d(TAG, 2, "ph5 | comment_placeholder after decode: " + (String)localObject1);
    localObject3 = localObject1;
    localObject1 = "";
    if (paramJSONObject.has("defaultTxt")) {
      localObject1 = paramJSONObject.optString("defaultTxt");
    }
    try
    {
      localObject4 = new String(bdbi.decode((String)localObject1, 0));
      localObject1 = localObject4;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject4;
        int i;
        int j;
        int k;
        int m;
        localException2.printStackTrace();
      }
    }
    i = -1;
    if (paramJSONObject.has("maxLength")) {
      i = paramJSONObject.optInt("maxLength", -1);
    }
    j = 0;
    if (paramJSONObject.has("commentType")) {
      j = paramJSONObject.optInt("commentType", 0);
    }
    k = 0;
    if (paramJSONObject.has("sourceType")) {
      k = paramJSONObject.optInt("sourceType", 0);
    }
    localObject4 = paramJSONObject.optJSONArray("defaultCommentAtLevel");
    m = paramJSONObject.optInt("openAt", 0);
    paramJSONObject = new Intent();
    paramJSONObject.putExtra("comment_type", false);
    paramJSONObject.putExtra("arg_comment_enable_anonymous", bool1);
    paramJSONObject.putExtra("arg_comment_placeholder", (String)localObject3);
    paramJSONObject.putExtra("arg_comment_default_txt", (String)localObject1);
    paramJSONObject.putExtra("arg_comment_max_length", i);
    paramJSONObject.putExtra("arg_comment_comment_type", j);
    paramJSONObject.putExtra("arg_comment_source_type", k);
    paramJSONObject.putExtra("arg_callback", paramString);
    paramJSONObject.putExtra("arg_comment_open_at", m);
    paramJSONObject.putExtra("comment_can_biu", bool2);
    paramJSONObject.putExtra("public_fragment_window_feature", 1);
    if (localObject4 != null) {
      paramJSONObject.putExtra("arg_comment_default_comment_at", ((JSONArray)localObject4).toString());
    }
    PublicTransFragmentActivity.b((Activity)localObject2, paramJSONObject, ReadInJoyCommentComponentFragment.class, 117);
  }
  
  private void showDialog(JSONObject paramJSONObject, String paramString)
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
    bdfq localbdfq = new bdfq(localBaseActivity, 2131755801);
    localbdfq.setContentView(2131558920);
    localbdfq.getMessageTextView().setMovementMethod(new ScrollingMovementMethod());
    localbdfq.getMessageTextView().setMaxHeight(bcwh.a(localBaseActivity, 200.0F));
    localbdfq.setTitle(paramJSONObject.optString("title"));
    localbdfq.setMessage(paramJSONObject.optString("text"));
    localbdfq.setCanceledOnTouchOutside(false);
    if (paramJSONObject.optBoolean("needOkBtn", true)) {
      localbdfq.setPositiveButton(paramJSONObject.optString("okBtnText", alpo.a(2131701562)), new sod(this, paramJSONObject, paramString));
    }
    if (paramJSONObject.optBoolean("needCancelBtn", true)) {
      localbdfq.setNegativeButton(paramJSONObject.optString("cancelBtnText", alpo.a(2131701558)), new soe(this, paramJSONObject, paramString));
    }
    localbdfq.show();
  }
  
  private void showMultiBiuEditPage(JSONObject paramJSONObject, String paramString)
  {
    if (BaseActivity.sTopActivity == null) {
      return;
    }
    for (;;)
    {
      int i;
      int m;
      int i2;
      try
      {
        Object localObject6 = paramJSONObject.optString("title");
        Object localObject3 = paramJSONObject.optString("sourceName");
        String str3 = paramJSONObject.optString("sourceUrl");
        int n;
        String str1;
        long l1;
        long l3;
        long l4;
        long l10;
        long l11;
        Object localObject5;
        if (TextUtils.isEmpty(str3))
        {
          str3 = "";
          n = paramJSONObject.optInt("hiddenBiuComponent");
          str1 = "";
          if (n == 1) {
            str1 = new String(bdbi.decode(paramJSONObject.optString("newComment"), 2));
          }
          l1 = 0L;
          l3 = 0L;
          l4 = 0L;
          l10 = 0L;
          l11 = 0L;
          localObject5 = "";
        }
        try
        {
          localObject1 = new String(bdbi.decode((String)localObject6, 0));
        }
        catch (Exception localException4)
        {
          Object localObject4;
          long l2;
          long l7;
          long l6;
          long l5;
          int j;
          String str4;
          int k;
          String str5;
          int i1;
          Object localObject7;
          Object localObject8;
          Object localObject10;
          Object localObject11;
          String str2;
          Object localObject9;
          String str6;
          String str7;
          boolean bool;
          Object localObject2 = localObject3;
          Object localObject1 = "";
          long l9 = l11;
          long l8 = l10;
          localObject3 = localObject6;
          continue;
        }
        try
        {
          localObject2 = new String(bdbi.decode((String)localObject3, 0));
        }
        catch (Exception localException1)
        {
          localObject6 = localObject1;
          localObject1 = "";
          localObject2 = localObject3;
          l9 = l11;
          l8 = l10;
          localObject3 = localObject6;
          continue;
        }
        try
        {
          localObject3 = paramJSONObject.optString("feedsId");
          localObject4 = paramJSONObject.optString("rowkey");
          localObject5 = localObject4;
          l2 = l1;
          l9 = l11;
          l8 = l10;
          l7 = l4;
          l6 = l3;
          l5 = l1;
        }
        catch (Exception localException2)
        {
          localObject6 = "";
          localObject3 = localObject1;
          localObject1 = localObject6;
          l9 = l11;
          l8 = l10;
          continue;
        }
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            l9 = l11;
            l8 = l10;
            l7 = l4;
            l6 = l3;
            l5 = l1;
            l2 = new BigInteger((String)localObject3).longValue();
          }
          l9 = l11;
          l8 = l10;
          l7 = l4;
          l6 = l3;
          l5 = l2;
          localObject4 = paramJSONObject.optString("ariticleId");
          l1 = l3;
          l9 = l11;
          l8 = l10;
          l7 = l4;
          l6 = l3;
          l5 = l2;
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            l9 = l11;
            l8 = l10;
            l7 = l4;
            l6 = l3;
            l5 = l2;
            l1 = new BigInteger((String)localObject4).longValue();
          }
          l9 = l11;
          l8 = l10;
          l7 = l4;
          l6 = l1;
          l5 = l2;
          localObject4 = paramJSONObject.optString("originFeedsId");
          l3 = l4;
          l9 = l11;
          l8 = l10;
          l7 = l4;
          l6 = l1;
          l5 = l2;
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            l9 = l11;
            l8 = l10;
            l7 = l4;
            l6 = l1;
            l5 = l2;
            l3 = new BigInteger((String)localObject4).longValue();
          }
          l9 = l11;
          l8 = l10;
          l7 = l3;
          l6 = l1;
          l5 = l2;
          localObject4 = paramJSONObject.optString("businessId");
          l4 = l10;
          l9 = l11;
          l8 = l10;
          l7 = l3;
          l6 = l1;
          l5 = l2;
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            l9 = l11;
            l8 = l10;
            l7 = l3;
            l6 = l1;
            l5 = l2;
            l4 = new BigInteger((String)localObject4).longValue();
          }
          l9 = l11;
          l8 = l4;
          l7 = l3;
          l6 = l1;
          l5 = l2;
          l10 = paramJSONObject.optLong("accountID");
          l9 = l10;
          l8 = l4;
          l7 = l3;
          l6 = l1;
          l5 = l2;
          j = paramJSONObject.optInt("accountType");
          l8 = l4;
          localObject6 = localObject3;
          localObject4 = localObject1;
          localObject1 = localObject5;
          l5 = l2;
          l4 = l3;
          localObject3 = localObject2;
          l2 = l10;
          l3 = l1;
          localObject2 = localObject6;
          l1 = l5;
          l5 = paramJSONObject.optLong("originFeedsType", 1L);
          i = paramJSONObject.optInt("type");
          m = paramJSONObject.optInt("adtag");
          str4 = paramJSONObject.optString("picurl");
          k = paramJSONObject.optInt("duration");
          str5 = new String(bdbi.decode(paramJSONObject.optString("accountDesc"), 0));
          i1 = paramJSONObject.optInt("feedsType", 1);
          localObject6 = new ArticleInfo();
          ((ArticleInfo)localObject6).mArticleID = l3;
          ((ArticleInfo)localObject6).mTitle = ((String)localObject4);
          ((ArticleInfo)localObject6).mSubscribeName = ((String)localObject3);
          ((ArticleInfo)localObject6).mFirstPagePicUrl = str4;
          ((ArticleInfo)localObject6).mVideoDuration = k;
          ((ArticleInfo)localObject6).mFeedId = l1;
          ((ArticleInfo)localObject6).mSummary = str5;
          ((ArticleInfo)localObject6).businessId = l8;
          ((ArticleInfo)localObject6).mFeedType = i1;
          ((ArticleInfo)localObject6).innerUniqueID = ((String)localObject1);
        }
        catch (Exception localException3)
        {
          localObject6 = localObject1;
          localObject1 = localObject3;
          l4 = l7;
          l3 = l6;
          l1 = l5;
          localObject3 = localObject6;
          continue;
          paramJSONObject = str1;
          continue;
          localObject3 = str2;
          continue;
        }
        try
        {
          localObject5 = paramJSONObject.getJSONArray("biuLevelList");
          ((ArticleInfo)localObject6).mSocialFeedInfo = new SocializeFeedsInfo();
          ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_Qmc = new qmc();
          ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_Qmc.jdField_a_of_type_JavaLangLong = Long.valueOf(l4);
          ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_Qmc.jdField_b_of_type_JavaLangLong = Long.valueOf(l5);
          ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_Qmc.jdField_a_of_type_JavaUtilList = new ArrayList();
          if (localObject5 != null)
          {
            k = 0;
            if (k < ((JSONArray)localObject5).length())
            {
              localObject7 = new SocializeFeedsInfo.BiuCommentInfo();
              localObject8 = ((JSONArray)localObject5).getJSONObject(k);
              ((SocializeFeedsInfo.BiuCommentInfo)localObject7).jdField_a_of_type_JavaLangLong = Long.valueOf(((JSONObject)localObject8).optLong("uin"));
              ((SocializeFeedsInfo.BiuCommentInfo)localObject7).jdField_b_of_type_JavaLangString = new String(bdbi.decode(((JSONObject)localObject8).optString("comment"), 0));
              ((SocializeFeedsInfo.BiuCommentInfo)localObject7).jdField_a_of_type_JavaLangString = ((SocializeFeedsInfo.BiuCommentInfo)localObject7).jdField_b_of_type_JavaLangString;
              ((SocializeFeedsInfo.BiuCommentInfo)localObject7).jdField_a_of_type_Int = ((JSONObject)localObject8).optInt("biuTime");
              ((SocializeFeedsInfo.BiuCommentInfo)localObject7).jdField_b_of_type_Int = ((JSONObject)localObject8).optInt("feeds_type", 1);
              ((SocializeFeedsInfo.BiuCommentInfo)localObject7).jdField_c_of_type_Int = ((JSONObject)localObject8).optInt("op_type");
              localObject10 = ((JSONObject)localObject8).optString("jumpName");
              localObject11 = ((JSONObject)localObject8).optString("jumpUrl");
              if ((!TextUtils.isEmpty((CharSequence)localObject10)) && (!TextUtils.isEmpty((CharSequence)localObject11))) {
                ((SocializeFeedsInfo.BiuCommentInfo)localObject7).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo = new SocializeFeedsInfo.JumpInfo(0L, new String(bdbi.decode((String)localObject10, 0)), (String)localObject11);
              }
              if (n != 1) {}
            }
          }
        }
        catch (JSONException localJSONException)
        {
          try
          {
            localObject8 = ((JSONObject)localObject8).optString("feedsId");
            if (!TextUtils.isEmpty((CharSequence)localObject8)) {
              ((SocializeFeedsInfo.BiuCommentInfo)localObject7).jdField_b_of_type_JavaLangLong = Long.valueOf(new BigInteger((String)localObject8).longValue());
            }
            ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_Qmc.jdField_a_of_type_JavaUtilList.add(localObject7);
            k += 1;
            continue;
            ((Exception)localObject4).printStackTrace();
            j = 0;
            localObject6 = localObject2;
            l2 = l9;
            localObject2 = localObject1;
            localObject4 = localObject3;
            localObject3 = localObject6;
            localObject1 = localObject5;
            continue;
            localJSONException = localJSONException;
            localJSONException.printStackTrace();
            str2 = null;
          }
          catch (Exception localException5)
          {
            localException5.printStackTrace();
            continue;
          }
          localObject7 = paramJSONObject.optJSONObject("ugcInfo");
          str2 = "";
          if (localObject7 == null) {
            continue;
          }
        }
        if (rqj.c(i1, l5))
        {
          ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_Qmw = new qmw();
          i2 = ((JSONObject)localObject7).optInt("ugcType", 0);
          str2 = ((JSONObject)localObject7).optString("ugcComment");
          localObject9 = ((JSONObject)localObject7).optJSONArray("ugcAtLevelList");
          if (localObject9 != null)
          {
            ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Qmc = new qmc();
            ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Qmc.jdField_a_of_type_JavaUtilList = new ArrayList();
            k = 0;
            if (k < ((JSONArray)localObject9).length())
            {
              localObject10 = new SocializeFeedsInfo.BiuCommentInfo();
              localObject11 = ((JSONArray)localObject9).getJSONObject(k);
              ((SocializeFeedsInfo.BiuCommentInfo)localObject10).jdField_a_of_type_JavaLangLong = Long.valueOf(((JSONObject)localObject11).optLong("uin"));
              ((SocializeFeedsInfo.BiuCommentInfo)localObject10).jdField_b_of_type_JavaLangString = new String(bdbi.decode(((JSONObject)localObject11).optString("comment"), 0));
              ((SocializeFeedsInfo.BiuCommentInfo)localObject10).jdField_a_of_type_JavaLangString = ((SocializeFeedsInfo.BiuCommentInfo)localObject10).jdField_b_of_type_JavaLangString;
              ((SocializeFeedsInfo.BiuCommentInfo)localObject10).jdField_a_of_type_Int = ((JSONObject)localObject11).optInt("biuTime");
              ((SocializeFeedsInfo.BiuCommentInfo)localObject10).jdField_b_of_type_Int = ((JSONObject)localObject11).optInt("feeds_type", 1);
              ((SocializeFeedsInfo.BiuCommentInfo)localObject10).jdField_c_of_type_Int = ((JSONObject)localObject11).optInt("op_type");
              str6 = ((JSONObject)localObject11).optString("jumpName");
              str7 = ((JSONObject)localObject11).optString("jumpUrl");
              if ((!TextUtils.isEmpty(str6)) && (!TextUtils.isEmpty(str7))) {
                ((SocializeFeedsInfo.BiuCommentInfo)localObject10).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo = new SocializeFeedsInfo.JumpInfo(0L, new String(bdbi.decode(str6, 0)), str7);
              }
              try
              {
                localObject11 = ((JSONObject)localObject11).optString("feedsId");
                if (!TextUtils.isEmpty((CharSequence)localObject11)) {
                  ((SocializeFeedsInfo.BiuCommentInfo)localObject10).jdField_b_of_type_JavaLangLong = Long.valueOf(new BigInteger((String)localObject11).longValue());
                }
                ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Qmc.jdField_a_of_type_JavaUtilList.add(localObject10);
                k += 1;
              }
              catch (Exception localException6)
              {
                localException6.printStackTrace();
                continue;
              }
            }
          }
          ((ArticleInfo)localObject6).mTitle = new String(bdbi.decode(str2, 0));
          ((ArticleInfo)localObject6).mSummary = "";
          if ((i2 != 3) && (i2 != 2)) {
            break label2434;
          }
          ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          localObject4 = new qmx();
          localObject7 = ((JSONObject)localObject7).optJSONArray("ugcPicInfo");
          if ((localObject7 == null) || (((JSONArray)localObject7).length() <= 0)) {
            break label2429;
          }
          ((qmx)localObject4).jdField_c_of_type_JavaLangString = ((JSONArray)localObject7).getJSONObject(0).optString("ugcPicUrl");
          ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_JavaUtilArrayList.add(localObject4);
          break label2429;
          if (m == 22)
          {
            localObject4 = new qlz();
            ((qlz)localObject4).jdField_a_of_type_JavaLangString = ((String)localObject3);
            ((qlz)localObject4).jdField_b_of_type_JavaLangString = str4;
            ((qlz)localObject4).jdField_c_of_type_JavaLangString = str5;
            ((qlz)localObject4).jdField_a_of_type_Long = l2;
            ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Qlz = ((qlz)localObject4);
          }
          ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Int = i2;
          ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_JavaLangString = ((ArticleInfo)localObject6).mTitle;
          localObject3 = str2;
          ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_JavaLangString = "";
          ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_c_of_type_JavaLangString = "";
          ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_b_of_type_JavaLangString = "";
          localObject4 = new Intent(BaseActivity.sTopActivity, ReadInJoyDeliverBiuActivity.class);
          ((Intent)localObject4).putExtra("arg_article_info", (Parcelable)localObject6);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            ((Intent)localObject4).putExtra("biu_rowkey", (String)localObject1);
          }
          ((Intent)localObject4).putExtra("arg_from_type", m);
          ((Intent)localObject4).putExtra("arg_type", i);
          ((Intent)localObject4).putExtra("result_js_callback", paramString);
          i = 3;
          if (m != 5) {
            break label2457;
          }
          i = 4;
          ((Intent)localObject4).putExtra("biu_src", i);
          ((Intent)localObject4).putExtra("feed_id", (String)localObject2);
          ((Intent)localObject4).putExtra("feedsType", i1);
          ((Intent)localObject4).putExtra("ugc_comment", (String)localObject3);
          ((Intent)localObject4).putExtra("arg_account_id", l2);
          ((Intent)localObject4).putExtra("arg_account_type", j);
          ((Intent)localObject4).putExtra("arg_source_url", str3);
          if ((m == 23) && ((TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(((ArticleInfo)localObject6).mSubscribeName))))
          {
            QLog.d(TAG, 1, "web page share but core info empty !");
            return;
            ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_Qmw.b = new ArrayList();
            localObject9 = new qmy();
            localObject7 = ((JSONObject)localObject7).optJSONObject("ugcVideoInfo");
            if (localObject7 == null) {
              break label2449;
            }
            ((qmy)localObject9).d = ((JSONObject)localObject7).optString("ugcVideoCoverUrl");
            ((qmy)localObject9).jdField_a_of_type_Long = ((JSONObject)localObject7).optInt("ugcVideoDuration");
            ((qmy)localObject9).e = ((String)localObject4);
            ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_Qmw.b.add(localObject9);
            break label2449;
            if (i2 != 1) {
              break label2454;
            }
            ((ArticleInfo)localObject6).mFirstPagePicUrl = "";
            break label2454;
          }
          if (n == 1)
          {
            if ((((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_Qmc.jdField_a_of_type_JavaUtilList == null) || (((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_Qmc.jdField_a_of_type_JavaUtilList.size() <= 0)) {
              continue;
            }
            paramJSONObject = str1 + "//";
            paramJSONObject = "：" + paramJSONObject;
            paramString = (QQAppInterface)ors.a();
            if (paramString == null) {
              break;
            }
            ((oxd)paramString.getManager(163)).a().a(ors.a(), l1, ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_Qmc, 0L, paramJSONObject, l3, -1L, i, (String)localObject1, i1, (ArticleInfo)localObject6);
            return;
          }
          if (paramJSONObject.optInt("hideSuccessToast") == 1)
          {
            bool = true;
            ((Intent)localObject4).putExtra("hideSuccessToast", bool);
            BaseActivity.sTopActivity.startActivityForResult((Intent)localObject4, 113);
            BaseActivity.sTopActivity.overridePendingTransition(0, 0);
            return;
          }
          bool = false;
          continue;
        }
        continue;
        i = 1;
      }
      catch (JSONException paramJSONObject)
      {
        return;
      }
      label2429:
      continue;
      label2434:
      if (i2 != 4) {
        if (i2 == 5)
        {
          continue;
          label2449:
          i = 2;
          continue;
          label2454:
          continue;
          label2457:
          if (m == 11) {
            i = 5;
          } else if (m == 6) {
            i = 6;
          } else if (m == 12) {
            i = 7;
          } else if (m == 13) {
            i = 8;
          } else if (m >= 15) {
            i = m;
          } else if (m == 8) {
            i = 2;
          }
        }
      }
    }
  }
  
  private void showPicture(JSONObject paramJSONObject, String paramString)
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
          bcch.a((Activity)localObject2, j, paramJSONObject, null, null, false, bool, (String)localObject1, 100, null, null, null, null, "", true);
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
  
  private void showReadinjoyPicture(JSONObject paramJSONObject, String paramString)
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
        String str2 = new String(bdbi.decode(paramJSONObject.optString("title", ""), 0));
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
          localBundle.putString("scroll_image_r5", ors.a(i, -1, Integer.toString(n), m, "", "", null));
          localBundle.putString("read_article_r5", ors.a(i, -1, Integer.toString(n), m, "", null));
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
  
  private void showShareMenu(JSONObject paramJSONObject, @NonNull String paramString)
  {
    Object localObject = getViolaInstance().getFragment();
    if (localObject != null) {}
    for (localObject = ((Fragment)localObject).getActivity(); localObject == null; localObject = getViolaInstance().getActivity()) {
      return;
    }
    AppInterface localAppInterface = (AppInterface)ors.a();
    JSONObject localJSONObject = paramJSONObject.optJSONObject("shareInfo");
    String str = paramJSONObject.optString("menu_title", alpo.a(2131701560));
    JSONArray localJSONArray = paramJSONObject.optJSONArray("hide_items");
    if (paramJSONObject.optInt("show_diandian", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramJSONObject = new HashSet();
      if (localJSONArray == null) {
        break;
      }
      int i = 0;
      while (i < localJSONArray.length())
      {
        paramJSONObject.add(localJSONArray.optString(i));
        i += 1;
      }
    }
    this.mShareHelper = new syq((Activity)localObject, localAppInterface, null, new spl(this, false, null, null, localJSONObject, new WeakReference(localObject), paramString));
    this.mShareHelper.a.setActionSheetTitle(str);
    this.mShareHelper.a.setOnDismissListener(new sof(this));
    this.mShareHelper.a(spp.a(bool, paramJSONObject));
  }
  
  private void showTips(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = (QQAppInterface)ors.a();
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
        QQToast.a((Context)localObject, i, str, 0).b(((Context)localObject).getResources().getDimensionPixelSize(2131298914));
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
  
  private void showUGCEditPage(JSONObject paramJSONObject, String paramString)
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
        paramJSONObject = new String(bdbi.decode((String)localObject, 0));
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
  
  private void showUGCVideoRecordPage(JSONObject paramJSONObject, String paramString)
  {
    Object localObject1 = (AppInterface)ors.a();
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
      paramJSONObject = new String(bdbi.decode((String)localObject2, 0));
      if (ors.g() >= 2)
      {
        QQToast.a((Context)localObject1, 0, ((Activity)localObject1).getString(2131718857), 0).b(((Activity)localObject1).getResources().getDimensionPixelSize(2131298914));
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
      ois.a((Activity)localObject1, (Bundle)localObject2, (byte)116);
      ors.a("2", "2");
    }
  }
  
  private void suspensionPopBack(String paramString)
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
  
  public static void unRegisterReceiver()
  {
    if ((BaseApplicationImpl.getContext() != null) && (mGdtAppReceiver != null))
    {
      BaseApplicationImpl.getContext().unregisterReceiver(mGdtAppReceiver);
      mGdtAppReceiver = null;
    }
  }
  
  private void updateIfNeed(JSONObject paramJSONObject, String paramString)
  {
    smk.a(String.valueOf(paramJSONObject.optInt("bid", 3256)), new soi(this, paramString));
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
  
  @JSMethod
  public void addFavorite(JSONObject paramJSONObject)
  {
    Object localObject = (QQAppInterface)ors.a();
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
        break label220;
      }
    }
    label220:
    for (int i = 1;; i = 2)
    {
      localBundle.putInt("videoType", i);
      pej.a().a(getViolaInstance().getActivity(), (String)localObject, 2, str1, str2, str3, str4, str5, localBundle);
      return;
    }
  }
  
  @JSMethod
  public void c2sReport(JSONObject paramJSONObject)
  {
    try
    {
      aanp.a(TAG, paramJSONObject.toString());
      aanv.a(paramJSONObject.optInt("operationType"), paramJSONObject.optInt("businessType"), (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(aano.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramJSONObject.getJSONObject("adInfo"))));
      return;
    }
    catch (Exception paramJSONObject)
    {
      aanp.d(TAG, "handleJsCallRequest", paramJSONObject);
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
  
  @JSMethod
  public void cancelUploadingVideo(JSONObject paramJSONObject, String paramString)
  {
    String str = paramJSONObject.optString("vid");
    int i = paramJSONObject.optInt("pageType", 0);
    int j = paramJSONObject.optInt("topicId", 0);
    QLog.i(TAG, 1, "cancelUploadingVideo, content=" + paramJSONObject.toString() + ",callbackId=" + paramString);
    paramJSONObject = ors.a();
    if (paramJSONObject != null) {
      qun.a(paramJSONObject).a(j, new sou(this, str, paramJSONObject, i, j, paramString));
    }
  }
  
  @JSMethod
  public void cancelVideoPreDownload()
  {
    if (this.mVideoPreDownloadMgr != null) {
      this.mVideoPreDownloadMgr.e();
    }
  }
  
  @JSMethod
  public void channelRequestSign(String paramString1, String paramString2)
  {
    paramString1 = bfhh.a("QQ_" + ors.a() + "_" + paramString1).toLowerCase();
    if (getViolaInstance() != null) {
      ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), getModuleName(), "callback", paramString2, paramString1, true);
    }
  }
  
  @JSMethod
  public void chooseVideoAddToTopic(JSONObject paramJSONObject, String paramString)
  {
    int i = 0;
    QLog.i(TAG, 1, "chooseVideoAddToTopic, callback = " + paramString + ", jsonObject = " + paramJSONObject.toString());
    JSONArray localJSONArray = paramJSONObject.optJSONArray("videoList");
    ArrayList localArrayList = new ArrayList();
    JSONObject localJSONObject = new JSONObject();
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
      i = paramJSONObject.optInt("topicId", 0);
      if ((!localArrayList.isEmpty()) && (i != 0))
      {
        qte.a(localArrayList, i, new sor(this, localJSONObject, paramString));
        return;
      }
      localJSONObject.put("errCode", -1);
      localJSONObject.put("errMsg", "rowkeys.isEmpty() || columnId == 0");
      invokeJS(paramString, localJSONObject);
      return;
      i += 1;
    }
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
      this.mVideoPreDownloadMgr.e();
      this.mVideoPreDownloadMgr = null;
    }
    if (this.violaVideoUpdateController != null) {
      this.violaVideoUpdateController.b();
    }
    QQAppInterface localQQAppInterface = ors.a();
    if (localQQAppInterface != null) {
      qun.a(localQQAppInterface).b(this.videoPublishCallback);
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "destroy by instance");
    }
    if (this.dataManager != null) {
      this.dataManager.a();
    }
  }
  
  @JSMethod
  public void dwellTimeMillisReport(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("dwellTimeMillis");
      paramJSONObject = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(aano.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramJSONObject.getJSONObject("adInfo")));
      aanu localaanu = new aanu();
      localaanu.jdField_a_of_type_ComTencentAdTangramAd = new GdtAd(paramJSONObject);
      localaanu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.set(42);
      localaanu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(i);
      aant.a(localaanu);
      return;
    }
    catch (Exception paramJSONObject)
    {
      aanp.d(TAG, "handleJsCallRequest", paramJSONObject);
    }
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
        if (ohq.a() == 1)
        {
          paramJSONObject = "fastBiu";
          String str;
          if (ohq.b() == 1)
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
  
  @JSMethod
  public void getCreateTopicPermission(JSONObject paramJSONObject, String paramString)
  {
    getReadInJoyUgcPermission(paramJSONObject, paramString, 1);
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
  
  @JSMethod
  public void getMotiveAd(String paramString, JSONObject paramJSONObject)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    paramString = new spg(this, paramString);
    if (localBaseActivity == null)
    {
      paramString.a(null, new aaio(5));
      return;
    }
    String str = paramJSONObject.optString("posId", "1041305064862972");
    long l1 = paramJSONObject.optLong("publicId", 0L);
    long l2 = paramJSONObject.optLong("articleId", 0L);
    int i = paramJSONObject.optInt("sourceFrom", 0);
    int j = paramJSONObject.optInt("shareRate", 0);
    oeg.a().a(localBaseActivity, str, l1, l2, i, j, paramString);
  }
  
  @JSMethod(uiThread=false)
  public void getNetType(String paramString)
  {
    getNetType(paramString, false);
  }
  
  public void getNetType(String paramString, boolean paramBoolean)
  {
    int i = ndd.a();
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
    int k = ndd.a();
    String str = ndd.a();
    int j = 0;
    Object localObject = bdcb.b();
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
    int i = paramJSONObject.optInt("topicId", 0);
    this.columnToUploadCallbackMap.put(Long.valueOf(i), paramString);
    paramJSONObject = ors.a();
    if (paramJSONObject != null) {
      qun.a(paramJSONObject).a(this.videoPublishCallback);
    }
    if (this.violaVideoUpdateController == null) {
      this.violaVideoUpdateController = new qvc(new BridgeModule.33(this, i, paramString), 500L);
    }
    this.violaVideoUpdateController.a();
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
  public void handleClick(JSONObject paramJSONObject)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    try
    {
      aanp.b(TAG, paramJSONObject.toString());
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
      paramJSONObject = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(aano.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramJSONObject.getJSONObject("adInfo")));
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
      aanp.d(TAG, "handleJsCallRequest error", paramJSONObject);
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
      bool = xoo.a(localBaseActivity);
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
      bool = bdem.a(localBaseActivity, paramString1);
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
        RIJRedPacketManager.a().a(2, new soq(this, paramString));
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
        if (!bjxj.o()) {
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
  public void hideTopicVideoComment(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("ref", "");
    ViolaDomManager localViolaDomManager = ViolaSDKManager.getInstance().getDomManager();
    if (getViolaInstance() != null)
    {
      paramJSONObject = localViolaDomManager.getDomContext(getViolaInstance().getInstanceId()).getComponent(paramJSONObject);
      if ((paramJSONObject != null) && (paramJSONObject.getHostView() != null))
      {
        paramJSONObject.getHostView();
        this.mCommentManager.a(false);
      }
    }
  }
  
  @JSMethod
  public void invoke(JSONObject paramJSONObject, String paramString)
  {
    String str1 = paramJSONObject.optString("ns");
    String str2 = paramJSONObject.optString("method");
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
    {
      invokeErrorCallJS(paramString, alpo.a(2131701570));
      QLog.d(TAG, 1, "ns or method not exists");
    }
    label223:
    label3567:
    for (;;)
    {
      return;
      Object localObject3 = TAG;
      Object localObject4 = new StringBuilder().append("ns: ").append(str1).append(" method: ").append(str2).append(" params: ");
      Object localObject1;
      int i;
      if (paramJSONObject != null)
      {
        localObject1 = paramJSONObject.toString();
        QLog.d((String)localObject3, 1, (String)localObject1);
        if (!"readinjoy".equals(str1)) {
          break label1021;
        }
        if (!"openPrivateLetter".equals(str2)) {
          break label223;
        }
        openPrivateLetter();
        i = 0;
      }
      for (;;)
      {
        if ((i == 0) || (invokeBridgeApi(paramJSONObject, paramString))) {
          break label3567;
        }
        invokeErrorCallJS(paramString, "ns:" + str1 + alpo.a(2131701566) + str2 + alpo.a(2131701561));
        return;
        localObject1 = " null ";
        break;
        if ("openVideo".equals(str2))
        {
          openVideo(paramJSONObject.optJSONObject("params"));
          i = 0;
        }
        else
        {
          if ("QReport".equals(str2))
          {
            if (paramJSONObject.optJSONObject("params") != null)
            {
              reportT(paramJSONObject.optJSONObject("params"));
              i = 0;
            }
          }
          else if ("showUGCEditPage".equals(str2))
          {
            if (paramJSONObject.optJSONObject("params") != null)
            {
              showUGCEditPage(paramJSONObject.optJSONObject("params"), paramString);
              i = 0;
            }
          }
          else if ("showMultiBiuEditPage".equals(str2))
          {
            if (paramJSONObject.optJSONObject("params") != null)
            {
              showMultiBiuEditPage(paramJSONObject.optJSONObject("params"), paramString);
              i = 0;
            }
          }
          else if ("selectAndInviteFriend".equals(str2))
          {
            if (paramJSONObject.optJSONObject("params") != null)
            {
              selectAndInviteFriend(paramJSONObject.optJSONObject("params"), paramString);
              i = 0;
            }
          }
          else if ("selectAndUploadAvatar".equals(str2))
          {
            if (paramJSONObject.optJSONObject("params") != null)
            {
              this.mUploadCallBack = paramString;
              selectAndUploadAvatar(paramJSONObject.optJSONObject("params"), paramString);
              i = 0;
            }
          }
          else if ("uploadTopicPic".endsWith(str2))
          {
            if (paramJSONObject.optJSONObject("params") != null)
            {
              this.mUploadCallBack = paramString;
              uploadTopicPic(paramJSONObject.optJSONObject("params"), paramString);
              i = 0;
            }
          }
          else if ("showPicture".equals(str2))
          {
            if (paramJSONObject.optJSONObject("params") != null)
            {
              showReadinjoyPicture(paramJSONObject.optJSONObject("params"), paramString);
              i = 0;
            }
          }
          else if ("openAccountPageMore".equals(str2))
          {
            if (paramJSONObject.optJSONObject("params") != null)
            {
              openAccountPageMore(paramJSONObject.optJSONObject("params"), paramString);
              i = 0;
            }
          }
          else if ("socialize_feeds_update".equals(str2))
          {
            if (paramJSONObject.optJSONObject("params") != null)
            {
              socailFeedsUpdate(paramJSONObject.optJSONObject("params"), paramString);
              i = 0;
            }
          }
          else if ("updateAccountCardFollowInfo".equals(str2))
          {
            if (paramJSONObject.optJSONObject("params") != null)
            {
              updateAccountCardFollowInfo(paramJSONObject.optJSONObject("params"), paramString);
              i = 0;
            }
          }
          else if ("updateTopicCardFollowInfo".equals(str2))
          {
            if (paramJSONObject.optJSONObject("params") != null)
            {
              updateTopicCardFollowInfo(paramJSONObject.optJSONObject("params"), paramString);
              i = 0;
            }
          }
          else if ("showVisibleUserList".equals(str2))
          {
            if (paramJSONObject.optJSONObject("params") != null)
            {
              showVisibleUserList(paramJSONObject.optJSONObject("params"), paramString);
              i = 0;
            }
          }
          else
          {
            if ("getBiuTriggerType".equals(str2))
            {
              getBiuTriggerType(paramJSONObject.optJSONObject("params"), paramString);
              i = 0;
              continue;
            }
            if ("showShareReadInJoyMenu".equals(str2))
            {
              if (paramJSONObject.optJSONObject("params") != null)
              {
                showShareReadInJoyMenu(paramJSONObject.optJSONObject("params"), paramString);
                i = 0;
              }
            }
            else if ("showUGCVideoRecordPage".equals(str2))
            {
              if (paramJSONObject.optJSONObject("params") != null)
              {
                showUGCVideoRecordPage(paramJSONObject.optJSONObject("params"), paramString);
                i = 0;
              }
            }
            else if ("showCommentEditor".equals(str2))
            {
              if (paramJSONObject.optJSONObject("params") != null)
              {
                showCommentEditor(paramJSONObject.optJSONObject("params"), paramString);
                i = 0;
              }
            }
            else if ("feeds_refresh_message".equals(str2))
            {
              if (paramJSONObject.optJSONObject("params") != null)
              {
                feedsRefreshMessage(paramJSONObject.optJSONObject("params"));
                i = 0;
              }
            }
            else
            {
              if ("isInKanDianTab".equals(str2))
              {
                isInkanDianTab(paramString);
                i = 0;
                continue;
              }
              if ("hasRedPacketPermission".equals(str2))
              {
                hasRedPacketPermission(paramString);
                i = 0;
                continue;
              }
              if ("hasRedPacketSharePermission".equals(str2))
              {
                hasRedPacketSharePermission(paramString);
                i = 0;
                continue;
              }
              if ("updateRedPacketShareTime".equals(str2))
              {
                updateRedPacketShareTime();
                i = 0;
                continue;
              }
              if ("requestRedPacketContentShareToast".equals(str2))
              {
                requestRedPacketContentShareToast(paramString);
                i = 0;
                continue;
              }
              if ("requestBubbleTipsWording".equals(str2))
              {
                requestBubbleTipsWording(paramJSONObject.optJSONObject("params"), paramString);
                i = 0;
                continue;
              }
              if ("onClickBubbleTips".equals(str2))
              {
                onClickBubbleTips(paramJSONObject.optJSONObject("params"), paramString);
                i = 0;
                continue;
              }
              i = 1;
              continue;
              label1021:
              if ("data".equals(str1))
              {
                if ("ssoRequest".equals(str2))
                {
                  sendRequest(paramJSONObject.optJSONObject("params"), paramString);
                  i = 0;
                  continue;
                }
                if ("getUserInfo".equals(str2))
                {
                  getUserInfo(paramString, true);
                  i = 0;
                  continue;
                }
                if ("setClipboard".equals(str2))
                {
                  if (paramJSONObject.optJSONObject("params") != null)
                  {
                    setClipboard(paramJSONObject.optJSONObject("params").optString("text"), paramString);
                    i = 0;
                  }
                }
                else
                {
                  if ("getClipboard".equals(str2))
                  {
                    getClipboard(paramString);
                    i = 0;
                    continue;
                  }
                  if ("getPerformance".equals(str2))
                  {
                    getPerformance(paramString);
                    i = 0;
                    continue;
                  }
                  i = 1;
                }
              }
              else if ("ui".equals(str1))
              {
                if ("showTips".equals(str2))
                {
                  showTips(paramJSONObject.optJSONObject("params"), paramString);
                  i = 0;
                  continue;
                }
                if ("openPage".equals(str2))
                {
                  if (paramJSONObject.optJSONObject("params") != null)
                  {
                    openPage(paramJSONObject.optJSONObject("params"), paramString);
                    i = 0;
                  }
                }
                else
                {
                  if ("openUrl".equals(str2))
                  {
                    openUrl(paramJSONObject.optJSONObject("params"), paramString);
                    i = 0;
                    continue;
                  }
                  if ("setTitle".equals(str2))
                  {
                    setTitle(paramJSONObject.optJSONObject("params"), paramString);
                    i = 0;
                    continue;
                  }
                  if ("pageVisibility".equals(str2))
                  {
                    pageVisibility(paramString);
                    i = 0;
                    continue;
                  }
                  if ("popBack".equals(str2))
                  {
                    popBack(paramString);
                    i = 0;
                    continue;
                  }
                  if ("suspensionPopBack".equals(str2))
                  {
                    suspensionPopBack(paramString);
                    i = 0;
                    continue;
                  }
                  if ("setNavBtn".equals(str2))
                  {
                    setNavBtn(paramJSONObject.optJSONObject("params"), paramString);
                    i = 0;
                    continue;
                  }
                  if ("showDialog".equals(str2))
                  {
                    showDialog(paramJSONObject.optJSONObject("params"), paramString);
                    i = 0;
                    continue;
                  }
                  if ("showShareMenu".equals(str2))
                  {
                    showShareMenu(paramJSONObject.optJSONObject("params"), paramString);
                    i = 0;
                    continue;
                  }
                  if ("canOpenPage".equals(str2))
                  {
                    if (paramJSONObject.optJSONObject("params") != null)
                    {
                      canOpenPage(paramJSONObject.optJSONObject("params"), paramString);
                      i = 0;
                    }
                  }
                  else if ("setNavBar".equals(str2))
                  {
                    if (paramJSONObject.optJSONObject("params") != null)
                    {
                      setNavBar(paramJSONObject.optJSONObject("params"), paramString);
                      i = 0;
                    }
                  }
                  else if ("setRightDragToGoBackParams".equals(str2))
                  {
                    if (paramJSONObject.optJSONObject("params") != null)
                    {
                      setRightDragToGoBackParams(paramJSONObject.optJSONObject("params"), paramString);
                      i = 0;
                    }
                  }
                  else
                  {
                    if ("showActionSheet".equals(str2))
                    {
                      if (this.mActionSheetHelper == null) {
                        this.mActionSheetHelper = new snu(this);
                      }
                      this.mActionSheetHelper.a(paramJSONObject.optJSONObject("params"), paramString);
                      i = 0;
                      continue;
                    }
                    if ("violaTitleBarClick".equals(str2))
                    {
                      setTitleClickListener(paramString);
                      i = 0;
                      continue;
                    }
                    if ("openPluginView".equals(str2))
                    {
                      if (paramJSONObject.optJSONObject("params") != null)
                      {
                        localObject1 = paramJSONObject.optJSONObject("params").optString("url");
                        localObject3 = BaseActivity.sTopActivity;
                        if ((localObject3 != null) && (localObject1 != null) && (!((String)localObject1).isEmpty())) {
                          LiveRoomProxyActivity.open((Activity)localObject3, (String)localObject1, "Readinjoy feeds");
                        }
                        i = 0;
                      }
                    }
                    else
                    {
                      if ("arouseReadInJoyNativeCommentView".equals(str2))
                      {
                        localObject3 = paramJSONObject.optJSONObject("params");
                        if (localObject3 != null)
                        {
                          if (((JSONObject)localObject3).optBoolean("isAlbum", true)) {
                            arouseReadInJoyNativeCommentView((JSONObject)localObject3, paramString);
                          }
                        }
                        else
                        {
                          i = 0;
                          continue;
                        }
                        if (TextUtils.isEmpty(((JSONObject)localObject3).optString("callback"))) {}
                        for (localObject1 = paramString;; localObject1 = ((JSONObject)localObject3).optString("callback"))
                        {
                          sxe.a((JSONObject)localObject3, (String)localObject1, new sph(this));
                          break;
                        }
                      }
                      if ("sharePicMessage".equals(str2))
                      {
                        if (paramJSONObject.optJSONObject("params") != null)
                        {
                          sharePicMessage(paramJSONObject.optJSONObject("params"), paramString);
                          i = 0;
                        }
                      }
                      else
                      {
                        if ("isNightMode".equals(str2))
                        {
                          isNightMode(paramString);
                          i = 0;
                          continue;
                        }
                        if ("biuCommentAladdinConfig".equals(str2))
                        {
                          UiApiPlugin.a(true, paramString, new spi(this));
                          i = 0;
                          continue;
                        }
                        if ("showCommentEditor".equals(str2))
                        {
                          if (paramJSONObject.optJSONObject("params") != null)
                          {
                            UiApiPlugin.a(paramJSONObject.optJSONObject("params"), paramString, getViolaInstance().getActivity());
                            i = 0;
                          }
                        }
                        else {
                          i = 1;
                        }
                      }
                    }
                  }
                }
              }
              else if ("app".equals(str1))
              {
                if ("downloadApp".equals(str2))
                {
                  if (paramJSONObject.optString("params") != null)
                  {
                    downloadApp(paramJSONObject.optString("params"));
                    i = 0;
                  }
                }
                else if ("isAppInstalled".equals(str2))
                {
                  if (paramJSONObject.optJSONObject("params") != null)
                  {
                    hasApp(paramJSONObject.optJSONObject("params").optString("identifier"), paramString, true);
                    i = 0;
                  }
                }
                else if ("launchApp".equals(str2))
                {
                  if (paramJSONObject.optJSONObject("params") != null)
                  {
                    openApp(paramJSONObject.optJSONObject("params").optString("schema"), paramString, paramJSONObject.optJSONObject("params").optString("sourceId"));
                    i = 0;
                  }
                }
                else if ("getDownloadApkState".equals(str2))
                {
                  if ((paramJSONObject.optJSONObject("params") != null) && (!TextUtils.isEmpty(paramString)))
                  {
                    getDownloadApkState(paramJSONObject.optJSONObject("params"), paramString);
                    i = 0;
                  }
                }
                else if ("downloadApk".equals(str2))
                {
                  if (paramJSONObject.optJSONObject("params") != null)
                  {
                    downloadApk(paramJSONObject.optJSONObject("params"), paramString);
                    i = 0;
                  }
                }
                else if ("downloadApkAction".equals(str2))
                {
                  if (paramJSONObject.optJSONObject("params") != null)
                  {
                    downloadApkAction(paramJSONObject.optJSONObject("params"));
                    i = 0;
                  }
                }
                else if ("downloadApkPause".equals(str2))
                {
                  if (paramJSONObject.optJSONObject("params") != null)
                  {
                    downloadApkPause(paramJSONObject.optJSONObject("params"));
                    i = 0;
                  }
                }
                else if ("downloadApkCancel".equals(str2))
                {
                  if (paramJSONObject.optJSONObject("params") != null)
                  {
                    downloadApkCancel(paramJSONObject.optJSONObject("params"));
                    i = 0;
                  }
                }
                else if ("downloadApkResume".equals(str2))
                {
                  if (paramJSONObject.optJSONObject("params") != null)
                  {
                    downloadApkResume(paramJSONObject.optJSONObject("params"));
                    i = 0;
                  }
                }
                else {
                  i = 1;
                }
              }
              else
              {
                if ("device".equals(str1))
                {
                  if ("getDeviceInfo".equals(str2))
                  {
                    getDeviceInfo(paramString, true);
                    i = 0;
                    continue;
                  }
                  if ("getNetworkInfo".equals(str2))
                  {
                    getNetworkInfo(paramString, true);
                    i = 0;
                    continue;
                  }
                  if ("getNetType".equals(str2))
                  {
                    getNetType(paramString, true);
                    i = 0;
                    continue;
                  }
                  if ("getClientInfo".equals(str2))
                  {
                    getClientInfo(paramString);
                    i = 0;
                    continue;
                  }
                  if ("getCUKingStatus".equals(str2))
                  {
                    getCUKingStatus(paramString);
                    i = 0;
                    continue;
                  }
                  if ("getGdtInfo".equals(str2))
                  {
                    getGdtInfo(paramString);
                    i = 0;
                    continue;
                  }
                  if ("getRecommendFlag".equals(str2))
                  {
                    getRecommendFlag(paramString);
                    i = 0;
                    continue;
                  }
                  i = 1;
                  continue;
                }
                if ("debug".equals(str1))
                {
                  if ("detailLog".equals(str2))
                  {
                    if (paramJSONObject.optJSONObject("params") != null)
                    {
                      detailLog(paramJSONObject.optJSONObject("params"), paramString);
                      i = 0;
                    }
                  }
                  else {
                    i = 1;
                  }
                }
                else if ("media".equals(str1))
                {
                  if ("showPicture".equals(str2))
                  {
                    if (paramJSONObject.optJSONObject("params") != null)
                    {
                      showPicture(paramJSONObject.optJSONObject("params"), paramString);
                      i = 0;
                    }
                  }
                  else if ("saveImage".equals(str2))
                  {
                    if (paramJSONObject.optJSONObject("params") != null)
                    {
                      saveImage(paramJSONObject.optJSONObject("params"), paramString);
                      i = 0;
                    }
                  }
                  else {
                    i = 1;
                  }
                }
                else if ("offline".equals(str1))
                {
                  if ("updateIfNeed".equals(str2))
                  {
                    if (paramJSONObject.optJSONObject("params") != null)
                    {
                      updateIfNeed(paramJSONObject.optJSONObject("params"), paramString);
                      i = 0;
                    }
                  }
                  else if ("batchCheckUpdate".equals(str2))
                  {
                    if (paramJSONObject.optJSONObject("params") != null)
                    {
                      batchCheckUpdate(paramJSONObject.optJSONObject("params"), paramString);
                      i = 0;
                    }
                  }
                  else {
                    i = 1;
                  }
                }
                else
                {
                  if ("event".equals(str1))
                  {
                    if ("addEventListener".equals(str2))
                    {
                      ensureEventHelper();
                      this.mEventHelper.a(paramJSONObject.optJSONObject("params"), paramString);
                      i = 0;
                      continue;
                    }
                    if ("removeEventListener".equals(str2))
                    {
                      ensureEventHelper();
                      this.mEventHelper.b(paramJSONObject.optJSONObject("params"), paramString);
                      i = 0;
                      continue;
                    }
                    if ("dispatchEvent".equals(str2))
                    {
                      ensureEventHelper();
                      this.mEventHelper.c(paramJSONObject.optJSONObject("params"), paramString);
                      i = 0;
                      continue;
                    }
                    i = 1;
                    continue;
                  }
                  if ("schema".equals(str1))
                  {
                    if ("jumpAction".equals(str2))
                    {
                      localObject1 = paramJSONObject.optJSONObject("params");
                      if (localObject1 == null)
                      {
                        invokeErrorCallJS(paramString, "params is null");
                        return;
                      }
                      if (!((JSONObject)localObject1).has("schema"))
                      {
                        invokeErrorCallJS(paramString, "schema is null");
                        return;
                      }
                      localObject3 = getViolaInstance().getActivity();
                      localObject4 = (QQAppInterface)ors.a();
                      if ((localObject3 != null) && (localObject4 != null)) {}
                      for (;;)
                      {
                        try
                        {
                          localObject1 = bdds.a((QQAppInterface)localObject4, (Context)localObject3, ((JSONObject)localObject1).getString("schema"));
                          if (localObject1 != null)
                          {
                            ((bddb)localObject1).a("viola");
                            ((bddb)localObject1).c();
                            invokeCallJS(paramString, null);
                          }
                        }
                        catch (JSONException localJSONException)
                        {
                          localJSONException.printStackTrace();
                          continue;
                        }
                        i = 0;
                        break;
                        invokeErrorCallJS(paramString, "activity or app is null");
                      }
                    }
                    i = 1;
                    continue;
                  }
                  if ("gdt".equals(str1))
                  {
                    if ("getDeviceInfo".equals(str2))
                    {
                      getGdtDeviceInfo(paramString, paramJSONObject.optJSONObject("params"));
                      i = 0;
                      continue;
                    }
                    if ("handleClick".equals(str2))
                    {
                      handleClick(paramJSONObject.optJSONObject("params"));
                      i = 0;
                      continue;
                    }
                    if ("c2sReport".equals(str2))
                    {
                      c2sReport(paramJSONObject.optJSONObject("params"));
                      i = 0;
                      continue;
                    }
                    if ("dwellTimeMillisReport".equals(str2))
                    {
                      dwellTimeMillisReport(paramJSONObject.optJSONObject("params"));
                      i = 0;
                      continue;
                    }
                    if ("getMotiveAd".equals(str2))
                    {
                      getMotiveAd(paramString, paramJSONObject.optJSONObject("params"));
                      i = 0;
                      continue;
                    }
                    if ("showMotiveAd".equals(str2))
                    {
                      showMotiveAd(paramString, paramJSONObject.optJSONObject("params"));
                      i = 0;
                    }
                  }
                  else
                  {
                    Object localObject2;
                    if ("nowlive".equals(str1))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, "nowlive   call method" + str2);
                      }
                      if ("getPluginInfo".equals(str2))
                      {
                        i = 0;
                        continue;
                      }
                      if ("openRoom".equals(str2))
                      {
                        if (!TextUtils.isEmpty(paramJSONObject.optString("params")))
                        {
                          localObject3 = paramJSONObject.optString("params");
                          localObject2 = new Bundle();
                          ((Bundle)localObject2).putInt("jumpType", 1);
                          ((Bundle)localObject2).putString("roomid", (String)localObject3);
                          ((Bundle)localObject2).putString("fromid", "violaCall");
                          if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "nowlive openRoom  roomid = " + (String)localObject3);
                          }
                          localObject3 = BaseApplicationImpl.getApplication().getRuntime();
                          if ((localObject3 instanceof QQAppInterface)) {
                            ((asyy)((QQAppInterface)localObject3).getManager(306)).a((Bundle)localObject2);
                          }
                          i = 0;
                        }
                      }
                      else
                      {
                        if ("install".equals(str2))
                        {
                          paramJSONObject.optInt("params", 0);
                          i = 0;
                          continue;
                        }
                        if ("preload".equals(str2))
                        {
                          ThreadManager.post(new BridgeModule.10(this), 8, null, true);
                          i = 0;
                          continue;
                        }
                        invokeErrorCallJS(paramString, alpo.a(2131701564) + str2 + alpo.a(2131701565));
                        i = 0;
                      }
                    }
                    else if ("publicAccountNew".equals(str1))
                    {
                      if ("showReadInJoyNativeCommentView".equals(str2))
                      {
                        localObject3 = paramJSONObject.optJSONObject("params");
                        if (localObject3 != null) {
                          if (!TextUtils.isEmpty(((JSONObject)localObject3).optString("callback"))) {
                            break label3508;
                          }
                        }
                        for (localObject2 = paramString;; localObject2 = ((JSONObject)localObject3).optString("callback"))
                        {
                          sxe.a((JSONObject)localObject3, (String)localObject2, new snz(this));
                          i = 0;
                          break;
                        }
                      }
                    }
                    else if ("sensor".equals(str1))
                    {
                      if ("getLocation".equals(str2))
                      {
                        fireGetLocation(paramJSONObject.optJSONObject("params"), paramString);
                        i = 0;
                      }
                    }
                    else
                    {
                      i = 1;
                      continue;
                    }
                  }
                }
              }
            }
          }
          i = 0;
        }
      }
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
      if (ReadinjoyTabFrame.c_()) {}
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
        if (bdvr.a() == 1)
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
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int j = 0;
    int i = 0;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.mCommentManager != null) {
      this.mCommentManager.a(paramInt1, paramInt2, paramIntent);
    }
    if ((paramInt1 == 114) || (paramInt1 == 115) || (paramInt1 == 116) || (paramInt1 == 122)) {
      if (paramIntent != null) {}
    }
    for (;;)
    {
      return;
      Object localObject3 = paramIntent.getStringExtra("arg_callback");
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        Object localObject2 = "";
        Object localObject1 = localObject2;
        switch (paramInt1)
        {
        default: 
          localObject1 = localObject2;
        }
        for (;;)
        {
          if (paramInt2 != -1) {
            break label265;
          }
          paramIntent = paramIntent.getStringExtra("arg_result_json");
          if (paramIntent == null) {
            break;
          }
          try
          {
            paramIntent = new JSONObject(paramIntent);
            paramIntent.put("retCode", 0);
            localObject2 = paramIntent.toString();
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, (String)localObject1 + " result:" + ReadInJoyDeliverUGCActivity.a((String)localObject2));
            }
            invokeCallJS((String)localObject3, paramIntent);
            return;
          }
          catch (Exception paramIntent)
          {
            return;
          }
          localObject1 = "showUGCEditPage";
          continue;
          localObject1 = "showUGCVideoUploadPage";
          continue;
          localObject1 = "showUGCVideoRecordPage";
          continue;
          localObject1 = "showQAAskEditor";
        }
        try
        {
          label265:
          paramIntent = new JSONObject();
          paramIntent.put("retCode", paramInt2);
          paramIntent = paramIntent.toString();
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, (String)localObject1 + " result:" + paramIntent);
          }
          invokeErrorCallJS((String)localObject3, "result not ok");
          return;
        }
        catch (Exception paramIntent)
        {
          return;
        }
        if (paramInt1 == 113)
        {
          if (paramInt2 != -1) {
            break label1830;
          }
          paramInt1 = i;
          if (paramIntent == null) {
            continue;
          }
          localObject1 = paramIntent.getStringExtra("result_js_callback");
          localObject2 = paramIntent.getStringExtra("feed_id");
          paramInt2 = paramIntent.getIntExtra("feedsType", 1);
          if ((localObject1 == null) || (localObject2 == null)) {
            continue;
          }
          paramIntent = new JSONObject();
          try
          {
            paramIntent.put("feedsId", localObject2);
            paramIntent.put("retCode", paramInt1);
            paramIntent.put("feedsType", paramInt2);
            invokeCallJS((String)localObject1, paramIntent);
            return;
          }
          catch (Exception paramIntent)
          {
            return;
          }
        }
        if (paramInt1 == 119)
        {
          if ((paramIntent == null) || (BaseActivity.sTopActivity == null)) {
            continue;
          }
          localObject2 = paramIntent.getStringExtra("arg_callback");
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            continue;
          }
          paramInt1 = paramIntent.getIntExtra("result_code", -1);
          if (paramInt1 == 0)
          {
            if (Looper.myLooper() == null) {
              Looper.prepare();
            }
            new Handler(BaseActivity.sTopActivity.getMainLooper()).postDelayed(new BridgeModule.25(this), 200L);
          }
          localObject1 = "";
          if (paramIntent.hasExtra("result_msg")) {
            localObject1 = paramIntent.getStringExtra("result_msg");
          }
          paramIntent = new JSONObject();
          try
          {
            paramIntent.put("retCode", paramInt1);
            paramIntent.put("msg", localObject1);
            invokeCallJS((String)localObject2, paramIntent);
            return;
          }
          catch (JSONException paramIntent)
          {
            paramIntent.printStackTrace();
            return;
          }
        }
        if ((paramInt1 == 118) || (paramInt1 == 121))
        {
          if (paramIntent == null)
          {
            if (paramInt2 == 0)
            {
              try
              {
                paramIntent = new JSONObject();
                paramIntent.put("retCode", 1);
                paramIntent.put("msg", alpo.a(2131701559));
                if (QLog.isColorLevel()) {
                  QLog.d(TAG, 2, "selectAndUploadAvatar  result:" + ReadInJoyDeliverUGCActivity.a(paramIntent.toString()));
                }
                if (TextUtils.isEmpty(this.mUploadCallBack)) {
                  continue;
                }
                invokeCallJS(this.mUploadCallBack, paramIntent);
                return;
              }
              catch (Exception paramIntent) {}
              if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, QLog.getStackTraceString(paramIntent));
              }
            }
          }
          else
          {
            localObject1 = paramIntent.getStringExtra("callbackId");
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              if (paramInt2 == -1)
              {
                localObject2 = paramIntent.getBundleExtra("Bundle");
                if (localObject2 != null)
                {
                  paramInt1 = ((Bundle)localObject2).getInt("retCode");
                  paramIntent = ((Bundle)localObject2).getString("url");
                  localObject2 = ((Bundle)localObject2).getString("msg");
                  try
                  {
                    localObject3 = new JSONObject();
                    ((JSONObject)localObject3).put("retCode", paramInt1);
                    ((JSONObject)localObject3).put("url", paramIntent);
                    ((JSONObject)localObject3).put("msg", localObject2);
                    if (QLog.isColorLevel()) {
                      QLog.d(TAG, 2, "selectAndUploadAvatar  result:" + ReadInJoyDeliverUGCActivity.a(((JSONObject)localObject3).toString()));
                    }
                    invokeCallJS((String)localObject1, localObject3);
                    return;
                  }
                  catch (Exception paramIntent) {}
                  if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, QLog.getStackTraceString(paramIntent));
                  }
                }
              }
              else
              {
                try
                {
                  paramIntent = new JSONObject();
                  paramIntent.put("retCode", -1);
                  if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, " selectAndUploadAvatar result:" + paramIntent.toString());
                  }
                  invokeCallJS((String)localObject1, paramIntent);
                  return;
                }
                catch (Exception paramIntent) {}
                if (QLog.isColorLevel()) {
                  QLog.e(TAG, 2, QLog.getStackTraceString(paramIntent));
                }
              }
            }
          }
        }
        else if (paramInt1 == 117)
        {
          if (paramIntent != null)
          {
            localObject1 = paramIntent.getStringExtra("arg_callback");
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              if (paramInt2 == 1699)
              {
                if (this.dataManager != null) {
                  this.dataManager.a();
                }
                this.dataManager = new oik();
                UiApiPlugin.a(paramIntent, this.dataManager, (String)localObject1, new sol(this));
                return;
              }
              paramIntent = paramIntent.getStringExtra("arg_result_json");
            }
          }
        }
        else {
          try
          {
            if (!TextUtils.isEmpty(paramIntent))
            {
              paramIntent = new JSONObject(paramIntent);
              if (paramInt2 != -1) {
                break label1141;
              }
              paramIntent.put("retCode", 0);
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "ReadInJoyDeliverUGCActivity.replaceUrlInLog result:" + ReadInJoyDeliverUGCActivity.a(paramIntent.toString()));
              }
              invokeCallJS((String)localObject1, paramIntent);
              return;
              paramIntent = new JSONObject();
              break;
              label1141:
              paramIntent.put("retCode", -1);
            }
            if ((paramInt2 == -1) && (paramInt1 == 21))
            {
              if ((getViolaInstance() != null) && (getViolaInstance().getActivity() != null))
              {
                ForwardUtils.a((QQAppInterface)ors.a(), getViolaInstance().getActivity(), getViolaInstance().getActivity(), paramIntent, null);
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
                  continue;
                }
                localObject1 = new JSONObject();
                try
                {
                  ((JSONObject)localObject1).put("result", 1);
                  invokeCallJS(paramIntent, localObject1);
                  return;
                }
                catch (Exception paramIntent)
                {
                  QLog.e(TAG, 2, "do call share friend back error:" + paramIntent.getMessage());
                  return;
                }
              }
              catch (JSONException paramIntent)
              {
                for (;;)
                {
                  QLog.e(TAG, 1, "processClick callback error=" + paramIntent.getMessage());
                }
              }
            }
            else if (paramInt1 == 123)
            {
              if ((paramIntent != null) && ((paramInt2 == 1) || (paramInt2 == 2)))
              {
                localObject1 = paramIntent.getStringExtra("arg_callback");
                if (!TextUtils.isEmpty((CharSequence)localObject1))
                {
                  localObject2 = new JSONObject();
                  for (;;)
                  {
                    try
                    {
                      if (paramIntent.getBooleanExtra("key_publish_result", false))
                      {
                        paramInt1 = j;
                        ((JSONObject)localObject2).put("errCode", paramInt1);
                        paramIntent = (ColumnInfo)paramIntent.getParcelableExtra("key_column_info");
                        if (paramIntent != null) {
                          ((JSONObject)localObject2).put("topicId", paramIntent.columnID);
                        }
                        invokeJS((String)localObject1, (JSONObject)localObject2);
                        return;
                      }
                    }
                    catch (JSONException paramIntent)
                    {
                      QLog.d(TAG, 1, "ReadInJoyManageUgcColumn fail ! " + paramIntent.toString());
                      return;
                    }
                    paramInt1 = -1;
                  }
                }
              }
            }
            else if (paramInt1 == 101)
            {
              localObject1 = paramIntent.getStringExtra("arg_callback");
              if (!TextUtils.isEmpty((CharSequence)localObject1))
              {
                paramIntent = paramIntent.getExtras();
                long l1 = paramIntent.getLong("duration_time");
                long l2 = paramIntent.getLong("elapsed_time");
                boolean bool1 = paramIntent.getBoolean("profitable_flag", false);
                boolean bool2 = paramIntent.getBoolean("is_end", false);
                if (QLog.isColorLevel()) {
                  QLog.d(TAG, 2, "motiveResult: durationTime = " + l1 + "elaspedTime = " + l2 + "profitable =" + bool1);
                }
                paramIntent = new JSONObject();
                if (paramInt2 == -1) {}
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
                  invokeCallJS((String)localObject1, paramIntent);
                  return;
                  paramIntent.put("retCode", -1);
                }
              }
            }
            else if ((paramInt1 == 125) && (paramInt2 == -1))
            {
              paramIntent = new JSONObject();
              try
              {
                paramIntent.put("type", shareCallBackType);
                paramIntent.put("action", shareCallBackName);
                paramIntent.put("fromCallback", 1);
                if (TextUtils.isEmpty(shareCallBackId)) {
                  continue;
                }
                invokeCallJS(shareCallBackId, paramIntent);
                return;
              }
              catch (JSONException paramIntent)
              {
                QLog.e(TAG, 1, "processClick callback error=" + paramIntent.getMessage());
                return;
              }
              label1830:
              paramInt1 = -1;
            }
          }
          catch (Exception paramIntent) {}
        }
      }
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
      RIJRedPacketManager.a().a(getViolaInstance().getActivity(), 4, paramJSONObject.optString("redPacketId"), paramJSONObject.optString("rowkey"), new spd(this, paramString), false, null);
    }
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
    int i = paramJSONObject.optInt("topicId", 0);
    String str = paramJSONObject.optString("title");
    int j = paramJSONObject.optInt("fromType", 0);
    paramJSONObject = new ColumnInfo();
    paramJSONObject.columnID = i;
    paramJSONObject.title = str;
    qok.a(BaseActivity.sTopActivity, paramJSONObject, j, paramString, 124);
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
          invokeErrorCallJS(paramString2, alpo.a(2131701563));
        }
      }
      else
      {
        if ((paramString1.contains("weishi")) || (paramString1.contains("weishi://feed"))) {
          if (xoo.a(localBaseActivity)) {
            tam.a(localBaseActivity, "video_type_videopublic");
          }
        }
        while (!TextUtils.isEmpty(paramString2))
        {
          invokeCallJS(paramString2, null);
          return;
          QQToast.a(localBaseActivity, -1, alpo.a(2131701569), 0).b(localBaseActivity.getResources().getDimensionPixelSize(2131298914));
          tam.b(localBaseActivity, "video_type_videopublic");
          continue;
          if (!oee.a(localBaseActivity, paramString1))
          {
            Intent localIntent = new Intent();
            localIntent.setAction("android.intent.action.VIEW");
            String str = paramString3;
            if (TextUtils.isEmpty(paramString3)) {
              str = ors.f(0);
            }
            localIntent.putExtra("big_brother_source_key", str);
            localIntent.putExtra("big_brother_ref_source_key", ors.f(0));
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
    qok.a(BaseActivity.sTopActivity, paramString, 123);
  }
  
  @JSMethod
  public void openEditTopicView(JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.optInt("topicId", 0);
    String str1 = paramJSONObject.optString("iconUrl");
    String str2 = paramJSONObject.optString("title");
    paramJSONObject = paramJSONObject.optString("intro");
    qok.a(BaseActivity.sTopActivity, i, str1, str2, paramJSONObject, paramString, 123);
  }
  
  @JSMethod
  public void openTopicVideoComment(JSONObject paramJSONObject, String paramString)
  {
    Object localObject2 = paramJSONObject.optString("ref", "");
    ViolaDomManager localViolaDomManager = ViolaSDKManager.getInstance().getDomManager();
    Object localObject1 = getViolaInstance();
    if ((localObject1 != null) && ((((ViolaInstance)localObject1).getActivity() instanceof FragmentActivity)))
    {
      localObject2 = localViolaDomManager.getDomContext(getViolaInstance().getInstanceId()).getComponent((String)localObject2);
      localObject1 = (FragmentActivity)((ViolaInstance)localObject1).getActivity();
      if ((localObject2 == null) || (((VComponent)localObject2).getHostView() == null)) {}
    }
    for (;;)
    {
      try
      {
        int i = bindCommentCallback(paramString);
        if (((FragmentActivity)localObject1).getIntent().getBundleExtra("bundle") == null)
        {
          paramString = new Bundle();
          ((FragmentActivity)localObject1).getIntent().putExtra("bundle", paramString);
        }
        ((FragmentActivity)localObject1).getIntent().getBundleExtra("bundle").putInt("seq", i);
        localObject2 = ((VComponent)localObject2).getHostView();
        paramString = ((View)localObject2).findViewWithTag("VVideoView");
        if ((paramString instanceof VVideoView))
        {
          paramString = (VVideoView)paramString;
          doPostShowComment((FragmentActivity)localObject1, paramString, (View)localObject2, paramJSONObject);
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
    }
  }
  
  @JSMethod
  public void openUrl(String paramString, Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(paramString)) {
      jumpUrl(BaseActivity.sTopActivity, paramString, paramBundle);
    }
  }
  
  @JSMethod
  public void openVideo(JSONObject paramJSONObject)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null) {
      smk.a(localBaseActivity, paramJSONObject);
    }
  }
  
  @JSMethod
  public void pauseUploadingVideo(JSONObject paramJSONObject, String paramString)
  {
    String str = paramJSONObject.optString("vid");
    int i = paramJSONObject.optInt("pageType", 0);
    int j = paramJSONObject.optInt("topicId", 0);
    QLog.i(TAG, 1, "pauseUploadingVideo, content=" + paramJSONObject.toString() + ",callbackId=" + paramString);
    paramJSONObject = ors.a();
    if (paramJSONObject != null) {
      qun.a(paramJSONObject).a(j, new sot(this, str, paramJSONObject, i, j, paramString));
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
  
  @JSMethod(uiThread=true)
  public void popFromBottomStateChange(String paramString)
  {
    if ((getViolaInstance() != null) && ((getViolaInstance().getFragment() instanceof ViolaFragment))) {
      ((ViolaFragment)getViolaInstance().getFragment()).a(new spf(this, paramString));
    }
  }
  
  public void requestBubbleTipsWording(JSONObject paramJSONObject, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramJSONObject != null)) {
      RIJRedPacketManager.a().a(paramJSONObject.optString("rowkey"), paramJSONObject.optString("redPacketId"), 4, new spc(this, paramString));
    }
  }
  
  public void requestRedPacketContentShareToast(String paramString)
  {
    QLog.i(TAG, 1, "request yyy_0xe36");
    cmd0xe36.ReqBody localReqBody = new cmd0xe36.ReqBody();
    localReqBody.nothing.set(1);
    mzy.a(ors.a(), new spb(this, paramString), localReqBody.toByteArray(), "OidbSvc.0xe36", 3638, 1, new Bundle(), 5000L);
  }
  
  @JSMethod
  public void resumeUploadingVideo(JSONObject paramJSONObject, String paramString)
  {
    String str = paramJSONObject.optString("vid");
    int i = paramJSONObject.optInt("pageType", 0);
    int j = paramJSONObject.optInt("topicId", 0);
    QLog.i(TAG, 1, "resumeUploadingVideo, vid=" + str + "pageType=" + i);
    paramJSONObject = ors.a();
    if (paramJSONObject != null) {
      qun.a(paramJSONObject).a(j, new sov(this, str, paramJSONObject, i, j, paramString));
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
      CheckPermission.requestSDCardPermission((AppActivity)localActivity, new son(this, paramJSONObject, paramString));
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
      ((StringBuilder)localObject).append("&version=8.3.3.4515");
      ((StringBuilder)localObject).append("&system=" + Build.VERSION.RELEASE);
      ((StringBuilder)localObject).append("&device=" + Build.DEVICE);
      ((StringBuilder)localObject).append("&uin=" + ors.a());
      paramJSONObject = apih.a("VIP_xingying", ((StringBuilder)localObject).toString());
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "saveImage imageUrl=" + paramJSONObject);
      }
      localObject = System.currentTimeMillis() + ".jpg";
      ThreadManager.executeOnNetWorkThread(new BridgeModule.29(this, paramJSONObject, new File(aljq.bd, (String)localObject), paramString));
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
  
  protected void sendRequest(JSONObject paramJSONObject, String paramString)
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
          localQQAppInterface = (QQAppInterface)ors.a();
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
        localObject1 = new NewIntent(localQQAppInterface.getApplication(), mzx.class);
        ((NewIntent)localObject1).putExtra("cmd", "MQUpdateSvc_" + paramJSONObject + ".web." + str);
        paramJSONObject = new WebSsoBody.WebSsoRequestBody();
        paramJSONObject.type.set(0);
        paramJSONObject.data.set((String)localObject2);
        ((NewIntent)localObject1).putExtra("data", paramJSONObject.toByteArray());
        ((NewIntent)localObject1).setObserver(new sob(this, paramString));
        if (localQQAppInterface == null) {
          break;
        }
        localQQAppInterface.startServlet((NewIntent)localObject1);
        return;
      }
      i -= 1;
    }
  }
  
  @JSMethod
  public void setNavBtn(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = getViolaInstance().getFragment();
    if (localObject == null) {}
    label116:
    for (;;)
    {
      return;
      if ((localObject instanceof ViolaFragment)) {}
      for (localObject = ((ViolaFragment)localObject).a();; localObject = null)
      {
        if (localObject == null) {
          break label116;
        }
        String str = paramJSONObject.optString("position");
        paramJSONObject = paramJSONObject.optString("text");
        if (TextUtils.isEmpty(str)) {
          break;
        }
        if (str.equals("right"))
        {
          ((snq)localObject).a(paramJSONObject, new soo(this, paramString));
          return;
        }
        if (!str.equals("left")) {
          break;
        }
        ((snq)localObject).b(paramJSONObject, new spa(this, paramString));
        return;
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
  
  protected void shareImageToAIO(String paramString)
  {
    Object localObject1 = getViolaInstance().getActivity();
    if ((localObject1 == null) || (((Activity)localObject1).isFinishing())) {
      return;
    }
    if (!AppNetConnInfo.isNetSupport())
    {
      QQToast.a(ors.a().getApplication(), 1, alpo.a(2131701568), 0).a();
      return;
    }
    Object localObject2 = new File(bame.d(paramString));
    if (((File)localObject2).exists())
    {
      shareImageToAIOInner((File)localObject2);
      return;
    }
    localObject1 = new Bundle();
    localObject2 = new bdvv(paramString, (File)localObject2);
    ((bdvv)localObject2).d = 60L;
    ((bdvx)ors.a().getManager(47)).a(1).a((bdvv)localObject2, new sop(this, paramString), (Bundle)localObject1);
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
    arum.a(localActivity, (Intent)localObject, 18);
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
    paramString.d = paramJSONObject.optInt("duration");
    paramString.g = paramJSONObject.optString("rowkey");
    paramString.jdField_b_of_type_JavaLangString = paramJSONObject.optString("first_page_url");
    paramString.jdField_b_of_type_Int = paramJSONObject.optInt("width");
    paramString.jdField_c_of_type_Int = paramJSONObject.optInt("height");
    paramString.k = paramJSONObject.optString("thridName");
    paramString.m = paramJSONObject.optString("thirdAction");
    paramString.n = paramJSONObject.optString("thirdIcon");
    paramString.j = paramJSONObject.optString("third_uin");
    paramString.o = paramJSONObject.optString("third_uin_name");
    rhf.a(paramString, getViolaInstance().getActivity(), 1);
  }
  
  /* Error */
  @JSMethod
  public void showMotiveAd(String paramString, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: getstatic 453	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   6: astore 8
    //   8: ldc_w 320
    //   11: astore 6
    //   13: aload_2
    //   14: ldc_w 3717
    //   17: invokevirtual 356	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   20: istore_3
    //   21: aload_2
    //   22: ldc_w 2221
    //   25: invokevirtual 310	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   28: astore 7
    //   30: aload 7
    //   32: astore 6
    //   34: aload_2
    //   35: ldc_w 3719
    //   38: iconst_0
    //   39: invokevirtual 316	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   42: istore 5
    //   44: iload 5
    //   46: istore 4
    //   48: aload 7
    //   50: astore 6
    //   52: invokestatic 2506	oeg:a	()Loeg;
    //   55: aload 8
    //   57: iload_3
    //   58: aload 6
    //   60: iload 4
    //   62: aload_1
    //   63: invokevirtual 3722	oeg:a	(Landroid/app/Activity;ILjava/lang/String;ILjava/lang/String;)V
    //   66: return
    //   67: astore_2
    //   68: iconst_0
    //   69: istore_3
    //   70: getstatic 195	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:TAG	Ljava/lang/String;
    //   73: iconst_1
    //   74: ldc_w 3724
    //   77: aload_2
    //   78: invokestatic 478	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   81: goto -29 -> 52
    //   84: astore_2
    //   85: goto -15 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	BridgeModule
    //   0	88	1	paramString	String
    //   0	88	2	paramJSONObject	JSONObject
    //   20	50	3	i	int
    //   1	60	4	j	int
    //   42	3	5	k	int
    //   11	48	6	localObject	Object
    //   28	21	7	str	String
    //   6	50	8	localBaseActivity	BaseActivity
    // Exception table:
    //   from	to	target	type
    //   13	21	67	java/lang/Exception
    //   21	30	84	java/lang/Exception
    //   34	44	84	java/lang/Exception
  }
  
  public void showShareReadInJoyMenu(JSONObject paramJSONObject, String paramString)
  {
    AppInterface localAppInterface = (AppInterface)ors.a();
    Object localObject1 = getViolaInstance().getFragment();
    if (localObject1 != null) {}
    for (localObject1 = ((Fragment)localObject1).getActivity(); localObject1 == null; localObject1 = getViolaInstance().getActivity()) {
      return;
    }
    Object localObject2 = paramJSONObject.optJSONArray("upline");
    Object localObject3 = paramJSONObject.optJSONArray("belowline");
    String str2 = paramJSONObject.optString("menu_title", "biu出去让更多好友看到");
    if (localObject2 == null)
    {
      localObject2 = this.mShareUtils.a();
      if (localObject3 != null) {
        break label175;
      }
    }
    ArrayList localArrayList1;
    label175:
    for (localObject3 = this.mShareUtils.b();; localObject3 = this.mShareUtils.a((JSONArray)localObject3, paramJSONObject))
    {
      localArrayList1 = new ArrayList();
      localObject4 = ((List)localObject2).iterator();
      while (((Iterator)localObject4).hasNext()) {
        localArrayList1.add(Integer.valueOf(((sps)((Iterator)localObject4).next()).jdField_a_of_type_Int));
      }
      localObject2 = this.mShareUtils.a((JSONArray)localObject2, paramJSONObject);
      break;
    }
    ArrayList localArrayList2 = new ArrayList();
    Object localObject4 = ((List)localObject3).iterator();
    while (((Iterator)localObject4).hasNext()) {
      localArrayList2.add(Integer.valueOf(((sps)((Iterator)localObject4).next()).jdField_a_of_type_Int));
    }
    String str3;
    String str1;
    if (paramJSONObject.optInt("from") == 1)
    {
      str3 = Aladdin.getConfig(273).getString("share_text_channel_list", "");
      str1 = Aladdin.getConfig(273).getString("share_text", "");
      localObject4 = str1;
    }
    try
    {
      if (!TextUtils.isEmpty(str1)) {
        localObject4 = orq.a(String.format(str1, new Object[] { paramJSONObject.optString("share_url") }), "\\n", '\n');
      }
      paramJSONObject.put("shouldSharePlainTextChannel", str3);
      paramJSONObject.put("shareText", localObject4);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool;
        QLog.e(TAG, 2, QLog.getStackTraceString(localException));
      }
    }
    this.mShareHelper = new syq((Activity)localObject1, localAppInterface, new spk(this), new spl(this, true, (List)localObject2, (List)localObject3, paramJSONObject, new WeakReference(localObject1), paramString));
    localObject1 = this.mShareHelper;
    bool = paramJSONObject.optBoolean("hasRedPacket", false);
    ((syq)localObject1).a(new List[] { localArrayList1, localArrayList2 }, bool);
    this.mShareHelper.a.setActionSheetTitle(str2);
    this.mShareHelper.a.setOnDismissListener(new soa(this, paramString));
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
      owy.a().a(str, Integer.valueOf(paramJSONObject).intValue());
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
      paramJSONObject = URLDrawable.getDrawable(str, sni.a(bool, (int)f1, (int)f2));
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
        localArrayList.add(new rjx(localJSONObject.optString("videoVid"), localJSONObject.optString("articleID"), localJSONObject.optInt("busitype"), localJSONObject.optInt("duration")));
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
        this.mVideoPreDownloadMgr.a = new rjz(rjz.d, rjz.f);
        this.mVideoPreDownloadMgr.a(new sny(this, localArrayList));
      }
      this.mVideoPreDownloadMgr.a(0, true);
    }
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
          paramJSONObject = oxb.a();
          if (i != 2) {
            break label120;
          }
          paramJSONObject.b(l, bool);
          ThreadManager.post(new BridgeModule.12(this, l, i), 8, null, true);
        }
        invokeCallJS(paramString, null);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(TAG, 2, "openAccountPageMore->error:" + paramJSONObject);
        return;
      }
      invokeErrorCallJS(paramString, "params error");
      return;
      label120:
      bool = false;
    }
  }
  
  @JSMethod(uiThread=true)
  public void updateIndepentTabState(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("state")))
    {
      int i = paramJSONObject.optInt("state");
      oxb.a().a(i, null);
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
      if (!owy.a().a(i, j)) {
        owy.a().d(i, j);
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
    QQAppInterface localQQAppInterface = (QQAppInterface)ors.a();
    if (localQQAppInterface == null) {}
    while (this.netInfoHandler != null) {
      return;
    }
    this.netInfoHandler = new sog(this, paramString);
    AppNetConnInfo.registerConnectionChangeReceiver(localQQAppInterface.getApplication(), this.netInfoHandler);
  }
  
  @JSMethod
  public void videoPlayFeedback(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "do videoPlayFeedback start data: " + paramJSONObject.toString());
    }
    roi.a(paramJSONObject);
    paramJSONObject = getViolaInstance();
    JSONObject localJSONObject;
    if (paramJSONObject != null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("success", 1);
      ViolaBridgeManager.getInstance().callbackJavascript(paramJSONObject.getInstanceId(), MODULE_NAME, "callback", paramString, localJSONObject, true);
      return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule
 * JD-Core Version:    0.7.0.1
 */