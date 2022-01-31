package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import ajsd;
import ajya;
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
import anqz;
import aqbe;
import arik;
import ayoi;
import badv;
import baxn;
import bbbx;
import bbco;
import bbdh;
import bbdi;
import bbeg;
import bbex;
import bbfr;
import bbgu;
import bbjq;
import bbvj;
import bbwq;
import bbwu;
import bbww;
import bbwz;
import bcql;
import bdhk;
import bdld;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
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
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.JumpInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyPrivacyListFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberAQFragment;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLikeAnimate;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
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
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.open.downloadnew.DownloadInfo;
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
import mxe;
import mzb;
import naj;
import nol;
import oar;
import odo;
import oeg;
import onh;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import osg;
import osj;
import osl;
import ozb;
import pqj;
import qcd;
import qcg;
import qda;
import qdb;
import qdc;
import qrt;
import qui;
import quk;
import qyw;
import ram;
import rvx;
import rwv;
import rxb;
import rxd;
import rxe;
import rxi;
import rxj;
import rxk;
import rxl;
import rxm;
import rxn;
import rxo;
import rxp;
import rxq;
import rxr;
import rxs;
import rxt;
import rxu;
import rxv;
import rxw;
import rxx;
import rxy;
import rxz;
import rya;
import ryb;
import ryc;
import rye;
import ryf;
import ryg;
import ryj;
import rym;
import ryo;
import rzh;
import sfk;
import sgg;
import sgv;
import sir;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import vzw;
import wxr;
import wxt;
import yxo;
import yxp;
import yxt;
import yxu;
import yxv;

public class BridgeModule
  extends BaseModule
  implements Destroyable, IActivityState
{
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
  public static final byte REQ_CODE_UGC_CAMERA_CAPTURE = 116;
  public static final byte REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM = 115;
  public static String TAG = "BridgeModule";
  public static GdtAppReceiver mGdtAppReceiver;
  private boolean hasShareItemClick;
  private rxe mActionSheetHelper;
  private ryo mBridgeApiHelper;
  private String mCallBack;
  private wxr mClient;
  private rzh mCommentManager;
  private bdld mDownloadListener;
  private ryg mEventHelper;
  private Map<String, Object> mObjectMap = new ArrayMap();
  protected bbjq mShareActionSheet;
  private sgv mShareHelper;
  private ryj mShareUtils = new ryj();
  private int mState = -100;
  private String mUploadCallBack;
  private VideoPreDownloadMgr mVideoPreDownloadMgr = new VideoPreDownloadMgr();
  private int maxSize = 204800;
  private int minDuration = 5;
  private INetInfoHandler netInfoHandler;
  private long preTime;
  
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
      mzb.a(localArrayList, onh.a(), new rxs(this, paramString), true, false);
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
      this.mClient = wxr.a();
      this.mClient.a();
    }
    return this.mClient.a(createCommentApiCallback(paramString));
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
    rvx.a(localBaseActivity, paramJSONObject, new rxp(this, paramString));
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
    long l1 = paramJSONObject.optLong("articleId", -1L);
    long l2 = paramJSONObject.optLong("feedsID", -1L);
    int i = paramJSONObject.optInt("feedsType", -1);
    paramJSONObject = new ArticleInfo();
    paramJSONObject.innerUniqueID = str1;
    paramJSONObject.mTitle = str2;
    paramJSONObject.mSummary = null;
    paramJSONObject.mFirstPagePicUrl = str3;
    paramJSONObject.mArticleID = l1;
    paramJSONObject.mFeedId = l2;
    paramJSONObject.mFeedType = i;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 1, "openTopicVideoComment  uniqueKey = " + str1 + "feedsId = " + l2 + " feedsType=" + i + "title = " + str2 + "picUrl =" + str3 + "articleId =" + l1);
    }
    return paramJSONObject;
  }
  
  private wxt createCommentApiCallback(String paramString)
  {
    return new rxu(this, paramString);
  }
  
  private void detailLog(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = (QQAppInterface)onh.a();
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localObject == null) || (localBaseActivity == null)) {}
    StringBuilder localStringBuilder1;
    label243:
    label255:
    do
    {
      return;
      localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = localStringBuilder1.append(paramJSONObject.optString("id")).append("|").append(paramJSONObject.optString("subid")).append("|").append(paramJSONObject.optString("content")).append("|").append("ANDROID").append("|").append("8.3.0.4480").append("|").append(bbdh.e()).append("|").append(((QQAppInterface)localObject).getCurrentAccountUin()).append("|").append(Build.MODEL).append("|");
      if (TextUtils.isEmpty(bbdh.a(localBaseActivity).jdField_c_of_type_JavaLangString))
      {
        localObject = "未知";
        localStringBuilder2 = localStringBuilder2.append((String)localObject).append("|");
        if (!TextUtils.isEmpty(bbdh.a(localBaseActivity).jdField_a_of_type_JavaLangString)) {
          break label243;
        }
      }
      for (localObject = "未知";; localObject = bbdh.a(localBaseActivity).jdField_a_of_type_JavaLangString)
      {
        localStringBuilder2.append((String)localObject);
        if (!paramJSONObject.optBoolean("isall", false)) {
          break label255;
        }
        QLog.w("ViolaLog", 1, localStringBuilder1.toString());
        invokeCallJS(paramString, null);
        return;
        localObject = bbdh.a(localBaseActivity).jdField_c_of_type_JavaLangString;
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
      if ((getViolaInstance() == null) || (!((ViolaFragment)getViolaInstance().getFragment()).a()) || (!((ViolaFragment)getViolaInstance().getFragment()).a().c())) {
        break label214;
      }
    }
    label214:
    for (int i = ((ViolaFragment)getViolaInstance().getFragment()).a().a();; i = 0)
    {
      this.mCommentManager = new rzh(paramFragmentActivity, (FragmentManager)localObject, i);
      if ((getViolaInstance() != null) && ((getViolaInstance().getFragment() instanceof ViolaFragment)))
      {
        paramFragmentActivity = (ViolaFragment)getViolaInstance().getFragment();
        if ((paramFragmentActivity.a()) && (paramFragmentActivity.a() != null)) {
          paramFragmentActivity.a().e();
        }
      }
      this.mCommentManager.a(new rxv(this));
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
        this.mDownloadListener = new rxl(this, str, paramString);
      }
      bdhk.a().a(this.mDownloadListener);
      localDownloadInfo.a();
      bdhk.a().b(localDownloadInfo);
    }
  }
  
  private void downloadApkAction(JSONObject paramJSONObject)
  {
    int i;
    if ((paramJSONObject != null) && (paramJSONObject.optString("apkUrl") != null) && (paramJSONObject.optInt("action", -1) != -1))
    {
      i = paramJSONObject.optInt("action", -1);
      if (i != 1) {
        break label46;
      }
      downloadApkPause(paramJSONObject);
    }
    label46:
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
      bdhk.a().b(paramJSONObject, true);
    }
  }
  
  private void downloadApkPause(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("apkUrl"))))
    {
      paramJSONObject = paramJSONObject.optString("apkUrl");
      bdhk.a().a(paramJSONObject);
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
      bdhk.a().b(localDownloadInfo);
    }
  }
  
  private void downloadApp(String paramString)
  {
    Context localContext = getViolaInstance().getContext();
    if ((localContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      Object localObject = sir.b(paramString);
      if (localObject != null)
      {
        ((DownloadInfo)localObject).a();
        bdhk.a().b((DownloadInfo)localObject);
        return;
      }
      try
      {
        paramString = new JSONObject(paramString);
        localObject = new Intent(localContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("big_brother_source_key", onh.f(0));
        ((Intent)localObject).putExtra("url", paramString.optString("url"));
        localContext.startActivity((Intent)localObject);
        return;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e(TAG, 2, "downloadApp error" + paramString.getMessage());
  }
  
  private void ensureEventHelper()
  {
    if (this.mEventHelper == null) {
      this.mEventHelper = new ryg(this);
    }
  }
  
  private void feedsRefreshMessage(JSONObject paramJSONObject)
  {
    pqj.a().a(paramJSONObject);
  }
  
  private static HashMap<String, Object> generateMapFromInvokeJsUrl(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      HashMap localHashMap = new HashMap();
      if (TextUtils.isEmpty(paramJSONObject.optString("bgclr"))) {
        localHashMap.put(rxb.d, paramJSONObject.optString("bgclr"));
      }
      if (TextUtils.isEmpty(paramJSONObject.optString("txtclr"))) {
        localHashMap.put(rxb.jdField_c_of_type_JavaLangString, paramJSONObject.optString("txtclr"));
      }
      if (!TextUtils.isEmpty(paramJSONObject.optString("titleclr"))) {
        localHashMap.put(rxb.e, paramJSONObject.optString("titleclr"));
      }
      if (!TextUtils.isEmpty(paramJSONObject.optString("alpha"))) {
        localHashMap.put(rxb.f, paramJSONObject.optString("alpha"));
      }
      if (!TextUtils.isEmpty(paramJSONObject.optString("statusBarColor"))) {
        localHashMap.put(rxb.g, paramJSONObject.optString("statusBarColor"));
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
      localJSONObject.put("result", bbwq.a());
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
    localObject = bbdh.a((Context)localObject);
    String str = bbdh.c();
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
    String str1 = bbdh.b();
    String str2 = bbdh.f();
    String str3 = bbdh.a();
    try
    {
      localJSONObject.put("imsi", str1);
      localJSONObject.put("androidID", str2);
      localJSONObject.put("identifier", str3);
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
      localObject = bdhk.a().b(paramJSONObject);
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
    ThreadManager.post(new BridgeModule.12(this, paramString), 8, null, true);
  }
  
  private void getPerformance(String paramString)
  {
    ViolaInstance localViolaInstance = getViolaInstance();
    if (localViolaInstance == null) {
      return;
    }
    invokeCallJS(paramString, localViolaInstance.getMainPerformance());
  }
  
  private JSONObject getUserInfo()
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject3 = (QQAppInterface)onh.a();
    String str;
    if (localObject3 != null)
    {
      localObject1 = (TicketManager)((QQAppInterface)localObject3).getManager(2);
      str = ((QQAppInterface)localObject3).getAccount();
      if (localObject1 == null) {
        break label130;
      }
    }
    label130:
    Object localObject2;
    for (Object localObject1 = ((TicketManager)localObject1).getSkey(((QQAppInterface)localObject3).getCurrentAccountUin());; localObject2 = null)
    {
      localObject3 = sgg.a((QQAppInterface)localObject3, str);
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
    onh.a(paramContext, paramString, paramBundle);
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
    rvx.a(BaseActivity.sTopActivity, "", paramString, localBundle);
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
        paramJSONObject.putString("big_brother_ref_source_key", onh.f(0));
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
        break label125;
      }
      paramJSONObject = paramJSONObject.toString();
      if (localObject1 == null) {
        break label131;
      }
      localObject1 = ((JSONObject)localObject1).toString();
      label86:
      if (localObject2 == null) {
        break label137;
      }
      localObject2 = ((JSONObject)localObject2).toString();
      label95:
      if (localObject3 == null) {
        break label143;
      }
    }
    label131:
    label137:
    label143:
    for (localObject3 = ((JSONObject)localObject3).toString();; localObject3 = "")
    {
      nol.a(null, null, str, str, 0, 0, paramJSONObject, (String)localObject1, (String)localObject2, (String)localObject3, false);
      return;
      label125:
      paramJSONObject = "";
      break;
      localObject1 = "";
      break label86;
      localObject2 = "";
      break label95;
    }
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
        ((StringBuilder)localObject).append("&version=8.3.0.4480");
        ((StringBuilder)localObject).append("&system=" + Build.VERSION.RELEASE);
        ((StringBuilder)localObject).append("&device=" + Build.DEVICE);
        ((StringBuilder)localObject).append("&uin=" + onh.a());
        paramString = anqz.a("VIP_xingying", ((StringBuilder)localObject).toString());
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "saveImageToLocal imageUrl=" + paramString);
        }
        localObject = System.currentTimeMillis() + ".jpg";
        ThreadManager.executeOnNetWorkThread(new BridgeModule.18(this, paramString, new File(bbvj.a(ajsd.bc), (String)localObject)));
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
              break label263;
            }
            paramJSONObject.append(",");
            break label263;
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
      label263:
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
    for (int i = baxn.a(localBaseActivity, j / 2);; i = 640)
    {
      int m;
      if (paramJSONObject.has("height")) {
        m = paramJSONObject.optInt("height");
      }
      for (int k = baxn.a(localBaseActivity, m / 2);; k = 640)
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
    Object localObject = (QQAppInterface)onh.a();
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
      String str = bbvj.a(ajsd.aW + "readinjoy_avatar_upload/");
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
      bbbx.a(localActivity, false, true);
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
    invokeErrorCallJS(paramString, ajya.a(2131701202));
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
    ((ViolaFragment)localObject).a(new rxt(this, paramString));
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
      bcql.a(onh.a().getApplication(), 1, ajya.a(2131701203), 0).a();
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
    for (Object localObject3 = ((Fragment)localObject1).getActivity(); localObject3 == null; localObject3 = getViolaInstance().getActivity()) {
      return;
    }
    if (paramJSONObject.has("enableAnonymous")) {}
    for (boolean bool1 = paramJSONObject.optBoolean("enableAnonymous");; bool1 = false)
    {
      if (paramJSONObject.has("canBiu")) {}
      for (boolean bool2 = paramJSONObject.optBoolean("canBiu");; bool2 = true)
      {
        localObject1 = "";
        if (paramJSONObject.has("placeholder")) {
          localObject1 = paramJSONObject.optString("placeholder");
        }
        try
        {
          localObject2 = new String(bbco.decode((String)localObject1, 0));
          localObject1 = localObject2;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            Object localObject2;
            localException1.printStackTrace();
          }
        }
        localObject2 = "";
        if (paramJSONObject.has("defaultTxt")) {
          localObject2 = paramJSONObject.optString("defaultTxt");
        }
        try
        {
          localObject4 = new String(bbco.decode((String)localObject2, 0));
          localObject2 = localObject4;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject4;
            int m;
            localException2.printStackTrace();
            continue;
            int k = 0;
            continue;
            int j = 0;
            continue;
            int i = -1;
          }
        }
        if (paramJSONObject.has("maxLength"))
        {
          i = paramJSONObject.optInt("maxLength", -1);
          if (paramJSONObject.has("commentType"))
          {
            j = paramJSONObject.optInt("commentType", 0);
            if (paramJSONObject.has("sourceType"))
            {
              k = paramJSONObject.optInt("sourceType", 0);
              localObject4 = paramJSONObject.optJSONArray("defaultCommentAtLevel");
              m = paramJSONObject.optInt("openAt", 0);
              paramJSONObject = new Intent();
              paramJSONObject.putExtra("arg_comment_enable_anonymous", bool1);
              paramJSONObject.putExtra("arg_comment_placeholder", (String)localObject1);
              paramJSONObject.putExtra("arg_comment_default_txt", (String)localObject2);
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
              PublicTransFragmentActivity.b((Activity)localObject3, paramJSONObject, ReadInJoyCommentComponentFragment.class, 117);
              return;
            }
          }
        }
      }
    }
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
    bbgu localbbgu = new bbgu(localBaseActivity, 2131755791);
    localbbgu.setContentView(2131558883);
    localbbgu.getMessageTextView().setMovementMethod(new ScrollingMovementMethod());
    localbbgu.getMessageTextView().setMaxHeight(baxn.a(localBaseActivity, 200.0F));
    localbbgu.setTitle(paramJSONObject.optString("title"));
    localbbgu.setMessage(paramJSONObject.optString("text"));
    localbbgu.setCanceledOnTouchOutside(false);
    if (paramJSONObject.optBoolean("needOkBtn", true)) {
      localbbgu.setPositiveButton(paramJSONObject.optString("okBtnText", ajya.a(2131701193)), new rxm(this, paramJSONObject, paramString));
    }
    if (paramJSONObject.optBoolean("needCancelBtn", true)) {
      localbbgu.setNegativeButton(paramJSONObject.optString("cancelBtnText", ajya.a(2131701189)), new rxn(this, paramJSONObject, paramString));
    }
    localbbgu.show();
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
        Object localObject7 = paramJSONObject.optString("title");
        Object localObject3 = paramJSONObject.optString("sourceName");
        String str2 = paramJSONObject.optString("sourceUrl");
        int n;
        String str1;
        long l1;
        long l3;
        long l4;
        long l10;
        long l11;
        Object localObject5;
        if (TextUtils.isEmpty(str2))
        {
          str2 = "";
          n = paramJSONObject.optInt("hiddenBiuComponent");
          str1 = "";
          if (n == 1) {
            str1 = new String(bbco.decode(paramJSONObject.optString("newComment"), 2));
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
          localObject1 = new String(bbco.decode((String)localObject7, 0));
        }
        catch (Exception localException4)
        {
          Object localObject4;
          long l2;
          long l7;
          long l6;
          long l5;
          int j;
          String str3;
          int k;
          String str4;
          int i1;
          Object localObject8;
          Object localObject9;
          Object localObject10;
          String str5;
          Object localObject6;
          SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo;
          String str6;
          Object localObject2 = localObject3;
          Object localObject1 = "";
          long l9 = l11;
          long l8 = l10;
          localObject3 = localObject7;
          continue;
        }
        try
        {
          localObject2 = new String(bbco.decode((String)localObject3, 0));
        }
        catch (Exception localException1)
        {
          localObject7 = localObject1;
          localObject1 = "";
          localObject2 = localObject3;
          l9 = l11;
          l8 = l10;
          localObject3 = localObject7;
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
          localObject7 = "";
          localObject3 = localObject1;
          localObject1 = localObject7;
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
          localObject7 = localObject3;
          localObject4 = localObject1;
          localObject1 = localObject5;
          l5 = l2;
          l4 = l3;
          localObject3 = localObject2;
          l2 = l10;
          l3 = l1;
          localObject2 = localObject7;
          l1 = l5;
          l5 = paramJSONObject.optLong("originFeedsType", 1L);
          i = paramJSONObject.optInt("type");
          m = paramJSONObject.optInt("adtag");
          str3 = paramJSONObject.optString("picurl");
          k = paramJSONObject.optInt("duration");
          str4 = new String(bbco.decode(paramJSONObject.optString("accountDesc"), 0));
          i1 = paramJSONObject.optInt("feedsType", 1);
          localObject7 = new ArticleInfo();
          ((ArticleInfo)localObject7).mArticleID = l3;
          ((ArticleInfo)localObject7).mTitle = ((String)localObject4);
          ((ArticleInfo)localObject7).mSubscribeName = ((String)localObject3);
          ((ArticleInfo)localObject7).mFirstPagePicUrl = str3;
          ((ArticleInfo)localObject7).mVideoDuration = k;
          ((ArticleInfo)localObject7).mFeedId = l1;
          ((ArticleInfo)localObject7).mSummary = str4;
          ((ArticleInfo)localObject7).businessId = l8;
          ((ArticleInfo)localObject7).mFeedType = i1;
          ((ArticleInfo)localObject7).innerUniqueID = ((String)localObject1);
        }
        catch (Exception localException3)
        {
          localObject7 = localObject1;
          localObject1 = localObject3;
          l4 = l7;
          l3 = l6;
          l1 = l5;
          localObject3 = localObject7;
          continue;
          paramJSONObject = str1;
          continue;
          continue;
        }
        try
        {
          localObject5 = paramJSONObject.getJSONArray("biuLevelList");
          ((ArticleInfo)localObject7).mSocialFeedInfo = new SocializeFeedsInfo();
          ((ArticleInfo)localObject7).mSocialFeedInfo.jdField_a_of_type_Qcg = new qcg();
          ((ArticleInfo)localObject7).mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_a_of_type_JavaLangLong = Long.valueOf(l4);
          ((ArticleInfo)localObject7).mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_b_of_type_JavaLangLong = Long.valueOf(l5);
          ((ArticleInfo)localObject7).mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList = new ArrayList();
          if (localObject5 != null)
          {
            k = 0;
            if (k < ((JSONArray)localObject5).length())
            {
              localObject8 = new SocializeFeedsInfo.BiuCommentInfo();
              localObject9 = ((JSONArray)localObject5).getJSONObject(k);
              ((SocializeFeedsInfo.BiuCommentInfo)localObject8).jdField_a_of_type_JavaLangLong = Long.valueOf(((JSONObject)localObject9).optLong("uin"));
              ((SocializeFeedsInfo.BiuCommentInfo)localObject8).jdField_b_of_type_JavaLangString = new String(bbco.decode(((JSONObject)localObject9).optString("comment"), 0));
              ((SocializeFeedsInfo.BiuCommentInfo)localObject8).jdField_a_of_type_JavaLangString = ((SocializeFeedsInfo.BiuCommentInfo)localObject8).jdField_b_of_type_JavaLangString;
              ((SocializeFeedsInfo.BiuCommentInfo)localObject8).jdField_a_of_type_Int = ((JSONObject)localObject9).optInt("biuTime");
              ((SocializeFeedsInfo.BiuCommentInfo)localObject8).jdField_b_of_type_Int = ((JSONObject)localObject9).optInt("feeds_type", 1);
              ((SocializeFeedsInfo.BiuCommentInfo)localObject8).jdField_c_of_type_Int = ((JSONObject)localObject9).optInt("op_type");
              localObject10 = ((JSONObject)localObject9).optString("jumpName");
              str5 = ((JSONObject)localObject9).optString("jumpUrl");
              if ((!TextUtils.isEmpty((CharSequence)localObject10)) && (!TextUtils.isEmpty(str5))) {
                ((SocializeFeedsInfo.BiuCommentInfo)localObject8).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo = new SocializeFeedsInfo.JumpInfo(0L, new String(bbco.decode((String)localObject10, 0)), str5);
              }
              if (n != 1) {}
            }
          }
        }
        catch (JSONException localJSONException)
        {
          try
          {
            localObject9 = ((JSONObject)localObject9).optString("feedsId");
            if (!TextUtils.isEmpty((CharSequence)localObject9)) {
              ((SocializeFeedsInfo.BiuCommentInfo)localObject8).jdField_b_of_type_JavaLangLong = Long.valueOf(new BigInteger((String)localObject9).longValue());
            }
            ((ArticleInfo)localObject7).mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList.add(localObject8);
            k += 1;
            continue;
            ((Exception)localObject4).printStackTrace();
            j = 0;
            localObject7 = localObject2;
            l2 = l9;
            localObject2 = localObject1;
            localObject4 = localObject3;
            localObject3 = localObject7;
            localObject1 = localObject5;
            continue;
            localJSONException = localJSONException;
            localJSONException.printStackTrace();
            localObject6 = null;
          }
          catch (Exception localException5)
          {
            localException5.printStackTrace();
            continue;
          }
          localObject6 = paramJSONObject.optJSONObject("ugcInfo");
          paramJSONObject = "";
          if (localObject6 == null) {
            continue;
          }
        }
        if (ram.c(i1, l5))
        {
          ((ArticleInfo)localObject7).mSocialFeedInfo.jdField_a_of_type_Qda = new qda();
          i2 = ((JSONObject)localObject6).optInt("ugcType", 0);
          paramJSONObject = ((JSONObject)localObject6).optString("ugcComment");
          localObject8 = ((JSONObject)localObject6).optJSONArray("ugcAtLevelList");
          if (localObject8 != null)
          {
            ((ArticleInfo)localObject7).mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Qcg = new qcg();
            ((ArticleInfo)localObject7).mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList = new ArrayList();
            k = 0;
            if (k < ((JSONArray)localObject8).length())
            {
              localBiuCommentInfo = new SocializeFeedsInfo.BiuCommentInfo();
              localObject10 = ((JSONArray)localObject8).getJSONObject(k);
              localBiuCommentInfo.jdField_a_of_type_JavaLangLong = Long.valueOf(((JSONObject)localObject10).optLong("uin"));
              localBiuCommentInfo.jdField_b_of_type_JavaLangString = new String(bbco.decode(((JSONObject)localObject10).optString("comment"), 0));
              localBiuCommentInfo.jdField_a_of_type_JavaLangString = localBiuCommentInfo.jdField_b_of_type_JavaLangString;
              localBiuCommentInfo.jdField_a_of_type_Int = ((JSONObject)localObject10).optInt("biuTime");
              localBiuCommentInfo.jdField_b_of_type_Int = ((JSONObject)localObject10).optInt("feeds_type", 1);
              localBiuCommentInfo.jdField_c_of_type_Int = ((JSONObject)localObject10).optInt("op_type");
              str5 = ((JSONObject)localObject10).optString("jumpName");
              str6 = ((JSONObject)localObject10).optString("jumpUrl");
              if ((!TextUtils.isEmpty(str5)) && (!TextUtils.isEmpty(str6))) {
                localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo = new SocializeFeedsInfo.JumpInfo(0L, new String(bbco.decode(str5, 0)), str6);
              }
              try
              {
                localObject10 = ((JSONObject)localObject10).optString("feedsId");
                if (!TextUtils.isEmpty((CharSequence)localObject10)) {
                  localBiuCommentInfo.jdField_b_of_type_JavaLangLong = Long.valueOf(new BigInteger((String)localObject10).longValue());
                }
                ((ArticleInfo)localObject7).mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList.add(localBiuCommentInfo);
                k += 1;
              }
              catch (Exception localException6)
              {
                localException6.printStackTrace();
                continue;
              }
            }
          }
          ((ArticleInfo)localObject7).mTitle = new String(bbco.decode(paramJSONObject, 0));
          ((ArticleInfo)localObject7).mSummary = "";
          if ((i2 != 3) && (i2 != 2)) {
            break label2376;
          }
          ((ArticleInfo)localObject7).mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          localObject4 = new qdb();
          localObject6 = ((JSONObject)localObject6).optJSONArray("ugcPicInfo");
          if ((localObject6 == null) || (((JSONArray)localObject6).length() <= 0)) {
            break label2371;
          }
          ((qdb)localObject4).jdField_c_of_type_JavaLangString = ((JSONArray)localObject6).getJSONObject(0).optString("ugcPicUrl");
          ((ArticleInfo)localObject7).mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_JavaUtilArrayList.add(localObject4);
          break label2371;
          if (m == 22)
          {
            localObject4 = new qcd();
            ((qcd)localObject4).jdField_a_of_type_JavaLangString = ((String)localObject3);
            ((qcd)localObject4).jdField_b_of_type_JavaLangString = str3;
            ((qcd)localObject4).jdField_c_of_type_JavaLangString = str4;
            ((qcd)localObject4).jdField_a_of_type_Long = l2;
            ((ArticleInfo)localObject7).mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Qcd = ((qcd)localObject4);
          }
          ((ArticleInfo)localObject7).mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Int = i2;
          ((ArticleInfo)localObject7).mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_JavaLangString = ((ArticleInfo)localObject7).mTitle;
          ((ArticleInfo)localObject7).mSocialFeedInfo.jdField_a_of_type_JavaLangString = "";
          ((ArticleInfo)localObject7).mSocialFeedInfo.jdField_c_of_type_JavaLangString = "";
          ((ArticleInfo)localObject7).mSocialFeedInfo.jdField_b_of_type_JavaLangString = "";
          localObject3 = new Intent(BaseActivity.sTopActivity, ReadInJoyDeliverBiuActivity.class);
          ((Intent)localObject3).putExtra("arg_article_info", (Parcelable)localObject7);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            ((Intent)localObject3).putExtra("biu_rowkey", (String)localObject1);
          }
          ((Intent)localObject3).putExtra("arg_from_type", m);
          ((Intent)localObject3).putExtra("arg_type", i);
          ((Intent)localObject3).putExtra("result_js_callback", paramString);
          i = 3;
          if (m != 5) {
            break label2399;
          }
          i = 4;
          ((Intent)localObject3).putExtra("biu_src", i);
          ((Intent)localObject3).putExtra("feed_id", (String)localObject2);
          ((Intent)localObject3).putExtra("feedsType", i1);
          ((Intent)localObject3).putExtra("ugc_comment", paramJSONObject);
          ((Intent)localObject3).putExtra("arg_account_id", l2);
          ((Intent)localObject3).putExtra("arg_account_type", j);
          ((Intent)localObject3).putExtra("arg_source_url", str2);
          if ((m == 23) && ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(((ArticleInfo)localObject7).mSubscribeName))))
          {
            QLog.d(TAG, 1, "web page share but core info empty !");
            return;
            ((ArticleInfo)localObject7).mSocialFeedInfo.jdField_a_of_type_Qda.b = new ArrayList();
            localObject8 = new qdc();
            localObject6 = ((JSONObject)localObject6).optJSONObject("ugcVideoInfo");
            if (localObject6 == null) {
              break label2391;
            }
            ((qdc)localObject8).d = ((JSONObject)localObject6).optString("ugcVideoCoverUrl");
            ((qdc)localObject8).jdField_a_of_type_Long = ((JSONObject)localObject6).optInt("ugcVideoDuration");
            ((qdc)localObject8).e = ((String)localObject4);
            ((ArticleInfo)localObject7).mSocialFeedInfo.jdField_a_of_type_Qda.b.add(localObject8);
            break label2391;
            if (i2 != 1) {
              break label2396;
            }
            ((ArticleInfo)localObject7).mFirstPagePicUrl = "";
            break label2396;
          }
          if (n == 1)
          {
            if ((((ArticleInfo)localObject7).mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList == null) || (((ArticleInfo)localObject7).mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList.size() <= 0)) {
              continue;
            }
            paramJSONObject = str1 + "//";
            paramJSONObject = "：" + paramJSONObject;
            paramString = (QQAppInterface)onh.a();
            if (paramString == null) {
              break;
            }
            ((osl)paramString.getManager(163)).a().a(onh.a(), l1, ((ArticleInfo)localObject7).mSocialFeedInfo.jdField_a_of_type_Qcg, 0L, paramJSONObject, l3, -1L, i, (String)localObject1, i1, (ArticleInfo)localObject7);
            return;
          }
          BaseActivity.sTopActivity.startActivityForResult((Intent)localObject3, 113);
          BaseActivity.sTopActivity.overridePendingTransition(0, 0);
          return;
        }
        continue;
        i = 1;
      }
      catch (JSONException paramJSONObject)
      {
        return;
      }
      label2371:
      continue;
      label2376:
      if (i2 != 4) {
        if (i2 == 5)
        {
          continue;
          label2391:
          i = 2;
          continue;
          label2396:
          continue;
          label2399:
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
          badv.a((Activity)localObject2, j, paramJSONObject, null, null, false, bool, (String)localObject1, 100, null, null, null, null, "", true);
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
        String str2 = new String(bbco.decode(paramJSONObject.optString("title", ""), 0));
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
          localBundle.putString("scroll_image_r5", onh.a(i, -1, Integer.toString(n), m, "", "", null));
          localBundle.putString("read_article_r5", onh.a(i, -1, Integer.toString(n), m, "", null));
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
    AppInterface localAppInterface = (AppInterface)onh.a();
    JSONObject localJSONObject = paramJSONObject.optJSONObject("shareInfo");
    String str = paramJSONObject.optString("menu_title", ajya.a(2131701191));
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
    this.mShareHelper = new sgv((Activity)localObject, localAppInterface, null, new ryf(this, false, null, null, localJSONObject, new WeakReference(localObject), paramString));
    this.mShareHelper.a.a(str);
    this.mShareHelper.a.a(new rxo(this));
    this.mShareHelper.a(ryj.a(bool, paramJSONObject));
  }
  
  private void showTips(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = (QQAppInterface)onh.a();
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
        bcql.a((Context)localObject, i, str, 0).b(((Context)localObject).getResources().getDimensionPixelSize(2131298865));
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
        paramJSONObject = new String(bbco.decode((String)localObject, 0));
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
    Object localObject1 = (AppInterface)onh.a();
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
      paramJSONObject = new String(bbco.decode((String)localObject2, 0));
      if (onh.g() >= 2)
      {
        bcql.a((Context)localObject1, 0, ((Activity)localObject1).getString(2131718435), 0).b(((Activity)localObject1).getResources().getDimensionPixelSize(2131298865));
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
      oeg.a((Activity)localObject1, (Bundle)localObject2, (byte)116);
      onh.a("2", "2");
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
    rvx.a(String.valueOf(paramJSONObject.optInt("bid", 3256)), new rxr(this, paramString));
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
    Object localObject = (QQAppInterface)onh.a();
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
        break label214;
      }
    }
    label214:
    for (int i = 1;; i = 2)
    {
      localBundle.putInt("videoType", i);
      ozb.a().a(getViolaInstance().getActivity(), (String)localObject, 2, str1, str2, str3, str4, str5, localBundle);
      return;
    }
  }
  
  @JSMethod
  public void c2sReport(JSONObject paramJSONObject)
  {
    try
    {
      yxp.a(TAG, paramJSONObject.toString());
      yxv.a(paramJSONObject.optInt("operationType"), paramJSONObject.optInt("businessType"), (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(yxo.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramJSONObject.getJSONObject("adInfo"))));
      return;
    }
    catch (Exception paramJSONObject)
    {
      yxp.d(TAG, "handleJsCallRequest", paramJSONObject);
    }
  }
  
  @JSMethod
  public void cancelVideoPreDownload()
  {
    if (this.mVideoPreDownloadMgr != null) {
      this.mVideoPreDownloadMgr.e();
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
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "destroy by instance");
    }
  }
  
  @JSMethod
  public void dwellTimeMillisReport(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("dwellTimeMillis");
      paramJSONObject = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(yxo.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramJSONObject.getJSONObject("adInfo")));
      yxu localyxu = new yxu();
      localyxu.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(paramJSONObject);
      localyxu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.set(42);
      localyxu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(i);
      yxt.a(localyxu);
      return;
    }
    catch (Exception paramJSONObject)
    {
      yxp.d(TAG, "handleJsCallRequest", paramJSONObject);
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
        if (odo.a() == 1)
        {
          paramJSONObject = "fastBiu";
          String str;
          if (odo.b() == 1)
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
  
  @JSMethod(uiThread=false)
  public void getNetType(String paramString)
  {
    getNetType(paramString, false);
  }
  
  public void getNetType(String paramString, boolean paramBoolean)
  {
    int i = naj.a();
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
    int k = naj.a();
    String str = naj.a();
    int j = 0;
    Object localObject = bbdh.b();
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
            break label148;
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
        label148:
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
      yxp.b(TAG, paramJSONObject.toString());
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
      paramJSONObject = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(yxo.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramJSONObject.getJSONObject("adInfo")));
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
      yxp.d(TAG, "handleJsCallRequest error", paramJSONObject);
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
      bool = vzw.a(localBaseActivity);
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
      bool = bbfr.a(localBaseActivity, paramString1);
      continue;
      label124:
      i = 0;
    }
    label130:
    ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), getModuleName(), "callback", paramString2, paramString1, true);
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
      invokeErrorCallJS(paramString, ajya.a(2131701201));
      QLog.d(TAG, 1, "ns or method not exists");
    }
    label223:
    label3304:
    label3325:
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
          break label899;
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
          break label3325;
        }
        invokeErrorCallJS(paramString, "ns:" + str1 + ajya.a(2131701197) + str2 + ajya.a(2131701192));
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
              i = 1;
              continue;
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
                        this.mActionSheetHelper = new rxe(this);
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
                          sfk.a((JSONObject)localObject3, (String)localObject1, new ryb(this));
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
                        i = 1;
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
                      localObject4 = (QQAppInterface)onh.a();
                      if ((localObject3 != null) && (localObject4 != null)) {}
                      for (;;)
                      {
                        try
                        {
                          localObject1 = bbex.a((QQAppInterface)localObject4, (Context)localObject3, ((JSONObject)localObject1).getString("schema"));
                          if (localObject1 != null)
                          {
                            ((bbeg)localObject1).a("viola");
                            ((bbeg)localObject1).c();
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
                            ((arik)((QQAppInterface)localObject3).getManager(306)).a((Bundle)localObject2);
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
                          ThreadManager.post(new BridgeModule.8(this), 8, null, true);
                          i = 0;
                          continue;
                        }
                        invokeErrorCallJS(paramString, ajya.a(2131701195) + str2 + ajya.a(2131701196));
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
                            break label3304;
                          }
                        }
                        for (localObject2 = paramString;; localObject2 = ((JSONObject)localObject3).optString("callback"))
                        {
                          sfk.a((JSONObject)localObject3, (String)localObject2, new ryc(this));
                          i = 0;
                          break;
                        }
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
        if (bbwq.a() == 1)
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
    int i = 0;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.mCommentManager != null) {
      this.mCommentManager.a(paramInt1, paramInt2, paramIntent);
    }
    if ((paramInt1 == 114) || (paramInt1 == 115) || (paramInt1 == 116) || (paramInt1 == 122)) {
      if (paramIntent != null) {}
    }
    label261:
    label1160:
    label1163:
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
            break label261;
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
        if (paramInt1 == 113) {
          if (paramInt2 != -1) {
            break label1160;
          }
        }
        for (paramInt1 = i;; paramInt1 = -1) {
          for (;;)
          {
            for (;;)
            {
              if (paramIntent == null) {
                break label1163;
              }
              localObject1 = paramIntent.getStringExtra("result_js_callback");
              localObject2 = paramIntent.getStringExtra("feed_id");
              paramInt2 = paramIntent.getIntExtra("feedsType", 1);
              if ((localObject1 == null) || (localObject2 == null)) {
                break;
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
              if (paramInt1 == 119)
              {
                if ((paramIntent == null) || (BaseActivity.sTopActivity == null)) {
                  break;
                }
                localObject2 = paramIntent.getStringExtra("arg_callback");
                if (TextUtils.isEmpty((CharSequence)localObject2)) {
                  break;
                }
                paramInt1 = paramIntent.getIntExtra("result_code", -1);
                if (paramInt1 == 0)
                {
                  if (Looper.myLooper() == null) {
                    Looper.prepare();
                  }
                  new Handler(BaseActivity.sTopActivity.getMainLooper()).postDelayed(new BridgeModule.23(this), 200L);
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
              if ((paramInt1 != 118) && (paramInt1 != 121)) {
                break label960;
              }
              if (paramIntent != null) {
                break label708;
              }
              if (paramInt2 != 0) {
                break;
              }
              try
              {
                paramIntent = new JSONObject();
                paramIntent.put("retCode", 1);
                paramIntent.put("msg", ajya.a(2131701190));
                if (QLog.isColorLevel()) {
                  QLog.d(TAG, 2, "selectAndUploadAvatar  result:" + ReadInJoyDeliverUGCActivity.a(paramIntent.toString()));
                }
                if (TextUtils.isEmpty(this.mUploadCallBack)) {
                  break;
                }
                invokeCallJS(this.mUploadCallBack, paramIntent);
                return;
              }
              catch (Exception paramIntent) {}
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e(TAG, 2, QLog.getStackTraceString(paramIntent));
            return;
            label708:
            localObject1 = paramIntent.getStringExtra("callbackId");
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break;
            }
            if (paramInt2 == -1)
            {
              localObject2 = paramIntent.getBundleExtra("Bundle");
              if (localObject2 == null) {
                break;
              }
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
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.e(TAG, 2, QLog.getStackTraceString(paramIntent));
              return;
            }
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
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e(TAG, 2, QLog.getStackTraceString(paramIntent));
            return;
            label960:
            if (paramInt1 == 117)
            {
              if (paramIntent == null) {
                break;
              }
              localObject1 = paramIntent.getStringExtra("arg_callback");
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break;
              }
              paramIntent = paramIntent.getStringExtra("arg_result_json");
            }
            try
            {
              if (!TextUtils.isEmpty(paramIntent))
              {
                paramIntent = new JSONObject(paramIntent);
                if (paramInt2 != -1) {
                  break label1083;
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
                label1083:
                paramIntent.put("retCode", -1);
              }
              if ((paramInt2 != -1) || (paramInt1 != 21) || (getViolaInstance() == null) || (getViolaInstance().getActivity() == null)) {
                break;
              }
              ForwardUtils.a((QQAppInterface)onh.a(), getViolaInstance().getActivity(), getViolaInstance().getActivity(), paramIntent, null);
              QLog.d(TAG, 2, "share video card to aio success。");
              return;
            }
            catch (Exception paramIntent) {}
          }
        }
      }
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    AbstractGifImage.resumeAll();
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
          invokeErrorCallJS(paramString2, ajya.a(2131701194));
        }
      }
      else
      {
        if ((paramString1.contains("weishi")) || (paramString1.contains("weishi://feed"))) {
          if (vzw.a(localBaseActivity)) {
            sir.a(localBaseActivity, "video_type_videopublic");
          }
        }
        while (!TextUtils.isEmpty(paramString2))
        {
          invokeCallJS(paramString2, null);
          return;
          bcql.a(localBaseActivity, -1, ajya.a(2131701200), 0).b(localBaseActivity.getResources().getDimensionPixelSize(2131298865));
          sir.b(localBaseActivity, "video_type_videopublic");
          continue;
          if (!oar.a(localBaseActivity, paramString1))
          {
            Intent localIntent = new Intent();
            localIntent.setAction("android.intent.action.VIEW");
            String str = paramString3;
            if (TextUtils.isEmpty(paramString3)) {
              str = onh.f(0);
            }
            localIntent.putExtra("big_brother_source_key", str);
            localIntent.putExtra("big_brother_ref_source_key", onh.f(0));
            localIntent.setData(Uri.parse(paramString1));
            localBaseActivity.startActivity(localIntent);
          }
        }
      }
    }
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
      rvx.a(localBaseActivity, paramJSONObject);
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
      ((ViolaFragment)getViolaInstance().getFragment()).a(new rya(this, paramString));
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
      CheckPermission.requestSDCardPermission((AppActivity)localActivity, new rxw(this, paramJSONObject, paramString));
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
      ((StringBuilder)localObject).append("&version=8.3.0.4480");
      ((StringBuilder)localObject).append("&system=" + Build.VERSION.RELEASE);
      ((StringBuilder)localObject).append("&device=" + Build.DEVICE);
      ((StringBuilder)localObject).append("&uin=" + onh.a());
      paramJSONObject = anqz.a("VIP_xingying", ((StringBuilder)localObject).toString());
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "saveImage imageUrl=" + paramJSONObject);
      }
      localObject = System.currentTimeMillis() + ".jpg";
      ThreadManager.executeOnNetWorkThread(new BridgeModule.27(this, paramJSONObject, new File(ajsd.bc, (String)localObject), paramString));
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
          localQQAppInterface = (QQAppInterface)onh.a();
          if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (localQQAppInterface != null) && (!TextUtils.isEmpty(str)))
          {
            localObject2 = ((JSONObject)localObject2).toString();
            if (this.preTime == 0L) {
              break label182;
            }
            if (System.currentTimeMillis() - this.preTime >= this.minDuration * 1000) {
              break label145;
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
    label145:
    if (((String)localObject2).getBytes().length > this.maxSize)
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("cret", 2);
      invokeCallJS(paramString, paramJSONObject);
      return;
      label182:
      this.preTime = System.currentTimeMillis();
    }
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
        localObject1 = new NewIntent(localQQAppInterface.getApplication(), mxe.class);
        ((NewIntent)localObject1).putExtra("cmd", "MQUpdateSvc_" + paramJSONObject + ".web." + str);
        paramJSONObject = new WebSsoBody.WebSsoRequestBody();
        paramJSONObject.type.set(0);
        paramJSONObject.data.set((String)localObject2);
        ((NewIntent)localObject1).putExtra("data", paramJSONObject.toByteArray());
        ((NewIntent)localObject1).setObserver(new rxk(this, paramString));
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
          ((rxd)localObject).a(paramJSONObject, new rxy(this, paramString));
          return;
        }
        if (!str.equals("left")) {
          break;
        }
        ((rxd)localObject).b(paramJSONObject, new rxz(this, paramString));
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
      bcql.a(onh.a().getApplication(), 1, ajya.a(2131701199), 0).a();
      return;
    }
    Object localObject2 = new File(ayoi.d(paramString));
    if (((File)localObject2).exists())
    {
      shareImageToAIOInner((File)localObject2);
      return;
    }
    localObject1 = new Bundle();
    localObject2 = new bbwu(paramString, (File)localObject2);
    ((bbwu)localObject2).d = 60L;
    ((bbww)onh.a().getManager(47)).a(1).a((bbwu)localObject2, new rxx(this, paramString), (Bundle)localObject1);
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
    aqbe.a(localActivity, (Intent)localObject, 18);
  }
  
  @JSMethod
  public void shareVideoWithFriend(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "do shareVideoWithFriend start data: " + paramJSONObject.toString());
    }
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.jdField_c_of_type_JavaLangString = paramJSONObject.optString("article_title", "");
    localVideoInfo.jdField_a_of_type_Int = paramJSONObject.optInt("busiType");
    localVideoInfo.jdField_a_of_type_JavaLangString = paramJSONObject.optString("vid");
    localVideoInfo.f = paramJSONObject.optString("article_url");
    localVideoInfo.d = paramJSONObject.optInt("duration");
    localVideoInfo.g = paramJSONObject.optString("rowkey");
    localVideoInfo.jdField_b_of_type_JavaLangString = paramJSONObject.optString("first_page_url");
    localVideoInfo.jdField_b_of_type_Int = paramJSONObject.optInt("width");
    localVideoInfo.jdField_c_of_type_Int = paramJSONObject.optInt("height");
    localVideoInfo.k = paramJSONObject.optString("thridName");
    localVideoInfo.D = paramJSONObject.optString("thirdAction");
    localVideoInfo.E = paramJSONObject.optString("thirdIcon");
    localVideoInfo.j = paramJSONObject.optString("third_uin");
    localVideoInfo.F = paramJSONObject.optString("third_uin_name");
    qrt.a(localVideoInfo, getViolaInstance().getActivity(), 1);
  }
  
  public void showShareReadInJoyMenu(JSONObject paramJSONObject, String paramString)
  {
    AppInterface localAppInterface = (AppInterface)onh.a();
    Object localObject1 = getViolaInstance().getFragment();
    if (localObject1 != null) {}
    for (localObject1 = ((Fragment)localObject1).getActivity(); localObject1 == null; localObject1 = getViolaInstance().getActivity()) {
      return;
    }
    Object localObject2 = paramJSONObject.optJSONArray("upline");
    Object localObject3 = paramJSONObject.optJSONArray("belowline");
    String str = paramJSONObject.optString("menu_title", "biu出去让更多好友看到");
    if (localObject2 == null)
    {
      localObject2 = this.mShareUtils.a();
      if (localObject3 != null) {
        break label169;
      }
    }
    ArrayList localArrayList;
    label169:
    for (localObject3 = this.mShareUtils.b();; localObject3 = this.mShareUtils.a((JSONArray)localObject3, paramJSONObject))
    {
      localArrayList = new ArrayList();
      localObject4 = ((List)localObject2).iterator();
      while (((Iterator)localObject4).hasNext()) {
        localArrayList.add(Integer.valueOf(((rym)((Iterator)localObject4).next()).jdField_a_of_type_Int));
      }
      localObject2 = this.mShareUtils.a((JSONArray)localObject2, paramJSONObject);
      break;
    }
    Object localObject4 = new ArrayList();
    Iterator localIterator = ((List)localObject3).iterator();
    while (localIterator.hasNext()) {
      ((List)localObject4).add(Integer.valueOf(((rym)localIterator.next()).jdField_a_of_type_Int));
    }
    this.mShareHelper = new sgv((Activity)localObject1, localAppInterface, new rye(this), new ryf(this, true, (List)localObject2, (List)localObject3, paramJSONObject, new WeakReference(localObject1), paramString));
    this.mShareHelper.a(new List[] { localArrayList, localObject4 });
    this.mShareHelper.a.a(str);
    this.mShareHelper.a.a(new rxj(this, paramString));
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
      osg.a().a(str, Integer.valueOf(paramJSONObject).intValue());
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
        break label167;
      }
    }
    label167:
    for (float f1 = FlexConvertUtils.converPxByViewportToRealPx(paramJSONObject.opt("width"), 750);; f1 = 100.0F)
    {
      if (paramJSONObject.has("height")) {
        f2 = FlexConvertUtils.converPxByViewportToRealPx(paramJSONObject.opt("height"), 750);
      }
      paramJSONObject = URLDrawable.getDrawable(str, rwv.a(bool, (int)f1, (int)f2));
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
        localArrayList.add(new qui(localJSONObject.optString("videoVid"), localJSONObject.optString("articleID"), localJSONObject.optInt("busitype"), localJSONObject.optInt("duration")));
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
        this.mVideoPreDownloadMgr.a = new quk(quk.d, quk.f);
        this.mVideoPreDownloadMgr.a(new rxi(this, localArrayList));
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
        localViolaFragment.a().f();
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
        localViolaFragment.a().e();
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
          paramJSONObject = osj.a();
          if (i != 2) {
            break label120;
          }
          paramJSONObject.b(l, bool);
          ThreadManager.post(new BridgeModule.10(this, l, i), 8, null, true);
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
      osj.a().a(i, null);
    }
  }
  
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
      if (!osg.a().a(i, j)) {
        osg.a().d(i, j);
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
    QQAppInterface localQQAppInterface = (QQAppInterface)onh.a();
    if (localQQAppInterface == null) {}
    while (this.netInfoHandler != null) {
      return;
    }
    this.netInfoHandler = new rxq(this, paramString);
    AppNetConnInfo.registerConnectionChangeReceiver(localQQAppInterface.getApplication(), this.netInfoHandler);
  }
  
  @JSMethod
  public void videoPlayFeedback(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "do videoPlayFeedback start data: " + paramJSONObject.toString());
    }
    qyw.a(paramJSONObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule
 * JD-Core Version:    0.7.0.1
 */