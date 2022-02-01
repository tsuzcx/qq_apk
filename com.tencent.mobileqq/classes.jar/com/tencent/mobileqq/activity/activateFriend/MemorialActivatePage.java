package com.tencent.mobileqq.activity.activateFriend;

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
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MemorialActivatePage
  extends ActivateBasePage
  implements View.OnClickListener, DecodeTaskCompletionListener
{
  private static final String I = HardCodeUtil.a(2131904412);
  private static final String J = HardCodeUtil.a(2131904414);
  private static String K = "https://h5.qzone.qq.com/friend/day/%1$s/%2$s/friendDay?_wv=3&_proxy=1";
  private static String L = "https://h5.qzone.qq.com/lover/memosAct?_wv=1027&_proxy=1";
  private static final String M = HardCodeUtil.a(2131904415);
  private TextView A;
  private TextView B;
  private TextView C;
  private ImageView D;
  private ImageView E;
  private LetterSpacingTextView F;
  private LetterSpacingTextView G;
  private LetterSpacingTextView H;
  private View N;
  String k;
  String l;
  int m;
  long n;
  String o;
  String p;
  String q;
  String r;
  int s;
  private QQAppInterface t;
  private IFaceDecoder u;
  private AnyScaleTypeImageView v;
  private AnyScaleTypeImageView w;
  private AnyScaleTypeImageView x;
  private AnyScaleTypeImageView y;
  private TextView z;
  
  public MemorialActivatePage(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt3)
  {
    super(paramContext);
    this.t = paramQQAppInterface;
    this.m = paramInt1;
    this.k = paramString1;
    this.n = paramInt2;
    this.o = paramString2;
    this.p = paramString3;
    this.q = paramString4;
    this.s = paramInt3;
    this.n /= 86400L;
    this.n *= 86400L;
    paramString2 = Calendar.getInstance();
    paramString2.setTimeInMillis(this.n * 1000L);
    paramString3 = Calendar.getInstance();
    long l1 = System.currentTimeMillis();
    paramString3.setTimeInMillis(l1);
    if (QLog.isColorLevel())
    {
      paramString4 = new StringBuilder();
      paramString4.append("time=");
      paramString4.append(paramString2.toString());
      QLog.d("MemorialActivatePage", 2, paramString4.toString());
    }
    paramContext = String.format(paramContext.getString(2131896452), new Object[] { Integer.valueOf(Math.abs(paramString3.get(1) - paramString2.get(1))) });
    paramString3 = new StringBuilder();
    paramString3.append(paramContext);
    paramString3.append(paramString5);
    this.r = paramString3.toString();
    if (this.u == null)
    {
      this.u = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
      this.u.setDecodeTaskCompletionListener(this);
    }
    paramString3 = this.u.getBitmapFromCache(1, paramString1);
    if (paramString3 != null) {
      this.E.setImageBitmap(paramString3);
    } else if (!this.u.isPausing()) {
      this.u.requestDecodeFace(paramString1, 1, true, (byte)0);
    }
    paramQQAppInterface = this.u.getBitmapFromCache(1, paramQQAppInterface.getCurrentAccountUin());
    if (paramQQAppInterface != null) {
      this.D.setImageBitmap(paramQQAppInterface);
    } else if (!this.u.isPausing()) {
      this.u.requestDecodeFace(this.t.getCurrentAccountUin(), 1, true, (byte)0);
    }
    this.F.setSpacing(0.75F);
    this.F.setText(paramContext);
    paramInt2 = new Long(Math.abs(l1 - this.n * 1000L) / 86400000L).intValue();
    paramContext = QzoneConfig.getInstance().getConfig("QZoneSetting", "key_text_activate_friend_info_text", I);
    if (paramInt3 == 1) {
      paramInt1 = 2131904413;
    } else {
      paramInt1 = 2131904416;
    }
    paramContext = String.format(paramContext, new Object[] { Integer.valueOf(paramInt2), HardCodeUtil.a(paramInt1) });
    this.G.setSpacing(0.3F);
    this.G.setText(paramContext);
    this.z.setText(String.format("%d.%d.%d", new Object[] { Integer.valueOf(paramString2.get(1)), Integer.valueOf(paramString2.get(2) + 1), Integer.valueOf(paramString2.get(5)) }));
    paramContext = this.t;
    paramContext = ContactUtils.g(paramContext, paramContext.getCurrentAccountUin());
    this.A.setText(paramContext);
    paramContext = ContactUtils.g(this.t, paramString1);
    this.B.setText(paramContext);
    if (this.m == 1) {
      this.l = String.format(QzoneConfig.getInstance().getConfig("QZoneSetting", "key_url_activate_friend", K), new Object[] { this.t.getCurrentAccountUin(), this.k });
    } else {
      this.l = String.format(QzoneConfig.getInstance().getConfig("QZoneSetting", "key_url_activate_lover", L), new Object[] { this.t.getCurrentAccountUin(), this.k });
    }
    this.H.setSpacing(0.8F);
    paramContext = QzoneConfig.getInstance().getConfig("QZoneSetting", "key_text_activate_more_btn", J);
    this.H.setText(paramContext);
  }
  
  public void a()
  {
    this.b = this.a.inflate(2131627255, this, false);
    this.v = ((AnyScaleTypeImageView)this.b.findViewById(2131438071));
    Object localObject = this.v;
    if (localObject != null)
    {
      ((AnyScaleTypeImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
      this.v.setImageURL("https://qzonestyle.gtimg.cn/aoi/sola/20190121165942_mcZzfPOOYR.png");
    }
    this.w = ((AnyScaleTypeImageView)this.b.findViewById(2131438072));
    localObject = this.w;
    if (localObject != null)
    {
      ((AnyScaleTypeImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      this.w.setImageURL("https://qzonestyle.gtimg.cn/aoi/sola/20190121165942_cqHXaEsvc6.png");
    }
    this.x = ((AnyScaleTypeImageView)this.b.findViewById(2131438081));
    localObject = this.x;
    if (localObject != null)
    {
      ((AnyScaleTypeImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      this.x.setImageURL("https://qzonestyle.gtimg.cn/aoi/sola/20190121165942_x6ZlQshbMQ.png");
    }
    this.y = ((AnyScaleTypeImageView)this.b.findViewById(2131438070));
    localObject = this.y;
    if (localObject != null)
    {
      ((AnyScaleTypeImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      this.y.setImageURL("https://qzonestyle.gtimg.cn/aoi/sola/20190121165942_WTb508Bouk.png");
    }
    this.b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.z = ((TextView)this.b.findViewById(2131447345));
    this.F = ((LetterSpacingTextView)this.b.findViewById(2131435693));
    this.G = ((LetterSpacingTextView)this.b.findViewById(2131435694));
    this.D = ((ImageView)this.b.findViewById(2131445566));
    this.E = ((ImageView)this.b.findViewById(2131433783));
    this.A = ((TextView)this.b.findViewById(2131445567));
    this.B = ((TextView)this.b.findViewById(2131433805));
    this.H = ((LetterSpacingTextView)this.b.findViewById(2131449823));
    this.H.setOnClickListener(this);
    this.c = ((TextView)this.b.findViewById(2131427595));
    this.C = ((TextView)this.b.findViewById(2131434278));
    this.N = ((LinearLayout)this.b.findViewById(2131449818));
    this.N.setOnClickListener(this);
    localObject = QzoneConfig.getInstance();
    int i = 1;
    if (((QzoneConfig)localObject).getConfig("qqsetting", "QQSendFriendsMemorialDayGiftEnable", 1) != 1) {
      i = 0;
    }
    if (i != 0) {
      this.N.setVisibility(0);
    } else {
      this.N.setVisibility(8);
    }
    localObject = QzoneConfig.getInstance().getConfig("qqsetting", "QQSendFriendsMemorialDayGiftText", M);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.C.setText((CharSequence)localObject);
    }
    addView(this.b);
  }
  
  public void a(long paramLong)
  {
    CharSequence localCharSequence = TimeFormatterUtils.a(getContext(), 3, paramLong);
    this.c.setText(localCharSequence);
    ReportController.b(this.t, "dc00898", "", "", "0X8007AD6", "0X8007AD6", this.m, 0, "", "", "", "");
  }
  
  public void b()
  {
    IFaceDecoder localIFaceDecoder = this.u;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
    super.b();
  }
  
  protected void d()
  {
    LpReportInfo_pf00064.allReport(220, 4, 1);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject1;
    if (i != 2131449818)
    {
      if (i == 2131449823)
      {
        localObject1 = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", this.l);
        ((Intent)localObject1).putExtra("injectrecommend", true);
        ((Intent)localObject1).setData(Uri.parse(this.l));
        getContext().startActivity((Intent)localObject1);
        ReportController.b(this.t, "dc00898", "", "", "0X8007AD7", "0X8007AD7", this.m, 0, "", "", "", "");
        LpReportInfo_pf00064.allReport(220, 4, 2);
        QZoneLoginReportHelper.reportLoginFromActivateFriend();
      }
    }
    else
    {
      Object localObject2 = this.k;
      localObject1 = new Date(System.currentTimeMillis());
      String str1 = new SimpleDateFormat("yyyyMMdd").format((Date)localObject1);
      String str2 = QzoneConfig.getInstance().getConfig("H5Url", "SendFriendsMemorialDayGiftUrl", "https://h5.qzone.qq.com/giftv2/vuemall?_wv=131075&_fv=0&_wwv=128&from=card&friends={to_uin}");
      localObject1 = null;
      if (!TextUtils.isEmpty(str2))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("_");
        ((StringBuilder)localObject1).append(str1);
        localObject1 = str2.replace("{to_uin}", ((StringBuilder)localObject1).toString());
      }
      localObject2 = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      getContext().startActivity((Intent)localObject2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (!this.u.isPausing())
    {
      if (paramString.equalsIgnoreCase(this.t.getCurrentAccountUin()))
      {
        this.D.setImageBitmap(paramBitmap);
        return;
      }
      if (this.k.equalsIgnoreCase(paramString)) {
        this.E.setImageBitmap(paramBitmap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.MemorialActivatePage
 * JD-Core Version:    0.7.0.1
 */