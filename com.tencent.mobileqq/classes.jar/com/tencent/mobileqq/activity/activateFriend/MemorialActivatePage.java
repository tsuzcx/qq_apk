package com.tencent.mobileqq.activity.activateFriend;

import ajya;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import axqy;
import baxy;
import baxz;
import bbcz;
import bbkp;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MemorialActivatePage
  extends ActivateBasePage
  implements View.OnClickListener, baxz
{
  private static final String jdField_g_of_type_JavaLangString = ajya.a(2131706527);
  private static final String jdField_h_of_type_JavaLangString = ajya.a(2131706529);
  private static String jdField_i_of_type_JavaLangString = "http://h5.qzone.qq.com/friend/day/%1$s/%2$s/friendDay?_wv=3&_proxy=1";
  private static String j = "https://h5.qzone.qq.com/lover/memosAct?_wv=1027&_proxy=1";
  private static final String k = ajya.a(2131706530);
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private baxy jdField_a_of_type_Baxy;
  private LetterSpacingTextView jdField_a_of_type_ComTencentMobileqqActivityActivateFriendLetterSpacingTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AnyScaleTypeImageView jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView;
  String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LetterSpacingTextView jdField_b_of_type_ComTencentMobileqqActivityActivateFriendLetterSpacingTextView;
  private AnyScaleTypeImageView jdField_b_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView;
  String jdField_b_of_type_JavaLangString;
  private LetterSpacingTextView jdField_c_of_type_ComTencentMobileqqActivityActivateFriendLetterSpacingTextView;
  private AnyScaleTypeImageView jdField_c_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView;
  String jdField_c_of_type_JavaLangString;
  private AnyScaleTypeImageView jdField_d_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView;
  String jdField_d_of_type_JavaLangString;
  String e;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  String jdField_f_of_type_JavaLangString;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  
  public MemorialActivatePage(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt3)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Long = paramInt2;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_d_of_type_JavaLangString = paramString3;
    this.e = paramString4;
    this.jdField_b_of_type_Int = paramInt3;
    this.jdField_a_of_type_Long /= 86400L;
    this.jdField_a_of_type_Long *= 86400L;
    paramString2 = Calendar.getInstance();
    paramString2.setTimeInMillis(this.jdField_a_of_type_Long * 1000L);
    paramString3 = Calendar.getInstance();
    long l = System.currentTimeMillis();
    paramString3.setTimeInMillis(l);
    if (QLog.isColorLevel()) {
      QLog.d("MemorialActivatePage", 2, "time=" + paramString2.toString());
    }
    paramContext = String.format(paramContext.getString(2131698461), new Object[] { Integer.valueOf(Math.abs(paramString3.get(1) - paramString2.get(1))) });
    this.jdField_f_of_type_JavaLangString = (paramContext + paramString5);
    if (this.jdField_a_of_type_Baxy == null)
    {
      this.jdField_a_of_type_Baxy = new baxy(getContext(), paramQQAppInterface);
      this.jdField_a_of_type_Baxy.a(this);
    }
    paramString3 = this.jdField_a_of_type_Baxy.a(1, paramString1);
    if (paramString3 != null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramString3);
      paramQQAppInterface = this.jdField_a_of_type_Baxy.a(1, paramQQAppInterface.getCurrentAccountUin());
      if (paramQQAppInterface == null) {
        break label598;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramQQAppInterface);
      label287:
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendLetterSpacingTextView.setSpacing(0.75F);
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendLetterSpacingTextView.setText(paramContext);
      paramInt1 = new Long(Math.abs(l - this.jdField_a_of_type_Long * 1000L) / 86400000L).intValue();
      paramQQAppInterface = QzoneConfig.getInstance().getConfig("QZoneSetting", "key_text_activate_friend_info_text", jdField_g_of_type_JavaLangString);
      if (paramInt3 != 1) {
        break label629;
      }
      paramContext = ajya.a(2131706528);
      label359:
      paramContext = String.format(paramQQAppInterface, new Object[] { Integer.valueOf(paramInt1), paramContext });
      this.jdField_b_of_type_ComTencentMobileqqActivityActivateFriendLetterSpacingTextView.setSpacing(0.3F);
      this.jdField_b_of_type_ComTencentMobileqqActivityActivateFriendLetterSpacingTextView.setText(paramContext);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(String.format("%d.%d.%d", new Object[] { Integer.valueOf(paramString2.get(1)), Integer.valueOf(paramString2.get(2) + 1), Integer.valueOf(paramString2.get(5)) }));
      paramContext = bbcz.m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      this.jdField_g_of_type_AndroidWidgetTextView.setText(paramContext);
      paramContext = bbcz.m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1);
      this.jdField_h_of_type_AndroidWidgetTextView.setText(paramContext);
      if (this.jdField_a_of_type_Int != 1) {
        break label639;
      }
    }
    label598:
    label629:
    label639:
    for (this.jdField_b_of_type_JavaLangString = String.format(QzoneConfig.getInstance().getConfig("QZoneSetting", "key_url_activate_friend", jdField_i_of_type_JavaLangString), new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString });; this.jdField_b_of_type_JavaLangString = String.format(QzoneConfig.getInstance().getConfig("QZoneSetting", "key_url_activate_lover", j), new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString }))
    {
      this.jdField_c_of_type_ComTencentMobileqqActivityActivateFriendLetterSpacingTextView.setSpacing(0.8F);
      paramContext = QzoneConfig.getInstance().getConfig("QZoneSetting", "key_text_activate_more_btn", jdField_h_of_type_JavaLangString);
      this.jdField_c_of_type_ComTencentMobileqqActivityActivateFriendLetterSpacingTextView.setText(paramContext);
      return;
      if (this.jdField_a_of_type_Baxy.a()) {
        break;
      }
      this.jdField_a_of_type_Baxy.a(paramString1, 1, true, (byte)0);
      break;
      if (this.jdField_a_of_type_Baxy.a()) {
        break label287;
      }
      this.jdField_a_of_type_Baxy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1, true, (byte)0);
      break label287;
      paramContext = ajya.a(2131706531);
      break label359;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560603, this, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369879));
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageURL("https://qzonestyle.gtimg.cn/aoi/sola/20190121165942_mcZzfPOOYR.png");
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369880));
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      this.jdField_b_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageURL("https://qzonestyle.gtimg.cn/aoi/sola/20190121165942_cqHXaEsvc6.png");
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369889));
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      this.jdField_c_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageURL("https://qzonestyle.gtimg.cn/aoi/sola/20190121165942_x6ZlQshbMQ.png");
    }
    this.jdField_d_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369878));
    if (this.jdField_d_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView != null)
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      this.jdField_d_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageURL("https://qzonestyle.gtimg.cn/aoi/sola/20190121165942_WTb508Bouk.png");
    }
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377264));
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendLetterSpacingTextView = ((LetterSpacingTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368087));
    this.jdField_b_of_type_ComTencentMobileqqActivityActivateFriendLetterSpacingTextView = ((LetterSpacingTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368088));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375830));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366789));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375831));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366808));
    this.jdField_c_of_type_ComTencentMobileqqActivityActivateFriendLetterSpacingTextView = ((LetterSpacingTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379177));
    this.jdField_c_of_type_ComTencentMobileqqActivityActivateFriendLetterSpacingTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131361939));
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367093));
    this.jdField_b_of_type_AndroidViewView = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131379171));
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    int m;
    if (QzoneConfig.getInstance().getConfig("qqsetting", "QQSendFriendsMemorialDayGiftEnable", 1) == 1)
    {
      m = 1;
      if (m == 0) {
        break label487;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      String str = QzoneConfig.getInstance().getConfig("qqsetting", "QQSendFriendsMemorialDayGiftText", k);
      if (!TextUtils.isEmpty(str)) {
        this.jdField_i_of_type_AndroidWidgetTextView.setText(str);
      }
      addView(this.jdField_a_of_type_AndroidViewView);
      return;
      m = 0;
      break;
      label487:
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void a(long paramLong)
  {
    CharSequence localCharSequence = bbkp.a(getContext(), 3, paramLong);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localCharSequence);
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007AD6", "0X8007AD6", this.jdField_a_of_type_Int, 0, "", "", "", "");
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Baxy != null) {
      this.jdField_a_of_type_Baxy.d();
    }
    super.b();
  }
  
  protected void d()
  {
    LpReportInfo_pf00064.allReport(220, 4, 1);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131379177: 
      paramView = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_b_of_type_JavaLangString);
      paramView.putExtra("injectrecommend", true);
      paramView.setData(Uri.parse(this.jdField_b_of_type_JavaLangString));
      getContext().startActivity(paramView);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007AD7", "0X8007AD7", this.jdField_a_of_type_Int, 0, "", "", "", "");
      LpReportInfo_pf00064.allReport(220, 4, 2);
      QZoneLoginReportHelper.reportLoginFromActivateFriend();
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaLangString;
    paramView = new Date(System.currentTimeMillis());
    String str1 = new SimpleDateFormat("yyyyMMdd").format(paramView);
    String str2 = QzoneConfig.getInstance().getConfig("H5Url", "SendFriendsMemorialDayGiftUrl", "https://h5.qzone.qq.com/giftv2/vuemall?_wv=131075&_fv=0&_wwv=128&from=card&friends={to_uin}");
    paramView = null;
    if (!TextUtils.isEmpty(str2)) {
      paramView = str2.replace("{to_uin}", (String)localObject + "_" + str1);
    }
    localObject = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramView);
    getContext().startActivity((Intent)localObject);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (!this.jdField_a_of_type_Baxy.a())
    {
      if (!paramString.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break label34;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
    label34:
    while (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString)) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.MemorialActivatePage
 * JD-Core Version:    0.7.0.1
 */