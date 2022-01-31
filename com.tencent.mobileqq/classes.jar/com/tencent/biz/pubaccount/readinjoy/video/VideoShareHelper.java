package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItem;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItemAdapter;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItemViewHolder;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.VideoShareUtils;
import com.tencent.biz.pubaccount.readinjoy.logic.KandianFavoriteBroadcastReceiver;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager.AtlasCallbackImpl;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.VideoExtraRepoerData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView;
import com.tencent.biz.pubaccount.util.PAVideoStructMsgUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.QZoneShareManager;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import meg;
import meh;
import mei;
import mej;
import mek;
import mel;
import meo;
import mep;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoShareHelper
  implements AdapterView.OnItemClickListener
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private View jdField_a_of_type_AndroidViewView;
  private KandianFavoriteBroadcastReceiver jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver;
  private ReadInJoyAtlasManager.AtlasCallbackImpl jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallbackImpl = new mep(this);
  private BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private VideoPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager;
  private VideoShareListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoShareListener;
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private HashSet jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private ActionSheet jdField_b_of_type_ComTencentWidgetActionSheet;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public VideoShareHelper(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    paramActivity = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramActivity instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramActivity);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver = new KandianFavoriteBroadcastReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallbackImpl);
    paramActivity = new IntentFilter();
    paramActivity.addAction("com.tencent.process.fav");
    this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver, paramActivity);
  }
  
  private View a()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130968984, null);
    float f = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().density;
    ElasticHorScrView localElasticHorScrView1 = (ElasticHorScrView)localView.findViewById(2131363794);
    ElasticHorScrView localElasticHorScrView2 = (ElasticHorScrView)localView.findViewById(2131363796);
    GridView localGridView2 = (GridView)localView.findViewById(2131363795);
    GridView localGridView1 = (GridView)localView.findViewById(2131363797);
    Object localObject1 = (TextView)localView.findViewById(2131362797);
    Object localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject2).topMargin = ((int)(13.0F * f));
    ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((TextView)localObject1).setText(2131432998);
    ((TextView)localObject1).setOnClickListener(new meh(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new mei(this));
    if (Build.VERSION.SDK_INT >= 9)
    {
      localElasticHorScrView1.setOverScrollMode(2);
      localElasticHorScrView2.setOverScrollMode(2);
    }
    localGridView1.setSmoothScrollbarEnabled(false);
    localObject2 = a();
    if (localObject2.length > 0)
    {
      localObject1 = localObject2[0];
      if (localObject2.length <= 1) {
        break label430;
      }
    }
    label430:
    for (localObject2 = localObject2[1];; localObject2 = new ArrayList(0))
    {
      int i = ((List)localObject1).size();
      localGridView2.setNumColumns(i);
      ViewGroup.LayoutParams localLayoutParams = localGridView2.getLayoutParams();
      localLayoutParams.width = ((int)(((i - 1) * 10 + i * 75 + 3) * f));
      localGridView2.setLayoutParams(localLayoutParams);
      localGridView2.setAdapter(new PublicAccountBrowser.ActionSheetItemAdapter(this.jdField_a_of_type_AndroidAppActivity, 0, (List)localObject1));
      localGridView2.setSelector(new ColorDrawable(0));
      localGridView2.setOnItemClickListener(this);
      i = localLayoutParams.width;
      int j = ((List)localObject2).size();
      localObject1 = localGridView1.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = ((int)(f * (j * 75 + (j - 1) * 10 + 3)));
      localGridView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localGridView1.setNumColumns(j);
      localGridView1.setAdapter(new PublicAccountBrowser.ActionSheetItemAdapter(this.jdField_a_of_type_AndroidAppActivity, 0, (List)localObject2));
      localGridView1.setSelector(new ColorDrawable(0));
      localGridView1.setOnItemClickListener(this);
      localView.post(new mej(this, localElasticHorScrView1, i, localElasticHorScrView2, ((ViewGroup.LayoutParams)localObject1).width));
      return localView;
      localObject1 = new ArrayList(0);
      break;
    }
  }
  
  private void a(Bundle paramBundle)
  {
    Object localObject = (StructMsgForGeneralShare)StructMsgFactory.a(paramBundle.getByteArray("STRUCT_MSG_BYTES"));
    if ((!TextUtils.isEmpty(((StructMsgForGeneralShare)localObject).mMsgBrief)) && (((StructMsgForGeneralShare)localObject).mMsgBrief.indexOf("[视频]") == -1)) {
      ((StructMsgForGeneralShare)localObject).mMsgBrief = ("[视频]" + ((StructMsgForGeneralShare)localObject).mMsgBrief);
    }
    String str1 = paramBundle.getString("VIDEO_THIRD_ICON");
    String str2 = paramBundle.getString("VIDEO_THIRD_ACTION");
    String str3 = paramBundle.getString("VIDEO_THIRD_NAME");
    String str4 = paramBundle.getString("VIDEO_PUB_ACCOUNT_UIN");
    String str5 = paramBundle.getString("VIDEO_PUB_ACCOUNT_NAME");
    String str6 = PAVideoStructMsgUtil.a(str4);
    PAVideoStructMsgUtil.a((StructMsgForGeneralShare)localObject);
    ((StructMsgForGeneralShare)localObject).mSourceAction = "web";
    long l;
    if (TextUtils.isEmpty(str4))
    {
      l = 0L;
      ((StructMsgForGeneralShare)localObject).mSourceAppid = l;
      ((StructMsgForGeneralShare)localObject).source_puin = str4;
      if (paramBundle.getInt("VIDEO_ARTICLE_BUSITYPE") <= 1) {
        break label380;
      }
      if ((TextUtils.isEmpty(str4)) || (str4.equals("16888"))) {
        break label351;
      }
      ((StructMsgForGeneralShare)localObject).mSourceUrl = str6;
      label195:
      if ((str5 != null) && (!"".equals(str3))) {
        ((StructMsgForGeneralShare)localObject).mSourceThirdName = str5;
      }
      label218:
      if ((str3 == null) || ("".equals(str3))) {
        break label390;
      }
      ((StructMsgForGeneralShare)localObject).mSourceName = str3;
      label241:
      if ((str1 == null) || ("".equals(str1))) {
        break label400;
      }
    }
    label390:
    label400:
    for (((StructMsgForGeneralShare)localObject).mSourceIcon = str1;; ((StructMsgForGeneralShare)localObject).mSourceIcon = "https://q.url.cn/s/jBJuV")
    {
      ((StructMsgForGeneralShare)localObject).setFlag(0);
      paramBundle = new Bundle();
      paramBundle.putInt("forward_type", -3);
      paramBundle.putInt("structmsg_service_id", ((StructMsgForGeneralShare)localObject).mMsgServiceID);
      paramBundle.putByteArray("stuctmsg_bytes", ((StructMsgForGeneralShare)localObject).getBytes());
      localObject = new Intent();
      ((Intent)localObject).putExtras(paramBundle);
      ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject, 21);
      return;
      l = Long.valueOf(str4).longValue();
      break;
      label351:
      if (!TextUtils.isEmpty(str2))
      {
        ((StructMsgForGeneralShare)localObject).mSourceUrl = str2;
        break label195;
      }
      ((StructMsgForGeneralShare)localObject).mSourceUrl = "";
      break label195;
      label380:
      ((StructMsgForGeneralShare)localObject).mSourceUrl = str6;
      break label218;
      ((StructMsgForGeneralShare)localObject).mSourceName = str5;
      break label241;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "shareMsgToSina start!");
    }
    paramString2 = this.jdField_a_of_type_AndroidAppActivity;
    Object localObject = new String[9];
    localObject[0] = "这个视频不错 ~\\(≧▽≦)/~";
    localObject[1] = "吼精彩的视频，分享给大家";
    localObject[2] = "鹅妹子嘤~ 分享一发";
    localObject[3] = "好赞的视频，分享一波";
    localObject[4] = "hhh 视频界的一股清流";
    localObject[5] = "因吹斯汀";
    localObject[6] = "吃瓜群众转发围观";
    localObject[7] = "震惊！这个视频竟然....";
    localObject[8] = "厉害了我的哥";
    localObject = localObject[new java.util.Random().nextInt(localObject.length)];
    paramString1 = "#QQ看点#" + (String)localObject + "【" + paramString1 + "】";
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "shareMsgToSina empty title or share_url");
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131435286, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
    }
    for (;;)
    {
      return;
      try
      {
        paramString1 = URLEncoder.encode(paramString1, "UTF-8");
        paramString1 = "http://v.t.sina.com.cn/share/share.php?" + "title=" + paramString1 + "%F0%9F%8E%AC";
        paramString3 = URLEncoder.encode(paramString3, "UTF-8");
        paramString1 = paramString1 + "&url=" + paramString3;
        paramString3 = URLEncoder.encode(paramString4, "UTF-8");
        paramString1 = paramString1 + "&pic=" + paramString3;
        paramString1 = paramString1 + "&_wv=3";
        paramString3 = new Intent(paramString2, QQBrowserActivity.class);
        paramString3.putExtra("url", paramString1);
        paramString2.startActivity(paramString3);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "shareMsgToSina start webview!");
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "shareMsgToSina end!");
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString1 = paramString1;
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131435286, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
          paramString1.printStackTrace();
        }
      }
      finally {}
    }
  }
  
  private List[] a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131430091);
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130838332;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 2;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131430097);
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130838333;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 3;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131430109);
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130838336;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 9;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131430110);
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130838330;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 10;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131430115);
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130838335;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 12;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131430095);
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130840650;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 4;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ArrayList();
    PublicAccountBrowser.ActionSheetItem localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131430107);
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_a_of_type_Int = 2130841536;
    localActionSheetItem.jdField_b_of_type_Int = 6;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430108);
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_a_of_type_Int = 2130840640;
    localActionSheetItem.jdField_b_of_type_Int = 24;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131430093);
    localActionSheetItem.jdField_a_of_type_Int = 2130838328;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_b_of_type_Int = 1;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131430094);
    localActionSheetItem.jdField_a_of_type_Int = 2130840641;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_b_of_type_Int = 11;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  private void b()
  {
    View localView;
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidAppActivity, null));
      localView = a();
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(localView, null);
    }
    try
    {
      for (;;)
      {
        if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
        {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
          c();
        }
        return;
        localView = a();
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a(localView, null);
      }
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "actionSheet.show exception=" + localException);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    do
    {
      try
      {
        this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoCoverUrl, null, null);
        if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1) && ((this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof RegionDrawable)))
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = ((RegionDrawable)this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()).getBitmap();
          return;
        }
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("Q.readinjoy.video.VideoShareHelper", 2, "initVideoThumbBitmap() URLDrawable.getDrawable ERROR, RETURN");
        return;
      }
    } while (this.jdField_a_of_type_ComTencentImageURLDrawable == null);
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new meg(this));
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver != null)) {
      this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver);
    }
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public void a(View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, Bundle paramBundle, VideoPlayManager paramVideoPlayManager, VideoShareListener paramVideoShareListener, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoShareListener = paramVideoShareListener;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager = paramVideoPlayManager;
    this.jdField_b_of_type_Int = paramInt;
    b();
  }
  
  public void a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.c = true;
    paramAdapterView = paramView.getTag();
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder().append("onItemClick, tag = ");
      if (paramAdapterView == null) {
        break label58;
      }
    }
    label58:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, bool);
      if (paramAdapterView != null) {
        break;
      }
      return;
    }
    BaseArticleInfo localBaseArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    int i = ((PublicAccountBrowser.ActionSheetItemViewHolder)paramAdapterView).a.jdField_b_of_type_Int;
    paramView = localBaseArticleInfo.mArticleContentUrl;
    Object localObject1;
    if (i == 1)
    {
      paramAdapterView = this.jdField_a_of_type_AndroidContentContext;
      localObject1 = this.jdField_a_of_type_AndroidContentContext;
      ((ClipboardManager)paramAdapterView.getSystemService("clipboard")).setText(paramView + "&sourcefrom=6");
      QRUtils.a(2, 2131429988);
      paramInt = 3;
    }
    for (;;)
    {
      paramView = new JSONObject();
      try
      {
        paramView.put("algorithm_id", localBaseArticleInfo.mAlgorithmID);
        paramView.put("strategy_id", localBaseArticleInfo.mStrategyId);
        paramView.put("channel_id", this.jdField_b_of_type_Int);
        if ((i != 1) && (i != 11) && (i != 6))
        {
          paramLong = this.jdField_a_of_type_AndroidAppActivity.getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
          paramAdapterView = new ReportInfo.VideoExtraRepoerData();
          paramAdapterView.d = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a());
          paramAdapterView.e = (localBaseArticleInfo.mVideoDuration * 1000);
          if (paramLong == 0L)
          {
            i = 1;
            paramAdapterView.c = i;
            VideoReporter.a(localBaseArticleInfo.mArticleID, localBaseArticleInfo.innerUniqueID, this.jdField_b_of_type_Int, 26, -1L, paramAdapterView);
          }
        }
        else
        {
          localObject1 = localBaseArticleInfo.mSubscribeID;
          Object localObject2 = Integer.toString(paramInt);
          if (TextUtils.isEmpty(localBaseArticleInfo.innerUniqueID)) {
            break label1649;
          }
          paramAdapterView = localBaseArticleInfo.innerUniqueID;
          PublicAccountReportUtils.a(null, (String)localObject1, "0X800740F", "0X800740F", 0, 0, "1", (String)localObject2, paramAdapterView, VideoReporter.a(null, localBaseArticleInfo.mSubscribeID, localBaseArticleInfo.mVideoVid, String.valueOf(localBaseArticleInfo.innerUniqueID), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(), localBaseArticleInfo.mVideoDuration * 1000, paramView), false);
          return;
          if (i == 11)
          {
            this.jdField_a_of_type_Boolean = false;
            paramAdapterView = null;
            try
            {
              paramView = URLEncoder.encode(paramView, "UTF-8");
              if (!TextUtils.isEmpty(localBaseArticleInfo.mSubscribeID))
              {
                paramAdapterView = localBaseArticleInfo.mSubscribeID;
                paramAdapterView = "https://post.mp.qq.com/jubao/index?_wv=3&puin=" + paramAdapterView + "&uin_type=0&url=" + paramView + "&type=4&key=" + localBaseArticleInfo.innerUniqueID;
                if (QLog.isColorLevel()) {
                  QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "click jubao btn, reportUrl:" + paramAdapterView);
                }
                paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
                paramView.putExtra("url", paramAdapterView);
                paramView.putExtra("hide_more_button", true);
                this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
                paramInt = 3;
              }
            }
            catch (UnsupportedEncodingException paramView)
            {
              for (;;)
              {
                paramView = paramAdapterView;
                if (QLog.isColorLevel())
                {
                  QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "encode url failed, because UTF-8 is unknown");
                  paramView = paramAdapterView;
                  continue;
                  if (!TextUtils.isEmpty(localBaseArticleInfo.thirdUin)) {
                    paramAdapterView = localBaseArticleInfo.thirdUin;
                  } else {
                    paramAdapterView = "0";
                  }
                }
              }
            }
          }
          if (i == 2)
          {
            this.jdField_a_of_type_Boolean = false;
            a(this.jdField_a_of_type_AndroidOsBundle);
            paramInt = 0;
            continue;
          }
          if (i == 4)
          {
            this.jdField_a_of_type_Boolean = false;
            paramAdapterView = new Intent("android.intent.action.VIEW", Uri.parse(paramView + "&sourcefrom=6"));
            paramAdapterView.putExtra("normal", true);
            try
            {
              this.jdField_a_of_type_AndroidAppActivity.startActivity(paramAdapterView);
              paramInt = 3;
            }
            catch (ActivityNotFoundException paramAdapterView)
            {
              for (;;)
              {
                QRUtils.a(1, 2131430011);
              }
            }
          }
          if (i == 3)
          {
            this.jdField_a_of_type_Boolean = false;
            paramAdapterView = new Bundle();
            paramAdapterView.putString("title", localBaseArticleInfo.mTitle);
            paramAdapterView.putString("desc", localBaseArticleInfo.mSummary);
            paramAdapterView.putString("detail_url", paramView + "&sourcefrom=1");
            paramView = new ArrayList(1);
            paramView.add(localBaseArticleInfo.mVideoCoverUrl.getFile());
            paramAdapterView.putStringArrayList("image_url", paramView);
            paramAdapterView.putLong("req_share_id", 0L);
            QZoneShareManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramAdapterView, null);
            paramInt = 1;
            continue;
          }
          if (i == 6)
          {
            if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
            {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, "当前网络不可用", 0).a();
              return;
            }
            VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity);
            paramView = localBaseArticleInfo.mArticleContentUrl + "&sourcefrom=6";
            paramAdapterView = VideoFeedsHelper.a(localBaseArticleInfo);
            localObject2 = VideoFeedsHelper.a(localBaseArticleInfo);
            localObject1 = new Bundle();
            ((Bundle)localObject1).putInt("videoDuration", localBaseArticleInfo.mVideoDuration);
            ((Bundle)localObject1).putLong("publishAccountUin", ((Long)localObject2).longValue());
            ((Bundle)localObject1).putString("publishAccountName", paramAdapterView);
            localObject2 = ReadInJoyAtlasManager.a();
            Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
            String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
            String str2 = localBaseArticleInfo.innerUniqueID;
            String str3 = localBaseArticleInfo.mTitle;
            String str4 = localBaseArticleInfo.mSummary;
            if (localBaseArticleInfo.mVideoCoverUrl == null) {}
            for (paramAdapterView = "";; paramAdapterView = localBaseArticleInfo.mVideoCoverUrl.getPath())
            {
              ((ReadInJoyAtlasManager)localObject2).a(localActivity, str1, 2, str2, str3, str4, paramAdapterView, paramView, (Bundle)localObject1);
              this.jdField_a_of_type_JavaUtilHashSet.add(localBaseArticleInfo.innerUniqueID);
              paramInt = 6;
              break;
            }
          }
          if ((i == 9) || (i == 10))
          {
            this.jdField_a_of_type_Boolean = false;
            if (i == 9) {
              paramAdapterView = paramView + "&sourcefrom=2";
            }
            for (paramInt = 2;; paramInt = 4)
            {
              paramView = new StringBuilder();
              if (localBaseArticleInfo.mVideoPlayCount > 0) {
                paramView.append(VideoFeedsHelper.b(localBaseArticleInfo.mVideoPlayCount)).append(" ");
              }
              VideoShareUtils.a((BaseActivity)this.jdField_a_of_type_AndroidAppActivity, localBaseArticleInfo.mTitle, paramView.toString(), paramAdapterView, this.jdField_a_of_type_AndroidGraphicsBitmap, i);
              break;
              paramAdapterView = paramView + "&sourcefrom=3";
            }
          }
          if (i == 12)
          {
            this.jdField_a_of_type_Boolean = false;
            a(localBaseArticleInfo.mTitle, "", localBaseArticleInfo.mArticleContentUrl + "&sourcefrom=4", localBaseArticleInfo.mVideoCoverUrl.getFile());
            paramInt = 5;
            continue;
          }
          if (i == 24)
          {
            this.jdField_a_of_type_Boolean = false;
            paramAdapterView = new JSONObject();
            try
            {
              paramAdapterView.put("channel_id", this.jdField_b_of_type_Int);
              paramAdapterView.put("source", 1);
              if ((localBaseArticleInfo.mDislikeInfos != null) && (localBaseArticleInfo.mDislikeInfos.size() > 0))
              {
                this.jdField_b_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidAppActivity, null));
                paramView = new mek(this);
                this.jdField_b_of_type_ComTencentWidgetActionSheet.a(paramView);
                paramView = new ReadInJoyDisLikeDialogView(this.jdField_a_of_type_AndroidContentContext);
                paramView.setOnUninterestConfirmListener(new mel(this, localBaseArticleInfo, paramAdapterView));
                paramView.setUninterestData(localBaseArticleInfo.mDislikeInfos);
                this.jdField_b_of_type_ComTencentWidgetActionSheet.a(paramView, null);
                try
                {
                  if (!this.jdField_b_of_type_ComTencentWidgetActionSheet.isShowing())
                  {
                    if ((VersionUtils.g()) && (!ShortVideoUtils.c()))
                    {
                      this.jdField_b_of_type_ComTencentWidgetActionSheet.getWindow().setFlags(8, 8);
                      this.jdField_b_of_type_ComTencentWidgetActionSheet.getWindow().getDecorView().setSystemUiVisibility(this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getSystemUiVisibility());
                      this.jdField_b_of_type_ComTencentWidgetActionSheet.setOnShowListener(new meo(this));
                    }
                    this.jdField_b_of_type_ComTencentWidgetActionSheet.show();
                    PublicAccountReportUtils.b(null, null, "0X800913B", "0X800913B", 0, 0, null, null, null, VideoReporter.a(null, null, null, null, paramAdapterView), false);
                  }
                }
                catch (Exception paramAdapterView)
                {
                  for (;;)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "dislikeSheet.show exception=" + paramAdapterView);
                    }
                  }
                }
                paramInt = 3;
              }
            }
            catch (JSONException paramView)
            {
              for (;;)
              {
                paramView.printStackTrace();
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "文章ID为：" + localBaseArticleInfo.mArticleID + "的负反馈数据为空!");
              }
            }
          }
          paramInt = 3;
        }
      }
      catch (JSONException paramAdapterView)
      {
        for (;;)
        {
          paramAdapterView.printStackTrace();
          continue;
          i = 2;
          continue;
          label1649:
          paramAdapterView = "0";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoShareHelper
 * JD-Core Version:    0.7.0.1
 */