import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo.3;
import com.tencent.mobileqq.structmsg.view.TitledImageView;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;
import cooperation.qzone.model.PictureUrl;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.model.VideoInfo.VideoRemark;
import cooperation.qzone.model.VideoUrl;
import cooperation.qzone.model.WeishiFeedCommInfo;
import cooperation.qzone.model.WeishiFeedInfo;
import cooperation.qzone.model.WeishiUserInfo;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;

public class azvm
  extends azqj
{
  public String S;
  public String T;
  public String U;
  public String V;
  public String W;
  public String X;
  public String Y;
  public String Z;
  protected View.OnClickListener a;
  public azvu a;
  private URLDrawableDownListener.Adapter a;
  public boolean a;
  public String aa;
  String ab = "";
  String ac = "";
  String ai = "";
  String aj = "";
  String ak;
  String al;
  String am;
  String an;
  private View.OnClickListener b = new azvn(this);
  public boolean b;
  public long c;
  public boolean c;
  boolean d;
  public int k;
  public int l;
  public int m;
  public int n;
  public int o;
  public int p;
  public int q;
  public int r;
  
  public azvm()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new azvq(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new azvr(this);
    this.jdField_a_of_type_JavaLangString = "video";
    this.jdField_a_of_type_Int = 14;
  }
  
  public azvm(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString5, String paramString6, String paramString7, int paramInt7, long paramLong)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new azvq(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new azvr(this);
    this.jdField_a_of_type_JavaLangString = "video";
    this.S = paramString1;
    this.r = paramInt1;
    this.U = paramString2;
    this.V = paramString3;
    this.W = paramString4;
    this.m = paramInt2;
    this.l = paramInt3;
    this.n = paramInt4;
    this.o = paramInt5;
    this.p = paramInt6;
    this.X = paramString5;
    this.Y = paramString6;
    this.Z = paramString7;
    this.jdField_c_of_type_Long = paramLong;
    this.q = paramInt7;
    this.jdField_a_of_type_Int = 14;
  }
  
  public azvm(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new azvq(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new azvr(this);
    this.jdField_a_of_type_JavaLangString = "video";
    this.S = paramString1;
    this.T = paramString2;
    if (paramBoolean) {}
    for (;;)
    {
      this.k = i;
      this.jdField_a_of_type_Int = 14;
      return;
      i = 0;
    }
  }
  
  private Intent a(JSONObject paramJSONObject)
  {
    long l1 = paramJSONObject.getLong("uin");
    String str1 = paramJSONObject.getString("ugcKey");
    Object localObject = paramJSONObject.getString("videoUrl");
    String str2 = paramJSONObject.getString("videoID");
    String str3 = paramJSONObject.getString("nickname");
    String str4 = paramJSONObject.getString("isTXVideo");
    int i = paramJSONObject.getInt("appid");
    paramJSONObject = new WeishiFeedInfo();
    paramJSONObject.userInfo = new WeishiUserInfo(l1, str3);
    paramJSONObject.feedCommInfo = new WeishiFeedCommInfo(i, str1, null, null, null);
    paramJSONObject.videoInfo = new VideoInfo();
    paramJSONObject.videoInfo.jdField_d_of_type_CooperationQzoneModelPictureUrl = new PictureUrl(this.S, this.n, this.o);
    paramJSONObject.videoInfo.jdField_d_of_type_CooperationQzoneModelVideoUrl = new VideoUrl((String)localObject);
    paramJSONObject.videoInfo.jdField_a_of_type_CooperationQzoneModelVideoUrl = new VideoUrl((String)localObject);
    paramJSONObject.videoInfo.jdField_a_of_type_CooperationQzoneModelVideoInfo$VideoRemark = new VideoInfo.VideoRemark();
    if ("0".equals(str4)) {}
    for (paramJSONObject.videoInfo.jdField_a_of_type_CooperationQzoneModelVideoInfo$VideoRemark.b = 0;; paramJSONObject.videoInfo.jdField_a_of_type_CooperationQzoneModelVideoInfo$VideoRemark.b = 1)
    {
      paramJSONObject.videoInfo.g = this.n;
      paramJSONObject.videoInfo.h = this.o;
      paramJSONObject.videoInfo.jdField_a_of_type_JavaLangString = str2;
      paramJSONObject.videoInfo.b = this.p;
      paramJSONObject.userInfo = new WeishiUserInfo(l1, str3);
      localObject = new ArrayList(1);
      ((ArrayList)localObject).add(paramJSONObject);
      paramJSONObject = new Intent(BaseApplicationImpl.getContext(), QzoneVerticalVideoDownloadActivity.class);
      paramJSONObject.putExtra("key_plugin_id", "qzone_vertical_video_plugin.apk");
      paramJSONObject.setFlags(268435456);
      paramJSONObject.putExtra("key_weishi_entrance_type", 2);
      paramJSONObject.putParcelableArrayListExtra("key_videolist", (ArrayList)localObject);
      paramJSONObject.putExtra("key_current_feeduin", String.valueOf(l1));
      paramJSONObject.putExtra("key_weishi_feeds_id", str1);
      paramJSONObject.putExtra("key_weishi_feed_appid", i);
      paramJSONObject.putExtra("key_weishi_entrance_type", 22);
      return paramJSONObject;
    }
  }
  
  private void a(Context paramContext)
  {
    if ((TextUtils.isEmpty(b())) || ((!b().startsWith("http://")) && (!b().startsWith("https://")))) {}
    do
    {
      do
      {
        return;
        Intent localIntent = new Intent(paramContext, PublicAccountBrowser.class);
        localIntent.putExtra("key_isReadModeEnabled", true);
        localIntent.putExtra("url", b());
        syb.a(localIntent, b());
        paramContext.startActivity(localIntent);
      } while (TextUtils.isEmpty(b()));
      paramContext = azqn.a(b());
    } while (TextUtils.isEmpty(paramContext));
    azmj.b(null, "CliOper", "", "", "0X8005F58", "0X8005F58", 0, 0, "", "", paramContext, "");
  }
  
  private void a(Context paramContext, View paramView)
  {
    if (this.k == 1)
    {
      if ((paramView instanceof AnyScaleTypeImageView)) {
        ((AnyScaleTypeImageView)paramView).setImageResource(2130839222);
      }
      if (this.jdField_a_of_type_Azvu == null) {
        this.jdField_a_of_type_Azvu = new azvu(this);
      }
      ThreadManager.post(new StructMsgItemVideo.3(this, paramContext, paramView), 8, null, true);
      return;
    }
    a(paramContext, this.T);
  }
  
  private void a(Context paramContext, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("file_send_path", paramString);
    localBundle.putInt("video_play_caller", 1);
    localBundle.putLong("message_click_start", System.currentTimeMillis());
    paramString = new Intent(paramContext, ShortVideoPlayActivity.class);
    paramString.putExtras(localBundle);
    paramContext.startActivity(paramString);
    if (!TextUtils.isEmpty(b()))
    {
      paramContext = azqn.a(b());
      if (!TextUtils.isEmpty(paramContext)) {
        azmj.b(null, "CliOper", "", "", "0X8005F57", "0X8005F57", 0, 0, "", "", paramContext, "");
      }
    }
  }
  
  private String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgUrl;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    if (a())
    {
      localBundle.putBoolean("is_public_account_video_msg", true);
      this.jdField_a_of_type_Boolean = true;
      this.aa = localBundle.getString("public_account_video_title");
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.hasFlag(4)) {}
    for (boolean bool1 = true; !this.jdField_a_of_type_Boolean; bool1 = false) {
      return b(paramContext, paramView, localBundle);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg instanceof StructMsgForGeneralShare))
    {
      if (localBundle.getString("VIDEO_PUB_ACCOUNT_UIN") == null) {
        break label262;
      }
      this.X = localBundle.getString("VIDEO_PUB_ACCOUNT_UIN");
      if (localBundle.getString("VIDEO_PUB_ACCOUNT_NAME") == null) {
        break label282;
      }
    }
    Object localObject1;
    label262:
    label282:
    for (this.Y = localBundle.getString("VIDEO_PUB_ACCOUNT_NAME");; this.Y = String.valueOf(((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceName))
    {
      this.ab = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceIcon;
      this.ac = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceName;
      this.ai = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceUrl;
      this.aj = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceThirdName;
      localObject1 = paramContext.getResources();
      if ((paramView == null) || (!(paramView instanceof RelativeLayout))) {
        break label302;
      }
      if (paramView.getTag(2131377079) != null)
      {
        paramContext = paramView.getTag(2131377079);
        if ((paramContext instanceof azvt))
        {
          paramContext = (azvt)paramContext;
          if (QLog.isColorLevel()) {
            QLog.d("structmsg.StructMsgItemVideo", 2, "createView(): 复用Holder!!");
          }
        }
      }
      return null;
      this.X = String.valueOf(((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).source_puin);
      break;
    }
    label302:
    paramView = new RelativeLayout(paramContext);
    paramBundle = new PAVideoView(paramContext);
    paramBundle.setId(2131377079);
    paramBundle.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramBundle.setContentDescription(((Resources)localObject1).getText(2131720338));
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    int i;
    Object localObject3;
    label547:
    Object localObject4;
    label628:
    int j;
    int i1;
    if (bool1)
    {
      paramBundle.setRadius(15.0F);
      paramBundle.b(true);
      paramBundle.d(true);
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null)) {
        paramBundle.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.isSend();
      }
      if (this.n >= this.o)
      {
        paramBundle.f = PAVideoView.e;
        paramBundle.jdField_c_of_type_Boolean = true;
        paramBundle.i = true;
        paramView.addView(paramBundle, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new ImageView(paramContext);
        ((ImageView)localObject2).setImageResource(2130842823);
        ((ImageView)localObject2).setVisibility(8);
        i = aekt.a(62.0F, (Resources)localObject1);
        if (bool1) {
          i = aekt.a(50.0F, (Resources)localObject1);
        }
        localObject3 = new RelativeLayout.LayoutParams(i, i);
        ((RelativeLayout.LayoutParams)localObject3).addRule(13);
        if (bool1)
        {
          i = aekt.a(10.0F, (Resources)localObject1) / 2;
          if (!paramBundle.jdField_d_of_type_Boolean) {
            break label1351;
          }
          ((RelativeLayout.LayoutParams)localObject3).rightMargin = i;
        }
        paramView.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        localObject3 = new LinearLayout(paramContext);
        ((LinearLayout)localObject3).setHorizontalGravity(0);
        localObject4 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131377079);
        ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131377079);
        ((RelativeLayout.LayoutParams)localObject4).addRule(8, 2131377079);
        if (!bool1) {
          break label1361;
        }
        i = aekt.a(7.0F, (Resources)localObject1);
        if (!bool1) {
          break label1429;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message == null) || (!this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.isSend())) {
          break label1374;
        }
        j = aekt.a(10.0F, (Resources)localObject1) + i;
        i1 = i;
      }
    }
    for (;;)
    {
      label680:
      ((LinearLayout)localObject3).setPadding(i1, i, j, i);
      paramView.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new TextView(paramContext);
      ((TextView)localObject4).setId(2131377078);
      ((TextView)localObject4).setTextColor(-1);
      ((TextView)localObject4).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject4).setSingleLine(true);
      label753:
      Object localObject5;
      if (bool1)
      {
        ((TextView)localObject4).setTextSize(1, 14.0F);
        localObject5 = new LinearLayout.LayoutParams(0, -2);
        ((LinearLayout.LayoutParams)localObject5).weight = 1.0F;
        ((LinearLayout.LayoutParams)localObject5).rightMargin = aekt.a(7.0F, (Resources)localObject1);
        ((LinearLayout)localObject3).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
        localObject1 = new TextView(paramContext);
        ((TextView)localObject1).setSingleLine(true);
        if (!bool1) {
          break label1406;
        }
        ((TextView)localObject1).setTextSize(1, 12.0F);
        label823:
        ((TextView)localObject1).setTextColor(-1);
        localObject5 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject5).gravity = 85;
        ((LinearLayout.LayoutParams)localObject5).weight = 0.0F;
        ((LinearLayout)localObject3).addView((View)localObject1, (ViewGroup.LayoutParams)localObject5);
        localObject5 = new azvt();
        ((azvt)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView = paramBundle;
        ((azvt)localObject5).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject4);
        ((azvt)localObject5).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
        ((azvt)localObject5).b = ((TextView)localObject1);
        ((azvt)localObject5).jdField_a_of_type_AndroidViewView = ((View)localObject3);
        paramView.setTag(2131377079, localObject5);
        paramView.setTag(this);
        ((azvt)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.a(this, (azvt)localObject5);
        boolean bool2 = azqe.a().a(paramContext, 3, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.uinType);
        if (QLog.isColorLevel()) {
          QLog.d("structmsg.StructMsgItemVideo", 2, "createView(): convertView=" + paramView + ", args = " + localBundle.toString() + "\n, hasHeadIcon = " + bool1 + ", uniseq=" + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.uniseq + "\n, autoPlay = " + bool2 + ", vid = " + this.U);
        }
        if ((bool2) && (this.r != 4)) {
          break label1418;
        }
        ((azvt)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.d();
      }
      for (;;)
      {
        if (this.m > 0) {
          ((azvt)localObject5).b.setText(ShortVideoUtils.a(this.m * 1000));
        }
        if (!TextUtils.isEmpty(this.ak)) {
          paramView.setTag(2131377085, this.ak);
        }
        paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
        {
          paramView.setOnLongClickListener((View.OnLongClickListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
          paramView.setOnTouchListener((View.OnTouchListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
        }
        return paramView;
        paramBundle.i = false;
        paramBundle.jdField_c_of_type_Boolean = false;
        localObject3 = ShortVideoUtils.a(this.n, this.o);
        ((RelativeLayout.LayoutParams)localObject2).width = localObject3[0];
        ((RelativeLayout.LayoutParams)localObject2).height = localObject3[1];
        break;
        if (!this.jdField_c_of_type_Boolean) {
          paramBundle.setRadiusTop(5.0F);
        }
        for (;;)
        {
          paramBundle.i = true;
          paramBundle.jdField_c_of_type_Boolean = false;
          paramBundle.b(true);
          paramBundle.d(false);
          if (this.n >= this.o) {
            break label1270;
          }
          paramBundle.f = PAVideoView.jdField_d_of_type_Int;
          break;
          paramBundle.setRadius(5.0F);
        }
        label1270:
        if (this.n > this.o)
        {
          paramBundle.f = PAVideoView.jdField_c_of_type_Int;
          break;
        }
        if ((this.n == this.o) && (this.n != 0) && (this.o != 0))
        {
          if (bool1)
          {
            paramBundle.f = PAVideoView.e;
            break;
          }
          paramBundle.f = PAVideoView.jdField_d_of_type_Int;
          break;
        }
        paramBundle.f = PAVideoView.jdField_c_of_type_Int;
        break;
        label1351:
        ((RelativeLayout.LayoutParams)localObject3).leftMargin = i;
        break label547;
        label1361:
        i = aekt.a(12.0F, (Resources)localObject1);
        break label628;
        label1374:
        i1 = aekt.a(10.0F, (Resources)localObject1) + i;
        j = i;
        break label680;
        ((TextView)localObject4).setTextSize(1, 19.0F);
        break label753;
        label1406:
        ((TextView)localObject1).setTextSize(1, 14.0F);
        break label823;
        label1418:
        ((azvt)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.f();
      }
      label1429:
      j = i;
      i1 = i;
    }
  }
  
  public String a()
  {
    return "video";
  }
  
  protected void a(Context paramContext, StructMsgForGeneralShare paramStructMsgForGeneralShare, long paramLong)
  {
    if ((paramContext == null) || (paramStructMsgForGeneralShare == null)) {}
    label156:
    label834:
    label858:
    do
    {
      return;
      Bundle localBundle;
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramStructMsgForGeneralShare.currentAccountUin);
        if ((rlb.a(paramContext)) || ((localQQAppInterface != null) && (localQQAppInterface.c())))
        {
          QQToast.a(paramContext, 2131696351, 1).b(paramContext.getResources().getDimensionPixelSize(2131298914));
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("structmsg.StructMsgItemVideo", 2, "enterFullScreenActivity():", localException);
          }
          localObject = null;
        }
        if (!TextUtils.isEmpty(paramStructMsgForGeneralShare.mQzoneExtraMsg))
        {
          a((QQAppInterface)localObject, paramContext, paramStructMsgForGeneralShare.mQzoneExtraMsg);
          return;
        }
        localBundle = new Bundle();
        localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", this.X);
        if (this.r <= 1) {
          break label834;
        }
      }
      localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.aj);
      localBundle.putString("VIDEO_H5_URL", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgUrl);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgUrl)) {
        localBundle.putString("RED_PACKET_ID", Uri.parse(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgUrl).getQueryParameter("redpackid"));
      }
      if ((!TextUtils.isEmpty(paramStructMsgForGeneralShare.mCreateTime)) && (paramStructMsgForGeneralShare.mCreateTime.indexOf(" ") != -1)) {}
      for (Object localObject = paramStructMsgForGeneralShare.mCreateTime.substring(0, paramStructMsgForGeneralShare.mCreateTime.indexOf(" "));; localObject = paramStructMsgForGeneralShare.mCreateTime)
      {
        localBundle.putString("VIDEO_CREATE_TIME", (String)localObject);
        localBundle.putString("VIDEO_TIME", String.valueOf(this.p));
        localBundle.putString("VIDEO_WIDTH", String.valueOf(this.n));
        localBundle.putString("VIDEO_HEIGHT", String.valueOf(this.o));
        localBundle.putString("VIDEO_VID", this.V);
        localBundle.putString("VIDEO_COVER", this.S);
        localBundle.putLong("VIDEO_PLAY_POSITION", paramLong);
        localBundle.putString("VIDEO_ARTICLE_ID", this.Z);
        localBundle.putString("VIDEO_TITLE", this.aa);
        boolean bool1 = true;
        if ((this.r == 2) || (this.r == 3)) {
          bool1 = false;
        }
        localBundle.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool1);
        localBundle.putInt("VIDEO_ARTICLE_BUSITYPE", this.r);
        if (b())
        {
          localBundle.putInt("VIDEO_FEED_TYPE", this.q);
          localBundle.putLong("VIDEO_FEED_ID", this.jdField_c_of_type_Long);
        }
        if (!bool1)
        {
          localBundle.putString("VIDEO_THIRD_ICON", this.ab);
          localBundle.putString("VIDEO_THIRD_NAME", this.ac);
          localBundle.putString("VIDEO_THIRD_ACTION", this.ai);
          if (this.r == 2)
          {
            osf.a();
            localBundle.putString("VIDEO_THIRD_URL", osf.a(this.V));
          }
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null)) {
          azmj.b(null, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.frienduin, "0X8006830", "0X8006830", 0, 0, this.U, "" + this.r, "" + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId, "");
        }
        localBundle.putByteArray("STRUCT_MSG_BYTES", paramStructMsgForGeneralShare.getBytes());
        localBundle.putInt("VIDEO_AIO_UIN_TYPE", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.uinType);
        localBundle.putBoolean("VIDEO_FROM_AIO", true);
        localBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 1);
        localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 1);
        localBundle.putInt("VIDEO_FROM_TYPE", 0);
        localObject = Aladdin.getConfig(261);
        if (((paramStructMsgForGeneralShare.mSourceName == null) || (!paramStructMsgForGeneralShare.mSourceName.equals(alpo.a(2131717441)))) && (((AladdinConfig)localObject).getIntegerFromString("enable_floating_layer_style", 0) == 1) && (bjxq.a(paramContext, this.Z, localBundle))) {
          break;
        }
        bool1 = false;
        try
        {
          boolean bool2 = otp.a(localBundle.getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(localBundle.getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_TIME")).intValue());
          bool1 = bool2;
        }
        catch (Exception paramStructMsgForGeneralShare)
        {
          break label788;
        }
        if (!bool1) {
          break label858;
        }
        paramStructMsgForGeneralShare = new Intent();
        paramStructMsgForGeneralShare.putExtras(localBundle);
        MultiVideoFragment.a(paramContext, paramStructMsgForGeneralShare);
        if (!(paramContext instanceof Activity)) {
          break;
        }
        ((Activity)paramContext).overridePendingTransition(2130772036, 2130772038);
        return;
        localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.Y);
        break label156;
      }
      paramStructMsgForGeneralShare = new Intent(paramContext, VideoFeedsPlayActivity.class);
      paramStructMsgForGeneralShare.addFlags(536870912);
      paramStructMsgForGeneralShare.putExtras(localBundle);
    } while (!(paramContext instanceof Activity));
    label788:
    ((Activity)paramContext).startActivityForResult(paramStructMsgForGeneralShare, 13005);
    ((Activity)paramContext).overridePendingTransition(2130772036, 2130772038);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    try
    {
      paramQQAppInterface = new JSONObject(paramString);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.optInt("enterVideoLayer") == 1))
      {
        QLog.d("structmsg.StructMsgItemVideo", 2, "[enterQzoneFullScreen] rays, qzShareMsg=" + paramQQAppInterface.toString());
        paramQQAppInterface = a(paramQQAppInterface);
        BaseApplicationImpl.getContext().startActivity(paramQQAppInterface);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("structmsg.StructMsgItemVideo", 1, "[enterQzoneFullScreen] rays", paramQQAppInterface);
    }
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.S = paramObjectInput.readUTF();
    this.T = paramObjectInput.readUTF();
    String str = paramObjectInput.readUTF();
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      this.k = Integer.parseInt(str);
      if (this.jdField_a_of_type_Int >= 7)
      {
        this.U = paramObjectInput.readUTF();
        this.V = paramObjectInput.readUTF();
        this.m = paramObjectInput.readInt();
        this.n = paramObjectInput.readInt();
        this.o = paramObjectInput.readInt();
        this.p = paramObjectInput.readInt();
        this.W = paramObjectInput.readUTF();
        this.r = paramObjectInput.readInt();
      }
      if (this.jdField_a_of_type_Int >= 8) {
        this.Z = paramObjectInput.readUTF();
      }
      if (this.jdField_a_of_type_Int >= 9)
      {
        this.ak = paramObjectInput.readUTF();
        this.jdField_d_of_type_Boolean = "1".equals(paramObjectInput.readUTF());
      }
      if (this.jdField_a_of_type_Int >= 10) {
        this.l = paramObjectInput.readInt();
      }
      if (this.jdField_a_of_type_Int >= 11)
      {
        this.al = paramObjectInput.readUTF();
        this.am = paramObjectInput.readUTF();
        this.an = paramObjectInput.readUTF();
      }
      if ((this.jdField_a_of_type_Int >= 12) && (b()))
      {
        this.q = paramObjectInput.readInt();
        this.jdField_c_of_type_Long = paramObjectInput.readLong();
      }
      if (this.jdField_a_of_type_Int >= 13)
      {
        this.q = paramObjectInput.readUTF();
        this.B = paramObjectInput.readUTF();
        this.jdField_c_of_type_Int = paramObjectInput.readInt();
        this.r = paramObjectInput.readUTF();
        this.s = paramObjectInput.readUTF();
        this.t = paramObjectInput.readUTF();
        this.u = paramObjectInput.readUTF();
        this.v = paramObjectInput.readUTF();
        this.jdField_d_of_type_Int = paramObjectInput.readInt();
        this.w = paramObjectInput.readUTF();
        this.x = paramObjectInput.readUTF();
        this.y = paramObjectInput.readUTF();
        this.z = paramObjectInput.readUTF();
        this.A = paramObjectInput.readUTF();
        this.e = paramObjectInput.readInt();
        this.C = paramObjectInput.readUTF();
        this.D = paramObjectInput.readUTF();
        this.E = paramObjectInput.readUTF();
        this.F = paramObjectInput.readUTF();
        this.G = paramObjectInput.readUTF();
        this.H = paramObjectInput.readUTF();
        this.I = paramObjectInput.readUTF();
        this.J = paramObjectInput.readUTF();
        this.N = paramObjectInput.readUTF();
        this.O = paramObjectInput.readUTF();
      }
      if (this.jdField_a_of_type_Int >= 14) {
        this.f = paramObjectInput.readInt();
      }
      if (QLog.isColorLevel())
      {
        paramObjectInput = new StringBuilder();
        paramObjectInput.append("readExternal[:").append("\n");
        paramObjectInput.append("mVersion:").append(this.jdField_a_of_type_Int).append("\n");
        paramObjectInput.append("imgUrl:").append(this.S).append("\n");
        paramObjectInput.append("videoUrl:").append(this.T).append("\n");
        paramObjectInput.append("vInfo:").append(this.U).append("\n");
        paramObjectInput.append("tInfo:").append(this.V).append("\n");
        paramObjectInput.append("previewVideoTime:").append(this.m).append("\n");
        paramObjectInput.append("previewVideoWidth:").append(this.n).append("\n");
        paramObjectInput.append("previewVideoHeight:").append(this.o).append("\n");
        paramObjectInput.append("type:").append(this.r).append("\n");
        paramObjectInput.append("articleID").append(this.Z).append("\n");
        paramObjectInput.append("jumpUrl:").append(this.ak).append("\n");
        paramObjectInput.append("jump2Web:").append(this.jdField_d_of_type_Boolean).append("\n");
        paramObjectInput.append("previewStartPosi:").append(this.l).append("\n");
        if ((this.jdField_a_of_type_Int >= 12) && (b()))
        {
          paramObjectInput.append("feedId:").append(this.jdField_c_of_type_Long).append("\n");
          paramObjectInput.append("feedType:").append(this.q).append("\n");
        }
        paramObjectInput.append("]:").append("\n");
        QLog.d("structmsg.StructMsgItemVideo", 2, paramObjectInput.toString());
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        this.k = 0;
      }
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.S != null)
    {
      str = this.S;
      paramObjectOutput.writeUTF(str);
      if (this.T == null) {
        break label854;
      }
      str = this.T;
      label36:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeUTF(this.k + "");
      if (this.jdField_a_of_type_Int >= 7)
      {
        if (this.U == null) {
          break label860;
        }
        str = this.U;
        label92:
        paramObjectOutput.writeUTF(str);
        if (this.V == null) {
          break label866;
        }
        str = this.V;
        label111:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.m);
        paramObjectOutput.writeInt(this.n);
        paramObjectOutput.writeInt(this.o);
        paramObjectOutput.writeInt(this.p);
        if (this.W == null) {
          break label872;
        }
        str = this.W;
        label170:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.r);
      }
      if (this.jdField_a_of_type_Int >= 8)
      {
        if (this.Z == null) {
          break label878;
        }
        str = this.Z;
        label208:
        paramObjectOutput.writeUTF(str);
      }
      if (this.jdField_a_of_type_Int >= 9)
      {
        if (this.ak == null) {
          break label884;
        }
        str = this.ak;
        label236:
        paramObjectOutput.writeUTF(str);
        if (!this.jdField_d_of_type_Boolean) {
          break label890;
        }
        str = "1";
        label254:
        paramObjectOutput.writeUTF(str);
      }
      if (this.jdField_a_of_type_Int >= 10) {
        paramObjectOutput.writeInt(this.l);
      }
      if (this.jdField_a_of_type_Int >= 11)
      {
        if (this.al == null) {
          break label896;
        }
        str = this.al;
        label301:
        paramObjectOutput.writeUTF(str);
        if (this.am == null) {
          break label902;
        }
        str = this.am;
        label320:
        paramObjectOutput.writeUTF(str);
        if (this.an == null) {
          break label908;
        }
        str = this.an;
        label339:
        paramObjectOutput.writeUTF(str);
      }
      if ((this.jdField_a_of_type_Int >= 12) && (b()))
      {
        paramObjectOutput.writeInt(this.q);
        paramObjectOutput.writeLong(this.jdField_c_of_type_Long);
      }
      if (this.jdField_a_of_type_Int >= 13)
      {
        if (this.q == null) {
          break label914;
        }
        str = this.q;
        label403:
        paramObjectOutput.writeUTF(str);
        if (this.B == null) {
          break label920;
        }
        str = this.B;
        label422:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.jdField_c_of_type_Int);
        if (this.r != null) {
          break label926;
        }
        str = "0";
        label449:
        paramObjectOutput.writeUTF(str);
        if (this.s != null) {
          break label934;
        }
        str = "0";
        label466:
        paramObjectOutput.writeUTF(str);
        if (this.t != null) {
          break label942;
        }
        str = "";
        label483:
        paramObjectOutput.writeUTF(str);
        if (this.u != null) {
          break label950;
        }
        str = "";
        label500:
        paramObjectOutput.writeUTF(str);
        if (this.v != null) {
          break label958;
        }
        str = "";
        label517:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.jdField_d_of_type_Int);
        if (this.w != null) {
          break label966;
        }
        str = "";
        label544:
        paramObjectOutput.writeUTF(str);
        if (this.x != null) {
          break label974;
        }
        str = "";
        label561:
        paramObjectOutput.writeUTF(str);
        if (this.y != null) {
          break label982;
        }
        str = "";
        label578:
        paramObjectOutput.writeUTF(str);
        if (this.z != null) {
          break label990;
        }
        str = "";
        label595:
        paramObjectOutput.writeUTF(str);
        if (this.A != null) {
          break label998;
        }
        str = "";
        label612:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.e);
        if (this.C != null) {
          break label1006;
        }
        str = "";
        label639:
        paramObjectOutput.writeUTF(str);
        if (this.D != null) {
          break label1014;
        }
        str = "";
        label656:
        paramObjectOutput.writeUTF(str);
        if (this.E != null) {
          break label1022;
        }
        str = "";
        label673:
        paramObjectOutput.writeUTF(str);
        if (this.F != null) {
          break label1030;
        }
        str = "";
        label690:
        paramObjectOutput.writeUTF(str);
        if (this.G != null) {
          break label1038;
        }
        str = "";
        label707:
        paramObjectOutput.writeUTF(str);
        if (this.H != null) {
          break label1046;
        }
        str = "";
        label724:
        paramObjectOutput.writeUTF(str);
        if (this.I != null) {
          break label1054;
        }
        str = "";
        label741:
        paramObjectOutput.writeUTF(str);
        if (this.J != null) {
          break label1062;
        }
        str = "";
        label758:
        paramObjectOutput.writeUTF(str);
        if (this.N != null) {
          break label1070;
        }
        str = "";
        label775:
        paramObjectOutput.writeUTF(str);
        if (this.O != null) {
          break label1078;
        }
      }
    }
    label896:
    label902:
    label908:
    label914:
    label920:
    label926:
    label934:
    label942:
    label1078:
    for (String str = "";; str = this.O)
    {
      paramObjectOutput.writeUTF(str);
      if (this.jdField_a_of_type_Int >= 14) {
        paramObjectOutput.writeInt(this.f);
      }
      if (this.jdField_a_of_type_Int >= 15)
      {
        paramObjectOutput.writeInt(this.g);
        paramObjectOutput.writeInt(this.h);
      }
      return;
      str = "";
      break;
      label854:
      str = "";
      break label36;
      label860:
      str = "";
      break label92;
      label866:
      str = "";
      break label111;
      label872:
      str = "";
      break label170;
      label878:
      str = "";
      break label208;
      label884:
      str = "";
      break label236;
      label890:
      str = "0";
      break label254;
      str = "";
      break label301;
      str = "";
      break label320;
      str = "";
      break label339;
      str = "";
      break label403;
      str = "";
      break label422;
      str = this.r;
      break label449;
      str = this.s;
      break label466;
      str = this.t;
      break label483;
      label950:
      str = this.u;
      break label500;
      label958:
      str = this.v;
      break label517;
      label966:
      str = this.w;
      break label544;
      label974:
      str = this.x;
      break label561;
      label982:
      str = this.y;
      break label578;
      label990:
      str = this.z;
      break label595;
      label998:
      str = this.A;
      break label612;
      label1006:
      str = this.C;
      break label639;
      label1014:
      str = this.D;
      break label656;
      label1022:
      str = this.E;
      break label673;
      str = this.F;
      break label690;
      str = this.G;
      break label707;
      str = this.H;
      break label724;
      str = this.I;
      break label741;
      str = this.J;
      break label758;
      str = this.N;
      break label775;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "video");
    if (!TextUtils.isEmpty(this.S)) {
      paramXmlSerializer.attribute(null, "cover", this.S);
    }
    if (!TextUtils.isEmpty(this.T)) {
      paramXmlSerializer.attribute(null, "src", this.T);
    }
    if (!TextUtils.isEmpty(this.U)) {
      paramXmlSerializer.attribute(null, "vInfo", this.U);
    }
    if (!TextUtils.isEmpty(this.V)) {
      paramXmlSerializer.attribute(null, "tInfo", this.V);
    }
    paramXmlSerializer.attribute(null, "preStartPosi", String.valueOf(this.l));
    paramXmlSerializer.attribute(null, "preTime", String.valueOf(this.m));
    paramXmlSerializer.attribute(null, "preWidth", String.valueOf(this.n));
    paramXmlSerializer.attribute(null, "preHeight", String.valueOf(this.o));
    paramXmlSerializer.attribute(null, "fullTime", String.valueOf(this.p));
    if (!TextUtils.isEmpty(this.W)) {
      paramXmlSerializer.attribute(null, "summary", this.W);
    }
    paramXmlSerializer.attribute(null, "busiType", String.valueOf(this.r));
    if (!TextUtils.isEmpty(this.Z)) {
      paramXmlSerializer.attribute(null, "aID", this.Z);
    }
    if (this.k == 1) {
      paramXmlSerializer.attribute(null, "load", this.k + "");
    }
    if (!TextUtils.isEmpty(this.ak)) {
      paramXmlSerializer.attribute(null, "jumpUrl", this.ak);
    }
    if (this.jdField_d_of_type_Boolean) {}
    for (String str = "1";; str = "0")
    {
      paramXmlSerializer.attribute(null, "isJump2Web", str);
      if (!TextUtils.isEmpty(this.al)) {
        paramXmlSerializer.attribute(null, "apurl", this.al);
      }
      if (!TextUtils.isEmpty(this.am)) {
        paramXmlSerializer.attribute(null, "rl", this.am);
      }
      if (!TextUtils.isEmpty(this.an)) {
        paramXmlSerializer.attribute(null, "disType", this.an);
      }
      if (this.jdField_c_of_type_Long != 0L) {
        paramXmlSerializer.attribute(null, "feedId", String.valueOf(this.jdField_c_of_type_Long));
      }
      if (this.q != 0) {
        paramXmlSerializer.attribute(null, "feedType", String.valueOf(this.q));
      }
      if (this.jdField_c_of_type_Int != 0) {
        paramXmlSerializer.attribute(null, "action_type", String.valueOf(this.jdField_c_of_type_Int));
      }
      if (!TextUtils.isEmpty(this.r)) {
        paramXmlSerializer.attribute(null, "advertiser_id", this.r);
      }
      if (!TextUtils.isEmpty(this.s)) {
        paramXmlSerializer.attribute(null, "aid", this.s);
      }
      if (!TextUtils.isEmpty(this.t)) {
        paramXmlSerializer.attribute(null, "app_download_schema", this.t);
      }
      if (!TextUtils.isEmpty(this.u)) {
        paramXmlSerializer.attribute(null, "canvas_json", this.u);
      }
      if (!TextUtils.isEmpty(this.v)) {
        paramXmlSerializer.attribute(null, "customized_invoke_url", this.v);
      }
      if (this.jdField_d_of_type_Int != 0) {
        paramXmlSerializer.attribute(null, "dest_type", String.valueOf(this.jdField_d_of_type_Int));
      }
      if (!TextUtils.isEmpty(this.w)) {
        paramXmlSerializer.attribute(null, "effect_url", this.w);
      }
      if (!TextUtils.isEmpty(this.x)) {
        paramXmlSerializer.attribute(null, "landing_page", this.x);
      }
      if (!TextUtils.isEmpty(this.y)) {
        paramXmlSerializer.attribute(null, "landing_page_report_url", this.y);
      }
      if (!TextUtils.isEmpty(this.z)) {
        paramXmlSerializer.attribute(null, "noco_id", this.z);
      }
      if (!TextUtils.isEmpty(this.A)) {
        paramXmlSerializer.attribute(null, "product_id", this.A);
      }
      if (!TextUtils.isEmpty(this.q)) {
        paramXmlSerializer.attribute(null, "apurl", this.q);
      }
      if (this.e != 0) {
        paramXmlSerializer.attribute(null, "product_type", String.valueOf(this.e));
      }
      if (this.f != 0) {
        paramXmlSerializer.attribute(null, "mini_program_type", String.valueOf(this.f));
      }
      if (!TextUtils.isEmpty(this.B)) {
        paramXmlSerializer.attribute(null, "rl", this.B);
      }
      if (!TextUtils.isEmpty(this.C)) {
        paramXmlSerializer.attribute(null, "subordinate_product_id", this.C);
      }
      if (!TextUtils.isEmpty(this.D)) {
        paramXmlSerializer.attribute(null, "traceid", this.D);
      }
      if (!TextUtils.isEmpty(this.E)) {
        paramXmlSerializer.attribute(null, "via", this.E);
      }
      if (!TextUtils.isEmpty(this.F)) {
        paramXmlSerializer.attribute(null, "video_url", this.F);
      }
      if (!TextUtils.isEmpty(this.G)) {
        paramXmlSerializer.attribute(null, "appname", this.G);
      }
      if (!TextUtils.isEmpty(this.H)) {
        paramXmlSerializer.attribute(null, "customized_invoke_url", this.H);
      }
      if (!TextUtils.isEmpty(this.I)) {
        paramXmlSerializer.attribute(null, "pkg_name", this.I);
      }
      if (!TextUtils.isEmpty(this.J)) {
        paramXmlSerializer.attribute(null, "pkgurl", this.J);
      }
      if (!TextUtils.isEmpty(this.N)) {
        paramXmlSerializer.attribute(null, "corporate_image_name", this.N);
      }
      if (!TextUtils.isEmpty(this.O)) {
        paramXmlSerializer.attribute(null, "corporate_logo", this.O);
      }
      if (this.g != 0) {
        paramXmlSerializer.attribute(null, "tab_id", String.valueOf(this.g));
      }
      if (this.h != 0) {
        paramXmlSerializer.attribute(null, "tab_id", String.valueOf(this.h));
      }
      paramXmlSerializer.endTag(null, "video");
      return;
    }
  }
  
  public boolean a()
  {
    return (this.r >= 1) && (this.r <= 100);
  }
  
  public boolean a(azsa paramazsa)
  {
    if (paramazsa == null) {}
    for (;;)
    {
      return true;
      this.S = paramazsa.a("cover");
      this.T = paramazsa.a("src");
      String str1 = paramazsa.a("load");
      this.U = paramazsa.a("vInfo");
      this.V = paramazsa.a("tInfo");
      String str2 = paramazsa.a("preTime");
      if (str2 != null) {}
      try
      {
        this.m = Integer.valueOf(str2).intValue();
        label81:
        str2 = paramazsa.a("preWidth");
        if (str2 == null) {}
      }
      catch (Exception localNumberFormatException4)
      {
        try
        {
          this.n = Integer.valueOf(str2).intValue();
          label104:
          str2 = paramazsa.a("preHeight");
          if (str2 != null) {}
          try
          {
            this.o = Integer.valueOf(str2).intValue();
            label127:
            str2 = paramazsa.a("fullTime");
            if (str2 != null) {}
            try
            {
              this.p = Integer.valueOf(str2).intValue();
              label150:
              this.W = paramazsa.a("summary");
              if (!TextUtils.isEmpty(str1)) {}
              try
              {
                this.k = Integer.parseInt(str1);
                label176:
                str1 = paramazsa.a("busiType");
                if (TextUtils.isEmpty(str1)) {}
              }
              catch (RuntimeException localNumberFormatException4)
              {
                try
                {
                  this.r = Integer.parseInt(str1);
                  label199:
                  this.Z = paramazsa.a("aID");
                  this.ak = paramazsa.a("jumpUrl");
                  this.jdField_d_of_type_Boolean = "1".equals(paramazsa.a("isJump2Web"));
                  str1 = paramazsa.a("preStartPosi");
                  if (!TextUtils.isEmpty(str1)) {}
                  try
                  {
                    this.l = Integer.valueOf(str1).intValue();
                    this.al = paramazsa.a("apurl");
                    this.am = paramazsa.a("rl");
                    this.an = paramazsa.a("disType");
                    str1 = paramazsa.a("feedId");
                    if (TextUtils.isEmpty(str1)) {}
                  }
                  catch (Exception localNumberFormatException4)
                  {
                    try
                    {
                      this.jdField_c_of_type_Long = Long.parseLong(str1);
                      str1 = paramazsa.a("feedType");
                      if (TextUtils.isEmpty(str1)) {}
                    }
                    catch (Exception localNumberFormatException4)
                    {
                      try
                      {
                        this.q = Integer.parseInt(str1);
                        if (this.jdField_a_of_type_Int >= 13)
                        {
                          str1 = paramazsa.a("action_type");
                          if (TextUtils.isEmpty(str1)) {}
                        }
                      }
                      catch (Exception localNumberFormatException4)
                      {
                        try
                        {
                          this.jdField_c_of_type_Int = Integer.parseInt(str1);
                          str1 = paramazsa.a("dest_type");
                          if (TextUtils.isEmpty(str1)) {}
                        }
                        catch (NumberFormatException localNumberFormatException4)
                        {
                          try
                          {
                            this.jdField_d_of_type_Int = Integer.parseInt(str1);
                            str1 = paramazsa.a("product_type");
                            if (TextUtils.isEmpty(str1)) {}
                          }
                          catch (NumberFormatException localNumberFormatException4)
                          {
                            try
                            {
                              this.e = Integer.parseInt(str1);
                              this.r = paramazsa.a("advertiser_id");
                              this.s = paramazsa.a("aid");
                              this.t = paramazsa.a("app_download_schema");
                              this.u = paramazsa.a("canvas_json");
                              this.v = paramazsa.a("customized_invoke_url");
                              this.w = paramazsa.a("effect_url");
                              this.x = paramazsa.a("landing_page");
                              this.y = paramazsa.a("landing_page_report_url");
                              this.z = paramazsa.a("noco_id");
                              this.A = paramazsa.a("product_id");
                              this.C = paramazsa.a("subordinate_product_id");
                              this.D = paramazsa.a("traceid");
                              this.E = paramazsa.a("via");
                              this.F = paramazsa.a("video_url");
                              this.G = paramazsa.a("appname");
                              this.H = paramazsa.a("customized_invoke_url");
                              this.I = paramazsa.a("pkg_name");
                              this.J = paramazsa.a("pkgurl");
                              this.B = paramazsa.a("rl");
                              this.q = paramazsa.a("apurl");
                              this.N = paramazsa.a("corporate_image_name");
                              this.O = paramazsa.a("corporate_logo");
                              if (this.jdField_a_of_type_Int >= 14)
                              {
                                str1 = paramazsa.a("mini_program_type");
                                if (TextUtils.isEmpty(str1)) {}
                              }
                            }
                            catch (NumberFormatException localNumberFormatException4)
                            {
                              try
                              {
                                this.f = Integer.parseInt(str1);
                                if (this.jdField_a_of_type_Int < 15) {
                                  continue;
                                }
                                paramazsa = paramazsa.a;
                                if (paramazsa == null) {
                                  continue;
                                }
                                str1 = paramazsa.a("tab_id");
                                if (bdje.a(str1)) {}
                              }
                              catch (NumberFormatException localNumberFormatException4)
                              {
                                try
                                {
                                  for (;;)
                                  {
                                    for (;;)
                                    {
                                      this.g = Integer.parseInt(str1);
                                      paramazsa = paramazsa.a("is_hidden");
                                      if (bdje.a(paramazsa)) {
                                        break;
                                      }
                                      try
                                      {
                                        this.h = Integer.parseInt(paramazsa);
                                        return true;
                                      }
                                      catch (NumberFormatException paramazsa)
                                      {
                                        this.h = 0;
                                        return true;
                                      }
                                      localException10 = localException10;
                                      try
                                      {
                                        this.m = ((int)Float.valueOf(str2).floatValue());
                                        if (!QLog.isColorLevel()) {
                                          break label81;
                                        }
                                        QLog.d("structmsg.StructMsgItemVideo", 2, "fromXml parse previewVideoTimeStr: previewVideoTime = " + this.m);
                                      }
                                      catch (Exception localException5) {}
                                    }
                                    break label81;
                                    localRuntimeException = localRuntimeException;
                                    this.k = 0;
                                    break label176;
                                    localException6 = localException6;
                                    try
                                    {
                                      this.l = ((int)Float.valueOf(localRuntimeException).floatValue());
                                      if (!QLog.isColorLevel()) {
                                        continue;
                                      }
                                      QLog.d("structmsg.StructMsgItemVideo", 2, "fromXml parse previewStartPosiStr: previewStartPosi = " + this.l);
                                    }
                                    catch (Exception localException1) {}
                                    continue;
                                    localException2 = localException2;
                                    if (QLog.isColorLevel())
                                    {
                                      QLog.d("structmsg.StructMsgItemVideo", 2, "error while feedIdStr to feedId Long!");
                                      continue;
                                      localException3 = localException3;
                                      if (QLog.isColorLevel())
                                      {
                                        QLog.d("structmsg.StructMsgItemVideo", 2, "error while parse feedTypeStr to feedType int!");
                                        continue;
                                        localNumberFormatException1 = localNumberFormatException1;
                                        this.jdField_c_of_type_Int = 0;
                                        continue;
                                        localNumberFormatException2 = localNumberFormatException2;
                                        this.jdField_d_of_type_Int = 0;
                                        continue;
                                        localNumberFormatException3 = localNumberFormatException3;
                                        this.e = 0;
                                      }
                                    }
                                  }
                                  localNumberFormatException4 = localNumberFormatException4;
                                  this.f = 0;
                                }
                                catch (NumberFormatException localNumberFormatException5)
                                {
                                  for (;;)
                                  {
                                    this.g = 0;
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
                catch (Exception localException4)
                {
                  break label199;
                }
              }
            }
            catch (Exception localException7)
            {
              break label150;
            }
          }
          catch (Exception localException8)
          {
            break label127;
          }
        }
        catch (Exception localException9)
        {
          break label104;
        }
      }
    }
  }
  
  protected View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    boolean bool = false;
    Object localObject1 = paramContext.getResources();
    int i;
    int j;
    label113:
    Drawable localDrawable;
    if (paramBundle.getBoolean("has_cnr"))
    {
      i = aekt.a(12.0F, (Resources)localObject1);
      ((Resources)localObject1).getDisplayMetrics();
      j = paramBundle.getInt("v_height");
      Object localObject2;
      if ((paramView != null) && ((paramView instanceof TitledImageView)))
      {
        localObject2 = (TitledImageView)paramView;
        localObject1 = paramView;
        paramView = (View)localObject2;
      }
      for (;;)
      {
        paramView.setImageResource(2130844946);
        paramView.setTag(this);
        try
        {
          localObject2 = new azqp(-16777216, j, j, i);
          if (TextUtils.isEmpty(this.S))
          {
            paramView.setBackgroundDrawable((Drawable)localObject2);
            if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
            {
              paramView.setOnLongClickListener((View.OnLongClickListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
              paramView.setOnTouchListener((View.OnTouchListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
            }
            paramView.setOnClickListener(this.b);
            paramView.setOnClickListener(this.b);
            if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
            {
              paramView.setOnLongClickListener((View.OnLongClickListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
              paramView.setOnTouchListener((View.OnTouchListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
            }
            return localObject1;
            paramView = new TitledImageView(paramContext);
            paramView.setId(2131368083);
            paramView.setContentDescription(((Resources)localObject1).getString(2131694904));
            paramView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            paramView.setContentDescription(((Resources)localObject1).getText(2131720338));
            localObject1 = paramView;
            localObject2 = paramView;
            paramView = (View)localObject1;
            localObject1 = localObject2;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            localDrawable = null;
          }
        }
      }
    }
    for (;;)
    {
      URLDrawable localURLDrawable;
      try
      {
        localURLDrawable = URLDrawable.getDrawable(this.S, j, j, localDrawable, localDrawable);
        if (paramBundle.getBoolean("has_cnr")) {
          localURLDrawable.setDecodeHandler(new azvs(this, i, j, j));
        }
        if ((bame.b(this.S)) || (!baul.a(paramContext))) {
          break label402;
        }
        localURLDrawable.setAutoDownload(bool);
        if ((localURLDrawable == null) || (localURLDrawable.getStatus() != 1)) {
          break label379;
        }
        paramView.setBackgroundDrawable(localURLDrawable);
      }
      catch (Throwable paramContext)
      {
        paramView.setBackgroundDrawable(localDrawable);
      }
      break label113;
      label379:
      paramView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
      paramView.setBackgroundDrawable(localURLDrawable);
      break label113;
      i = 0;
      break;
      label402:
      bool = true;
    }
  }
  
  public boolean b()
  {
    return this.r == 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azvm
 * JD-Core Version:    0.7.0.1
 */