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

public class bdts
  extends bdol
{
  protected View.OnClickListener a;
  public bdua a;
  private URLDrawableDownListener.Adapter a;
  public boolean a;
  public String ac;
  public String ad;
  public String ae;
  public String af;
  public String ag;
  public String ah;
  public String ai;
  public String aj;
  public String ak;
  String al = "";
  String am = "";
  String as = "";
  String at = "";
  String au;
  String av;
  String aw;
  String ax;
  private View.OnClickListener b = new bdtt(this);
  public boolean b;
  public long c;
  public boolean c;
  boolean d;
  public int o;
  public int p;
  public int q;
  public int r;
  public int s;
  public int t;
  public int u;
  public int v;
  
  public bdts()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new bdtw(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bdtx(this);
    this.jdField_a_of_type_JavaLangString = "video";
    this.jdField_a_of_type_Int = 17;
  }
  
  public bdts(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString5, String paramString6, String paramString7, int paramInt7, long paramLong)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new bdtw(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bdtx(this);
    this.jdField_a_of_type_JavaLangString = "video";
    this.ac = paramString1;
    this.v = paramInt1;
    this.ae = paramString2;
    this.af = paramString3;
    this.ag = paramString4;
    this.q = paramInt2;
    this.p = paramInt3;
    this.r = paramInt4;
    this.s = paramInt5;
    this.t = paramInt6;
    this.ah = paramString5;
    this.ai = paramString6;
    this.aj = paramString7;
    this.jdField_c_of_type_Long = paramLong;
    this.u = paramInt7;
    this.jdField_a_of_type_Int = 17;
  }
  
  public bdts(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new bdtw(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bdtx(this);
    this.jdField_a_of_type_JavaLangString = "video";
    this.ac = paramString1;
    this.ad = paramString2;
    if (paramBoolean) {}
    for (;;)
    {
      this.o = i;
      this.jdField_a_of_type_Int = 17;
      return;
      i = 0;
    }
  }
  
  private Intent a(JSONObject paramJSONObject)
  {
    long l = paramJSONObject.getLong("uin");
    String str1 = paramJSONObject.getString("ugcKey");
    Object localObject = paramJSONObject.getString("videoUrl");
    String str2 = paramJSONObject.getString("videoID");
    String str3 = paramJSONObject.getString("nickname");
    String str4 = paramJSONObject.getString("isTXVideo");
    int i = paramJSONObject.getInt("appid");
    paramJSONObject = new WeishiFeedInfo();
    paramJSONObject.userInfo = new WeishiUserInfo(l, str3);
    paramJSONObject.feedCommInfo = new WeishiFeedCommInfo(i, str1, null, null, null);
    paramJSONObject.videoInfo = new VideoInfo();
    paramJSONObject.videoInfo.jdField_d_of_type_CooperationQzoneModelPictureUrl = new PictureUrl(this.ac, this.r, this.s);
    paramJSONObject.videoInfo.jdField_d_of_type_CooperationQzoneModelVideoUrl = new VideoUrl((String)localObject);
    paramJSONObject.videoInfo.jdField_a_of_type_CooperationQzoneModelVideoUrl = new VideoUrl((String)localObject);
    paramJSONObject.videoInfo.jdField_a_of_type_CooperationQzoneModelVideoInfo$VideoRemark = new VideoInfo.VideoRemark();
    if ("0".equals(str4)) {}
    for (paramJSONObject.videoInfo.jdField_a_of_type_CooperationQzoneModelVideoInfo$VideoRemark.b = 0;; paramJSONObject.videoInfo.jdField_a_of_type_CooperationQzoneModelVideoInfo$VideoRemark.b = 1)
    {
      paramJSONObject.videoInfo.g = this.r;
      paramJSONObject.videoInfo.h = this.s;
      paramJSONObject.videoInfo.jdField_a_of_type_JavaLangString = str2;
      paramJSONObject.videoInfo.b = this.t;
      paramJSONObject.userInfo = new WeishiUserInfo(l, str3);
      localObject = new ArrayList(1);
      ((ArrayList)localObject).add(paramJSONObject);
      paramJSONObject = new Intent(BaseApplicationImpl.getContext(), QzoneVerticalVideoDownloadActivity.class);
      paramJSONObject.putExtra("key_plugin_id", "qzone_vertical_video_plugin.apk");
      paramJSONObject.setFlags(268435456);
      paramJSONObject.putExtra("key_weishi_entrance_type", 2);
      paramJSONObject.putParcelableArrayListExtra("key_videolist", (ArrayList)localObject);
      paramJSONObject.putExtra("key_current_feeduin", String.valueOf(l));
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
        tzq.a(localIntent, b());
        paramContext.startActivity(localIntent);
      } while (TextUtils.isEmpty(b()));
      paramContext = bdop.a(b());
    } while (TextUtils.isEmpty(paramContext));
    bdll.b(null, "CliOper", "", "", "0X8005F58", "0X8005F58", 0, 0, "", "", paramContext, "");
  }
  
  private void a(Context paramContext, View paramView)
  {
    if (this.o == 1)
    {
      if ((paramView instanceof AnyScaleTypeImageView)) {
        ((AnyScaleTypeImageView)paramView).setImageResource(2130839408);
      }
      if (this.jdField_a_of_type_Bdua == null) {
        this.jdField_a_of_type_Bdua = new bdua(this);
      }
      ThreadManager.post(new StructMsgItemVideo.3(this, paramContext, paramView), 8, null, true);
      return;
    }
    a(paramContext, this.ad);
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
      paramContext = bdop.a(b());
      if (!TextUtils.isEmpty(paramContext)) {
        bdll.b(null, "CliOper", "", "", "0X8005F57", "0X8005F57", 0, 0, "", "", paramContext, "");
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
      this.ak = localBundle.getString("public_account_video_title");
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
      this.ah = localBundle.getString("VIDEO_PUB_ACCOUNT_UIN");
      if (localBundle.getString("VIDEO_PUB_ACCOUNT_NAME") == null) {
        break label282;
      }
    }
    Object localObject1;
    label262:
    label282:
    for (this.ai = localBundle.getString("VIDEO_PUB_ACCOUNT_NAME");; this.ai = String.valueOf(((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceName))
    {
      this.al = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceIcon;
      this.am = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceName;
      this.as = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceUrl;
      this.at = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceThirdName;
      localObject1 = paramContext.getResources();
      if ((paramView == null) || (!(paramView instanceof RelativeLayout))) {
        break label302;
      }
      if (paramView.getTag(2131378094) != null)
      {
        paramContext = paramView.getTag(2131378094);
        if ((paramContext instanceof bdtz))
        {
          paramContext = (bdtz)paramContext;
          if (QLog.isColorLevel()) {
            QLog.d("structmsg.StructMsgItemVideo", 2, "createView(): 复用Holder!!");
          }
        }
      }
      return null;
      this.ah = String.valueOf(((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).source_puin);
      break;
    }
    label302:
    paramView = new RelativeLayout(paramContext);
    paramBundle = new PAVideoView(paramContext);
    paramBundle.setId(2131378094);
    paramBundle.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramBundle.setContentDescription(((Resources)localObject1).getText(2131718373));
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    int i;
    Object localObject3;
    label547:
    Object localObject4;
    label628:
    int j;
    int k;
    if (bool1)
    {
      paramBundle.setRadius(15.0F);
      paramBundle.b(true);
      paramBundle.d(true);
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null)) {
        paramBundle.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.isSend();
      }
      if (this.r >= this.s)
      {
        paramBundle.f = PAVideoView.e;
        paramBundle.jdField_c_of_type_Boolean = true;
        paramBundle.i = true;
        paramView.addView(paramBundle, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new ImageView(paramContext);
        ((ImageView)localObject2).setImageResource(2130843196);
        ((ImageView)localObject2).setVisibility(8);
        i = agej.a(62.0F, (Resources)localObject1);
        if (bool1) {
          i = agej.a(50.0F, (Resources)localObject1);
        }
        localObject3 = new RelativeLayout.LayoutParams(i, i);
        ((RelativeLayout.LayoutParams)localObject3).addRule(13);
        if (bool1)
        {
          i = agej.a(10.0F, (Resources)localObject1) / 2;
          if (!paramBundle.jdField_d_of_type_Boolean) {
            break label1351;
          }
          ((RelativeLayout.LayoutParams)localObject3).rightMargin = i;
        }
        paramView.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        localObject3 = new LinearLayout(paramContext);
        ((LinearLayout)localObject3).setHorizontalGravity(0);
        localObject4 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131378094);
        ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131378094);
        ((RelativeLayout.LayoutParams)localObject4).addRule(8, 2131378094);
        if (!bool1) {
          break label1361;
        }
        i = agej.a(7.0F, (Resources)localObject1);
        if (!bool1) {
          break label1429;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message == null) || (!this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.isSend())) {
          break label1374;
        }
        j = agej.a(10.0F, (Resources)localObject1) + i;
        k = i;
      }
    }
    for (;;)
    {
      label680:
      ((LinearLayout)localObject3).setPadding(k, i, j, i);
      paramView.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new TextView(paramContext);
      ((TextView)localObject4).setId(2131378093);
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
        ((LinearLayout.LayoutParams)localObject5).rightMargin = agej.a(7.0F, (Resources)localObject1);
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
        localObject5 = new bdtz();
        ((bdtz)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView = paramBundle;
        ((bdtz)localObject5).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject4);
        ((bdtz)localObject5).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
        ((bdtz)localObject5).b = ((TextView)localObject1);
        ((bdtz)localObject5).jdField_a_of_type_AndroidViewView = ((View)localObject3);
        paramView.setTag(2131378094, localObject5);
        paramView.setTag(this);
        ((bdtz)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.a(this, (bdtz)localObject5);
        boolean bool2 = bdog.a().a(paramContext, 3, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.uinType);
        if (QLog.isColorLevel()) {
          QLog.d("structmsg.StructMsgItemVideo", 2, "createView(): convertView=" + paramView + ", args = " + localBundle.toString() + "\n, hasHeadIcon = " + bool1 + ", uniseq=" + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.uniseq + "\n, autoPlay = " + bool2 + ", vid = " + this.ae);
        }
        if ((bool2) && (this.v != 4)) {
          break label1418;
        }
        ((bdtz)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.d();
      }
      for (;;)
      {
        if (this.q > 0) {
          ((bdtz)localObject5).b.setText(ShortVideoUtils.a(this.q * 1000));
        }
        if (!TextUtils.isEmpty(this.au)) {
          paramView.setTag(2131378101, this.au);
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
        localObject3 = ShortVideoUtils.a(this.r, this.s);
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
          if (this.r >= this.s) {
            break label1270;
          }
          paramBundle.f = PAVideoView.jdField_d_of_type_Int;
          break;
          paramBundle.setRadius(5.0F);
        }
        label1270:
        if (this.r > this.s)
        {
          paramBundle.f = PAVideoView.jdField_c_of_type_Int;
          break;
        }
        if ((this.r == this.s) && (this.r != 0) && (this.s != 0))
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
        i = agej.a(12.0F, (Resources)localObject1);
        break label628;
        label1374:
        k = agej.a(10.0F, (Resources)localObject1) + i;
        j = i;
        break label680;
        ((TextView)localObject4).setTextSize(1, 19.0F);
        break label753;
        label1406:
        ((TextView)localObject1).setTextSize(1, 14.0F);
        break label823;
        label1418:
        ((bdtz)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.f();
      }
      label1429:
      j = i;
      k = i;
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
    label835:
    label859:
    do
    {
      return;
      Bundle localBundle;
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramStructMsgForGeneralShare.currentAccountUin);
        if ((rxg.a(paramContext)) || ((localQQAppInterface != null) && (localQQAppInterface.d())))
        {
          QQToast.a(paramContext, 2131695278, 1).b(paramContext.getResources().getDimensionPixelSize(2131299011));
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
        localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", this.ah);
        if (this.v <= 1) {
          break label835;
        }
      }
      localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.at);
      localBundle.putString("VIDEO_H5_URL", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgUrl);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgUrl)) {
        localBundle.putString("RED_PACKET_ID", Uri.parse(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgUrl).getQueryParameter("redpackid"));
      }
      if ((!TextUtils.isEmpty(paramStructMsgForGeneralShare.mCreateTime)) && (paramStructMsgForGeneralShare.mCreateTime.indexOf(" ") != -1)) {}
      for (Object localObject = paramStructMsgForGeneralShare.mCreateTime.substring(0, paramStructMsgForGeneralShare.mCreateTime.indexOf(" "));; localObject = paramStructMsgForGeneralShare.mCreateTime)
      {
        localBundle.putString("VIDEO_CREATE_TIME", (String)localObject);
        localBundle.putString("VIDEO_TIME", String.valueOf(this.t));
        localBundle.putString("VIDEO_WIDTH", String.valueOf(this.r));
        localBundle.putString("VIDEO_HEIGHT", String.valueOf(this.s));
        localBundle.putString("VIDEO_VID", this.af);
        localBundle.putString("VIDEO_COVER", this.ac);
        localBundle.putLong("VIDEO_PLAY_POSITION", paramLong);
        localBundle.putString("VIDEO_ARTICLE_ID", this.aj);
        localBundle.putString("VIDEO_TITLE", this.ak);
        boolean bool1 = true;
        if ((this.v == 2) || (this.v == 3)) {
          bool1 = false;
        }
        localBundle.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool1);
        localBundle.putInt("VIDEO_ARTICLE_BUSITYPE", this.v);
        if (b())
        {
          localBundle.putInt("VIDEO_FEED_TYPE", this.u);
          localBundle.putLong("VIDEO_FEED_ID", this.jdField_c_of_type_Long);
        }
        if (!bool1)
        {
          localBundle.putString("VIDEO_THIRD_ICON", this.al);
          localBundle.putString("VIDEO_THIRD_NAME", this.am);
          localBundle.putString("VIDEO_THIRD_ACTION", this.as);
          if (this.v == 2)
          {
            scq.a();
            localBundle.putString("VIDEO_THIRD_URL", scq.a(this.af));
          }
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null)) {
          bdll.b(null, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.frienduin, "0X8006830", "0X8006830", 0, 0, this.ae, "" + this.v, "" + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId, "");
        }
        localBundle.putByteArray("STRUCT_MSG_BYTES", paramStructMsgForGeneralShare.getBytes());
        localBundle.putInt("VIDEO_AIO_UIN_TYPE", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.uinType);
        localBundle.putBoolean("VIDEO_FROM_AIO", true);
        localBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 1);
        localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 1);
        localBundle.putInt("VIDEO_FROM_TYPE", 33);
        localObject = Aladdin.getConfig(261);
        if (((paramStructMsgForGeneralShare.mSourceName == null) || (!paramStructMsgForGeneralShare.mSourceName.equals(anzj.a(2131715820)))) && (((AladdinConfig)localObject).getIntegerFromString("enable_floating_layer_style", 0) == 1) && (bnrm.a(paramContext, this.aj, localBundle))) {
          break;
        }
        bool1 = false;
        try
        {
          boolean bool2 = pbn.a(localBundle.getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(localBundle.getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_TIME")).intValue());
          bool1 = bool2;
        }
        catch (Exception paramStructMsgForGeneralShare)
        {
          break label789;
        }
        if (!bool1) {
          break label859;
        }
        paramStructMsgForGeneralShare = new Intent();
        paramStructMsgForGeneralShare.putExtras(localBundle);
        rze.a(paramContext, paramStructMsgForGeneralShare);
        if (!(paramContext instanceof Activity)) {
          break;
        }
        ((Activity)paramContext).overridePendingTransition(2130772037, 2130772039);
        return;
        localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.ai);
        break label156;
      }
      paramStructMsgForGeneralShare = new Intent(paramContext, VideoFeedsPlayActivity.class);
      paramStructMsgForGeneralShare.addFlags(536870912);
      paramStructMsgForGeneralShare.putExtras(localBundle);
    } while (!(paramContext instanceof Activity));
    label789:
    ((Activity)paramContext).startActivityForResult(paramStructMsgForGeneralShare, 13005);
    ((Activity)paramContext).overridePendingTransition(2130772037, 2130772039);
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
    this.ac = paramObjectInput.readUTF();
    this.ad = paramObjectInput.readUTF();
    String str = paramObjectInput.readUTF();
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      this.o = Integer.parseInt(str);
      if (this.jdField_a_of_type_Int >= 7)
      {
        this.ae = paramObjectInput.readUTF();
        this.af = paramObjectInput.readUTF();
        this.q = paramObjectInput.readInt();
        this.r = paramObjectInput.readInt();
        this.s = paramObjectInput.readInt();
        this.t = paramObjectInput.readInt();
        this.ag = paramObjectInput.readUTF();
        this.v = paramObjectInput.readInt();
      }
      if (this.jdField_a_of_type_Int >= 8) {
        this.aj = paramObjectInput.readUTF();
      }
      if (this.jdField_a_of_type_Int >= 9)
      {
        this.au = paramObjectInput.readUTF();
        this.jdField_d_of_type_Boolean = "1".equals(paramObjectInput.readUTF());
      }
      if (this.jdField_a_of_type_Int >= 10) {
        this.p = paramObjectInput.readInt();
      }
      if (this.jdField_a_of_type_Int >= 11)
      {
        this.av = paramObjectInput.readUTF();
        this.aw = paramObjectInput.readUTF();
        this.ax = paramObjectInput.readUTF();
      }
      if ((this.jdField_a_of_type_Int >= 12) && (b()))
      {
        this.u = paramObjectInput.readInt();
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
      if (this.jdField_a_of_type_Int >= 15)
      {
        this.g = paramObjectInput.readInt();
        this.h = paramObjectInput.readInt();
      }
      if (this.jdField_a_of_type_Int >= 16)
      {
        this.P = paramObjectInput.readUTF();
        this.Q = paramObjectInput.readUTF();
        this.R = paramObjectInput.readUTF();
        this.i = paramObjectInput.readInt();
        this.j = paramObjectInput.readInt();
        this.k = paramObjectInput.readInt();
        this.l = paramObjectInput.readInt();
        this.S = paramObjectInput.readUTF();
        this.T = paramObjectInput.readUTF();
        this.U = paramObjectInput.readUTF();
        this.V = paramObjectInput.readUTF();
      }
      if (this.jdField_a_of_type_Int >= 17) {
        this.W = paramObjectInput.readUTF();
      }
      if (this.jdField_a_of_type_Int >= 18)
      {
        this.X = paramObjectInput.readUTF();
        this.Y = paramObjectInput.readUTF();
      }
      if (QLog.isColorLevel())
      {
        paramObjectInput = new StringBuilder();
        paramObjectInput.append("readExternal[:").append("\n");
        paramObjectInput.append("mVersion:").append(this.jdField_a_of_type_Int).append("\n");
        paramObjectInput.append("imgUrl:").append(this.ac).append("\n");
        paramObjectInput.append("videoUrl:").append(this.ad).append("\n");
        paramObjectInput.append("vInfo:").append(this.ae).append("\n");
        paramObjectInput.append("tInfo:").append(this.af).append("\n");
        paramObjectInput.append("previewVideoTime:").append(this.q).append("\n");
        paramObjectInput.append("previewVideoWidth:").append(this.r).append("\n");
        paramObjectInput.append("previewVideoHeight:").append(this.s).append("\n");
        paramObjectInput.append("type:").append(this.v).append("\n");
        paramObjectInput.append("articleID").append(this.aj).append("\n");
        paramObjectInput.append("jumpUrl:").append(this.au).append("\n");
        paramObjectInput.append("jump2Web:").append(this.jdField_d_of_type_Boolean).append("\n");
        paramObjectInput.append("previewStartPosi:").append(this.p).append("\n");
        if ((this.jdField_a_of_type_Int >= 12) && (b()))
        {
          paramObjectInput.append("feedId:").append(this.jdField_c_of_type_Long).append("\n");
          paramObjectInput.append("feedType:").append(this.u).append("\n");
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
        this.o = 0;
      }
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.ac != null)
    {
      str = this.ac;
      paramObjectOutput.writeUTF(str);
      if (this.ad == null) {
        break label1091;
      }
      str = this.ad;
      label36:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeUTF(this.o + "");
      if (this.jdField_a_of_type_Int >= 7)
      {
        if (this.ae == null) {
          break label1097;
        }
        str = this.ae;
        label92:
        paramObjectOutput.writeUTF(str);
        if (this.af == null) {
          break label1103;
        }
        str = this.af;
        label111:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.q);
        paramObjectOutput.writeInt(this.r);
        paramObjectOutput.writeInt(this.s);
        paramObjectOutput.writeInt(this.t);
        if (this.ag == null) {
          break label1109;
        }
        str = this.ag;
        label170:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.v);
      }
      if (this.jdField_a_of_type_Int >= 8)
      {
        if (this.aj == null) {
          break label1115;
        }
        str = this.aj;
        label208:
        paramObjectOutput.writeUTF(str);
      }
      if (this.jdField_a_of_type_Int >= 9)
      {
        if (this.au == null) {
          break label1121;
        }
        str = this.au;
        label236:
        paramObjectOutput.writeUTF(str);
        if (!this.jdField_d_of_type_Boolean) {
          break label1127;
        }
        str = "1";
        label254:
        paramObjectOutput.writeUTF(str);
      }
      if (this.jdField_a_of_type_Int >= 10) {
        paramObjectOutput.writeInt(this.p);
      }
      if (this.jdField_a_of_type_Int >= 11)
      {
        if (this.av == null) {
          break label1133;
        }
        str = this.av;
        label301:
        paramObjectOutput.writeUTF(str);
        if (this.aw == null) {
          break label1139;
        }
        str = this.aw;
        label320:
        paramObjectOutput.writeUTF(str);
        if (this.ax == null) {
          break label1145;
        }
        str = this.ax;
        label339:
        paramObjectOutput.writeUTF(str);
      }
      if ((this.jdField_a_of_type_Int >= 12) && (b()))
      {
        paramObjectOutput.writeInt(this.u);
        paramObjectOutput.writeLong(this.jdField_c_of_type_Long);
      }
      if (this.jdField_a_of_type_Int >= 13)
      {
        if (this.q == null) {
          break label1151;
        }
        str = this.q;
        label403:
        paramObjectOutput.writeUTF(str);
        if (this.B == null) {
          break label1157;
        }
        str = this.B;
        label422:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.jdField_c_of_type_Int);
        if (this.r != null) {
          break label1163;
        }
        str = "0";
        label449:
        paramObjectOutput.writeUTF(str);
        if (this.s != null) {
          break label1171;
        }
        str = "0";
        label466:
        paramObjectOutput.writeUTF(str);
        if (this.t != null) {
          break label1179;
        }
        str = "";
        label483:
        paramObjectOutput.writeUTF(str);
        if (this.u != null) {
          break label1187;
        }
        str = "";
        label500:
        paramObjectOutput.writeUTF(str);
        if (this.v != null) {
          break label1195;
        }
        str = "";
        label517:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.jdField_d_of_type_Int);
        if (this.w != null) {
          break label1203;
        }
        str = "";
        label544:
        paramObjectOutput.writeUTF(str);
        if (this.x != null) {
          break label1211;
        }
        str = "";
        label561:
        paramObjectOutput.writeUTF(str);
        if (this.y != null) {
          break label1219;
        }
        str = "";
        label578:
        paramObjectOutput.writeUTF(str);
        if (this.z != null) {
          break label1227;
        }
        str = "";
        label595:
        paramObjectOutput.writeUTF(str);
        if (this.A != null) {
          break label1235;
        }
        str = "";
        label612:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.e);
        if (this.C != null) {
          break label1243;
        }
        str = "";
        label639:
        paramObjectOutput.writeUTF(str);
        if (this.D != null) {
          break label1251;
        }
        str = "";
        label656:
        paramObjectOutput.writeUTF(str);
        if (this.E != null) {
          break label1259;
        }
        str = "";
        label673:
        paramObjectOutput.writeUTF(str);
        if (this.F != null) {
          break label1267;
        }
        str = "";
        label690:
        paramObjectOutput.writeUTF(str);
        if (this.G != null) {
          break label1275;
        }
        str = "";
        label707:
        paramObjectOutput.writeUTF(str);
        if (this.H != null) {
          break label1283;
        }
        str = "";
        label724:
        paramObjectOutput.writeUTF(str);
        if (this.I != null) {
          break label1291;
        }
        str = "";
        label741:
        paramObjectOutput.writeUTF(str);
        if (this.J != null) {
          break label1299;
        }
        str = "";
        label758:
        paramObjectOutput.writeUTF(str);
        if (this.N != null) {
          break label1307;
        }
        str = "";
        label775:
        paramObjectOutput.writeUTF(str);
        if (this.O != null) {
          break label1315;
        }
        str = "";
        label792:
        paramObjectOutput.writeUTF(str);
      }
      if (this.jdField_a_of_type_Int >= 14) {
        paramObjectOutput.writeInt(this.f);
      }
      if (this.jdField_a_of_type_Int >= 15)
      {
        paramObjectOutput.writeInt(this.g);
        paramObjectOutput.writeInt(this.h);
      }
      if (this.jdField_a_of_type_Int >= 16)
      {
        if (this.P != null) {
          break label1323;
        }
        str = "";
        label866:
        paramObjectOutput.writeUTF(str);
        if (this.Q != null) {
          break label1331;
        }
        str = "";
        label883:
        paramObjectOutput.writeUTF(str);
        if (this.R != null) {
          break label1339;
        }
        str = "";
        label900:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.i);
        paramObjectOutput.writeInt(this.j);
        paramObjectOutput.writeInt(this.k);
        paramObjectOutput.writeInt(this.l);
        if (this.S != null) {
          break label1347;
        }
        str = "";
        label957:
        paramObjectOutput.writeUTF(str);
        if (this.T != null) {
          break label1355;
        }
        str = "";
        label974:
        paramObjectOutput.writeUTF(str);
        if (this.U != null) {
          break label1363;
        }
        str = "";
        label991:
        paramObjectOutput.writeUTF(str);
        if (this.V != null) {
          break label1371;
        }
        str = "";
        label1008:
        paramObjectOutput.writeUTF(str);
      }
      if (this.jdField_a_of_type_Int >= 17)
      {
        if (this.W != null) {
          break label1379;
        }
        str = "";
        label1034:
        paramObjectOutput.writeUTF(str);
      }
      if (this.jdField_a_of_type_Int >= 18)
      {
        if (this.X != null) {
          break label1387;
        }
        str = "";
        label1060:
        paramObjectOutput.writeUTF(str);
        if (this.Y != null) {
          break label1395;
        }
      }
    }
    label1091:
    label1097:
    label1103:
    label1109:
    label1115:
    label1121:
    label1127:
    label1133:
    label1395:
    for (String str = "";; str = this.Y)
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = "";
      break;
      str = "";
      break label36;
      str = "";
      break label92;
      str = "";
      break label111;
      str = "";
      break label170;
      str = "";
      break label208;
      str = "";
      break label236;
      str = "0";
      break label254;
      str = "";
      break label301;
      label1139:
      str = "";
      break label320;
      label1145:
      str = "";
      break label339;
      label1151:
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
      str = this.u;
      break label500;
      str = this.v;
      break label517;
      str = this.w;
      break label544;
      str = this.x;
      break label561;
      str = this.y;
      break label578;
      str = this.z;
      break label595;
      str = this.A;
      break label612;
      str = this.C;
      break label639;
      str = this.D;
      break label656;
      str = this.E;
      break label673;
      label1267:
      str = this.F;
      break label690;
      label1275:
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
      str = this.O;
      break label792;
      str = this.P;
      break label866;
      str = this.Q;
      break label883;
      str = this.R;
      break label900;
      str = this.S;
      break label957;
      str = this.T;
      break label974;
      str = this.U;
      break label991;
      str = this.V;
      break label1008;
      str = this.W;
      break label1034;
      str = this.X;
      break label1060;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "video");
    if (!TextUtils.isEmpty(this.ac)) {
      paramXmlSerializer.attribute(null, "cover", this.ac);
    }
    if (!TextUtils.isEmpty(this.ad)) {
      paramXmlSerializer.attribute(null, "src", this.ad);
    }
    if (!TextUtils.isEmpty(this.ae)) {
      paramXmlSerializer.attribute(null, "vInfo", this.ae);
    }
    if (!TextUtils.isEmpty(this.af)) {
      paramXmlSerializer.attribute(null, "tInfo", this.af);
    }
    paramXmlSerializer.attribute(null, "preStartPosi", String.valueOf(this.p));
    paramXmlSerializer.attribute(null, "preTime", String.valueOf(this.q));
    paramXmlSerializer.attribute(null, "preWidth", String.valueOf(this.r));
    paramXmlSerializer.attribute(null, "preHeight", String.valueOf(this.s));
    paramXmlSerializer.attribute(null, "fullTime", String.valueOf(this.t));
    if (!TextUtils.isEmpty(this.ag)) {
      paramXmlSerializer.attribute(null, "summary", this.ag);
    }
    paramXmlSerializer.attribute(null, "busiType", String.valueOf(this.v));
    if (!TextUtils.isEmpty(this.aj)) {
      paramXmlSerializer.attribute(null, "aID", this.aj);
    }
    if (this.o == 1) {
      paramXmlSerializer.attribute(null, "load", this.o + "");
    }
    if (!TextUtils.isEmpty(this.au)) {
      paramXmlSerializer.attribute(null, "jumpUrl", this.au);
    }
    if (this.jdField_d_of_type_Boolean) {}
    for (String str = "1";; str = "0")
    {
      paramXmlSerializer.attribute(null, "isJump2Web", str);
      if (!TextUtils.isEmpty(this.av)) {
        paramXmlSerializer.attribute(null, "apurl", this.av);
      }
      if (!TextUtils.isEmpty(this.aw)) {
        paramXmlSerializer.attribute(null, "rl", this.aw);
      }
      if (!TextUtils.isEmpty(this.ax)) {
        paramXmlSerializer.attribute(null, "disType", this.ax);
      }
      if (this.jdField_c_of_type_Long != 0L) {
        paramXmlSerializer.attribute(null, "feedId", String.valueOf(this.jdField_c_of_type_Long));
      }
      if (this.u != 0) {
        paramXmlSerializer.attribute(null, "feedType", String.valueOf(this.u));
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
      if (!TextUtils.isEmpty(this.P)) {
        paramXmlSerializer.attribute(null, "negative_feedback_url", this.P);
      }
      if (!TextUtils.isEmpty(this.Q)) {
        paramXmlSerializer.attribute(null, "sdk_exposure_monitor_url", this.Q);
      }
      if (!TextUtils.isEmpty(this.R)) {
        paramXmlSerializer.attribute(null, "sdk_exposure_monitor_url", this.R);
      }
      if (this.i != 0) {
        paramXmlSerializer.attribute(null, "media_duration", String.valueOf(this.i));
      }
      if (this.j != 0) {
        paramXmlSerializer.attribute(null, "video_file_size", String.valueOf(this.j));
      }
      if (this.k != 0) {
        paramXmlSerializer.attribute(null, "app_score_num", String.valueOf(this.k));
      }
      if (this.l != 0) {
        paramXmlSerializer.attribute(null, "download_num", String.valueOf(this.l));
      }
      if (!TextUtils.isEmpty(this.S)) {
        paramXmlSerializer.attribute(null, "universal_link", this.S);
      }
      if (!TextUtils.isEmpty(this.T)) {
        paramXmlSerializer.attribute(null, "sdk_data", this.T);
      }
      if (!TextUtils.isEmpty(this.U)) {
        paramXmlSerializer.attribute(null, "tencent_video_id", this.U);
      }
      if (!TextUtils.isEmpty(this.V)) {
        paramXmlSerializer.attribute(null, "view_id", this.V);
      }
      if (!TextUtils.isEmpty(this.W)) {
        paramXmlSerializer.attribute(null, "qgg_ext", this.W);
      }
      if (!TextUtils.isEmpty(this.X)) {
        paramXmlSerializer.attribute(null, "adInfo", this.X);
      }
      if (!TextUtils.isEmpty(this.Y)) {
        paramXmlSerializer.attribute(null, "is_report_click", this.Y);
      }
      paramXmlSerializer.endTag(null, "video");
      return;
    }
  }
  
  public boolean a()
  {
    return (this.v >= 1) && (this.v <= 100);
  }
  
  public boolean a(bdqc parambdqc)
  {
    if (parambdqc == null) {}
    for (;;)
    {
      return true;
      this.ac = parambdqc.a("cover");
      this.ad = parambdqc.a("src");
      String str1 = parambdqc.a("load");
      this.ae = parambdqc.a("vInfo");
      this.af = parambdqc.a("tInfo");
      String str3 = parambdqc.a("preTime");
      if (str3 != null) {}
      try
      {
        this.q = Integer.valueOf(str3).intValue();
        str3 = parambdqc.a("preWidth");
        if (str3 == null) {}
      }
      catch (Exception localNumberFormatException3)
      {
        try
        {
          this.r = Integer.valueOf(str3).intValue();
          label104:
          str3 = parambdqc.a("preHeight");
          if (str3 != null) {}
          try
          {
            this.s = Integer.valueOf(str3).intValue();
            label127:
            str3 = parambdqc.a("fullTime");
            if (str3 != null) {}
            try
            {
              this.t = Integer.valueOf(str3).intValue();
              label150:
              this.ag = parambdqc.a("summary");
              if (!TextUtils.isEmpty(str1)) {}
              try
              {
                this.o = Integer.parseInt(str1);
                label176:
                str1 = parambdqc.a("busiType");
                if (TextUtils.isEmpty(str1)) {}
              }
              catch (RuntimeException localNumberFormatException3)
              {
                try
                {
                  this.v = Integer.parseInt(str1);
                  label199:
                  this.aj = parambdqc.a("aID");
                  this.au = parambdqc.a("jumpUrl");
                  this.jdField_d_of_type_Boolean = "1".equals(parambdqc.a("isJump2Web"));
                  str1 = parambdqc.a("preStartPosi");
                  if (!TextUtils.isEmpty(str1)) {}
                  try
                  {
                    this.p = Integer.valueOf(str1).intValue();
                    this.av = parambdqc.a("apurl");
                    this.aw = parambdqc.a("rl");
                    this.ax = parambdqc.a("disType");
                    str1 = parambdqc.a("feedId");
                    if (TextUtils.isEmpty(str1)) {}
                  }
                  catch (Exception localNumberFormatException3)
                  {
                    try
                    {
                      this.jdField_c_of_type_Long = Long.parseLong(str1);
                      str1 = parambdqc.a("feedType");
                      if (TextUtils.isEmpty(str1)) {}
                    }
                    catch (Exception localNumberFormatException3)
                    {
                      try
                      {
                        this.u = Integer.parseInt(str1);
                        if (this.jdField_a_of_type_Int >= 13)
                        {
                          str1 = parambdqc.a("action_type");
                          if (TextUtils.isEmpty(str1)) {}
                        }
                      }
                      catch (Exception localNumberFormatException3)
                      {
                        try
                        {
                          this.jdField_c_of_type_Int = Integer.parseInt(str1);
                          str1 = parambdqc.a("dest_type");
                          if (TextUtils.isEmpty(str1)) {}
                        }
                        catch (NumberFormatException localNumberFormatException3)
                        {
                          try
                          {
                            this.jdField_d_of_type_Int = Integer.parseInt(str1);
                            str1 = parambdqc.a("product_type");
                            if (TextUtils.isEmpty(str1)) {}
                          }
                          catch (NumberFormatException localNumberFormatException3)
                          {
                            try
                            {
                              this.e = Integer.parseInt(str1);
                              this.r = parambdqc.a("advertiser_id");
                              this.s = parambdqc.a("aid");
                              this.t = parambdqc.a("app_download_schema");
                              this.u = parambdqc.a("canvas_json");
                              this.v = parambdqc.a("customized_invoke_url");
                              this.w = parambdqc.a("effect_url");
                              this.x = parambdqc.a("landing_page");
                              this.y = parambdqc.a("landing_page_report_url");
                              this.z = parambdqc.a("noco_id");
                              this.A = parambdqc.a("product_id");
                              this.C = parambdqc.a("subordinate_product_id");
                              this.D = parambdqc.a("traceid");
                              this.E = parambdqc.a("via");
                              this.F = parambdqc.a("video_url");
                              this.G = parambdqc.a("appname");
                              this.H = parambdqc.a("customized_invoke_url");
                              this.I = parambdqc.a("pkg_name");
                              this.J = parambdqc.a("pkgurl");
                              this.B = parambdqc.a("rl");
                              this.q = parambdqc.a("apurl");
                              this.N = parambdqc.a("corporate_image_name");
                              this.O = parambdqc.a("corporate_logo");
                              if (this.jdField_a_of_type_Int >= 14)
                              {
                                str1 = parambdqc.a("mini_program_type");
                                if (TextUtils.isEmpty(str1)) {}
                              }
                            }
                            catch (NumberFormatException localNumberFormatException3)
                            {
                              try
                              {
                                for (;;)
                                {
                                  for (;;)
                                  {
                                    this.f = Integer.parseInt(str1);
                                    if ((parambdqc.a != null) && (parambdqc.a.a != null)) {
                                      break label922;
                                    }
                                    QLog.i("structmsg.StructMsgItemVideo", 2, "node's parent or parent's parent is null");
                                    return true;
                                    localException10 = localException10;
                                    try
                                    {
                                      this.q = ((int)Float.valueOf(str3).floatValue());
                                      if (!QLog.isColorLevel()) {
                                        break;
                                      }
                                      QLog.d("structmsg.StructMsgItemVideo", 2, "fromXml parse previewVideoTimeStr: previewVideoTime = " + this.q);
                                    }
                                    catch (Exception localException5) {}
                                  }
                                  break;
                                  localRuntimeException = localRuntimeException;
                                  this.o = 0;
                                  break label176;
                                  localException6 = localException6;
                                  try
                                  {
                                    this.p = ((int)Float.valueOf(localRuntimeException).floatValue());
                                    if (!QLog.isColorLevel()) {
                                      continue;
                                    }
                                    QLog.d("structmsg.StructMsgItemVideo", 2, "fromXml parse previewStartPosiStr: previewStartPosi = " + this.p);
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
                                    }
                                  }
                                }
                                localNumberFormatException3 = localNumberFormatException3;
                                this.e = 0;
                              }
                              catch (NumberFormatException localNumberFormatException4)
                              {
                                for (;;)
                                {
                                  this.f = 0;
                                }
                                label922:
                                parambdqc = parambdqc.a.a;
                                String str2;
                                if (this.jdField_a_of_type_Int >= 15)
                                {
                                  str2 = parambdqc.a("tab_id");
                                  if (bhsr.a(str2)) {}
                                }
                                try
                                {
                                  this.g = Integer.parseInt(str2);
                                  str2 = parambdqc.a("is_hidden");
                                  if (bhsr.a(str2)) {}
                                }
                                catch (NumberFormatException localNumberFormatException9)
                                {
                                  try
                                  {
                                    this.h = Integer.parseInt(str2);
                                    if (this.jdField_a_of_type_Int >= 16)
                                    {
                                      this.P = parambdqc.a("negative_feedback_url");
                                      this.Q = parambdqc.a("sdk_exposure_monitor_url");
                                      this.R = parambdqc.a("sdk_click_monitor_url");
                                      str2 = parambdqc.a("media_duration");
                                      if (bhsr.a(str2)) {}
                                    }
                                  }
                                  catch (NumberFormatException localNumberFormatException9)
                                  {
                                    try
                                    {
                                      this.i = Integer.parseInt(str2);
                                      str2 = parambdqc.a("video_file_size");
                                      if (bhsr.a(str2)) {}
                                    }
                                    catch (NumberFormatException localNumberFormatException9)
                                    {
                                      try
                                      {
                                        this.j = Integer.parseInt(str2);
                                        str2 = parambdqc.a("app_score_num");
                                        if (bhsr.a(str2)) {}
                                      }
                                      catch (NumberFormatException localNumberFormatException9)
                                      {
                                        try
                                        {
                                          this.k = Integer.parseInt(str2);
                                          str2 = parambdqc.a("download_num");
                                          if (bhsr.a(str2)) {}
                                        }
                                        catch (NumberFormatException localNumberFormatException9)
                                        {
                                          try
                                          {
                                            for (;;)
                                            {
                                              this.l = Integer.parseInt(str2);
                                              this.S = parambdqc.a("universal_link");
                                              this.T = parambdqc.a("sdk_data");
                                              this.U = parambdqc.a("tencent_video_id");
                                              this.V = parambdqc.a("view_id");
                                              if (this.jdField_a_of_type_Int >= 17) {
                                                this.W = parambdqc.a("qgg_ext");
                                              }
                                              if (this.jdField_a_of_type_Int < 18) {
                                                break;
                                              }
                                              this.X = parambdqc.a("adInfo");
                                              this.Y = parambdqc.a("is_report_click");
                                              return true;
                                              localNumberFormatException5 = localNumberFormatException5;
                                              this.g = 0;
                                              continue;
                                              localNumberFormatException6 = localNumberFormatException6;
                                              this.h = 0;
                                              continue;
                                              localNumberFormatException7 = localNumberFormatException7;
                                              this.i = 0;
                                              continue;
                                              localNumberFormatException8 = localNumberFormatException8;
                                              this.j = 0;
                                            }
                                            localNumberFormatException9 = localNumberFormatException9;
                                            this.k = 0;
                                          }
                                          catch (NumberFormatException localNumberFormatException10)
                                          {
                                            for (;;)
                                            {
                                              this.l = 0;
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
      i = agej.a(12.0F, (Resources)localObject1);
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
        paramView.setImageResource(2130845431);
        paramView.setTag(this);
        try
        {
          localObject2 = new bdor(-16777216, j, j, i);
          if (TextUtils.isEmpty(this.ac))
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
            paramView.setId(2131368493);
            paramView.setContentDescription(((Resources)localObject1).getString(2131694067));
            paramView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            paramView.setContentDescription(((Resources)localObject1).getText(2131718373));
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
        localURLDrawable = URLDrawable.getDrawable(this.ac, j, j, localDrawable, localDrawable);
        if (paramBundle.getBoolean("has_cnr")) {
          localURLDrawable.setDecodeHandler(new bdty(this, i, j, j));
        }
        if ((beqz.b(this.ac)) || (!beyq.a(paramContext))) {
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
    return this.v == 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdts
 * JD-Core Version:    0.7.0.1
 */