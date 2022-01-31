import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.now.view.widget.RoundRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class avto
  extends Dialog
  implements View.OnClickListener
{
  protected int a;
  protected Context a;
  protected Drawable a;
  public Handler a;
  protected Button a;
  protected ImageView a;
  protected AppInterface a;
  protected RoundRelativeLayout a;
  protected String a;
  protected int b;
  protected ImageView b;
  protected RoundRelativeLayout b;
  public RoundRelativeLayout c;
  
  public avto(AppInterface paramAppInterface, Context paramContext)
  {
    super(paramContext, 2131755801);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    a();
  }
  
  private void a()
  {
    setContentView(2131558934);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetRoundRelativeLayout = ((RoundRelativeLayout)findViewById(2131368091));
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewWidgetRoundRelativeLayout = ((RoundRelativeLayout)findViewById(2131363552));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363492));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368092));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368085));
    this.c = ((RoundRelativeLayout)findViewById(2131369774));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetRoundRelativeLayout.setRoundLayoutRadius(azkz.a(3.0F));
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewWidgetRoundRelativeLayout.setRoundLayoutRadius(azkz.a(3.0F));
    this.c.setRoundLayoutRadius(azkz.a(3.0F));
    this.jdField_a_of_type_Int = (azkz.jdField_a_of_type_Int - azkz.a(28.0F) * 2);
    this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int * 5 / 4);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetRoundRelativeLayout.getLayoutParams();
    localLayoutParams.width = this.jdField_a_of_type_Int;
    localLayoutParams.height = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetRoundRelativeLayout.setLayoutParams(localLayoutParams);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyActivityDialog", 2, "init, w=" + this.jdField_a_of_type_Int + ", h=" + this.jdField_b_of_type_Int);
    }
  }
  
  /* Error */
  public void a(ImageView paramImageView, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 155	avto:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   4: ifnonnull +19 -> 23
    //   7: aload_0
    //   8: new 157	android/graphics/drawable/ColorDrawable
    //   11: dup
    //   12: ldc 159
    //   14: invokestatic 165	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   17: invokespecial 167	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   20: putfield 155	avto:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   23: aconst_null
    //   24: astore 4
    //   26: invokestatic 173	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   29: astore_3
    //   30: aload_3
    //   31: aload_0
    //   32: getfield 103	avto:jdField_b_of_type_Int	I
    //   35: putfield 176	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestHeight	I
    //   38: aload_3
    //   39: aload_0
    //   40: getfield 101	avto:jdField_a_of_type_Int	I
    //   43: putfield 179	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestWidth	I
    //   46: aload_3
    //   47: aload_0
    //   48: getfield 155	avto:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   51: putfield 182	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   54: aload_3
    //   55: aload_0
    //   56: getfield 155	avto:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   59: putfield 185	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   62: aload_2
    //   63: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   66: ifne +131 -> 197
    //   69: aload_2
    //   70: aload_3
    //   71: invokestatic 197	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   74: astore 4
    //   76: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq +41 -> 120
    //   82: ldc 127
    //   84: iconst_2
    //   85: new 129	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   92: ldc 199
    //   94: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload 4
    //   99: invokevirtual 203	com/tencent/image/URLDrawable:getStatus	()I
    //   102: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: ldc 205
    //   107: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_2
    //   111: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: aload 4
    //   122: astore_3
    //   123: aload 4
    //   125: invokevirtual 203	com/tencent/image/URLDrawable:getStatus	()I
    //   128: iconst_1
    //   129: if_icmpeq +51 -> 180
    //   132: aload_0
    //   133: getfield 82	avto:c	Lcom/tencent/mobileqq/nearby/now/view/widget/RoundRelativeLayout;
    //   136: iconst_0
    //   137: invokevirtual 208	com/tencent/mobileqq/nearby/now/view/widget/RoundRelativeLayout:setVisibility	(I)V
    //   140: aload_0
    //   141: getfield 45	avto:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   144: new 210	com/tencent/mobileqq/nearby/widget/NearbyActivityDialog$1
    //   147: dup
    //   148: aload_0
    //   149: invokespecial 213	com/tencent/mobileqq/nearby/widget/NearbyActivityDialog$1:<init>	(Lavto;)V
    //   152: ldc2_w 214
    //   155: invokevirtual 219	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   158: pop
    //   159: aload 4
    //   161: new 221	avtp
    //   164: dup
    //   165: aload_0
    //   166: invokespecial 222	avtp:<init>	(Lavto;)V
    //   169: invokevirtual 226	com/tencent/image/URLDrawable:setDownloadListener	(Lcom/tencent/image/URLDrawable$DownloadListener;)V
    //   172: aload 4
    //   174: invokevirtual 229	com/tencent/image/URLDrawable:restartDownload	()V
    //   177: aload 4
    //   179: astore_3
    //   180: aload_3
    //   181: astore_2
    //   182: aload_3
    //   183: ifnonnull +8 -> 191
    //   186: aload_0
    //   187: getfield 155	avto:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   190: astore_2
    //   191: aload_1
    //   192: aload_2
    //   193: invokevirtual 233	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   196: return
    //   197: aload 4
    //   199: astore_3
    //   200: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   203: ifeq -23 -> 180
    //   206: ldc 127
    //   208: iconst_2
    //   209: ldc 235
    //   211: invokestatic 238	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: aload 4
    //   216: astore_3
    //   217: goto -37 -> 180
    //   220: astore 4
    //   222: aconst_null
    //   223: astore_3
    //   224: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   227: ifeq +30 -> 257
    //   230: ldc 127
    //   232: iconst_2
    //   233: new 129	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   240: ldc 240
    //   242: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload_2
    //   246: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: aload 4
    //   254: invokestatic 243	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   257: goto -77 -> 180
    //   260: astore 5
    //   262: aload 4
    //   264: astore_3
    //   265: aload 5
    //   267: astore 4
    //   269: goto -45 -> 224
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	avto
    //   0	272	1	paramImageView	ImageView
    //   0	272	2	paramString	String
    //   29	236	3	localObject1	java.lang.Object
    //   24	191	4	localURLDrawable	com.tencent.image.URLDrawable
    //   220	43	4	localException1	Exception
    //   267	1	4	localObject2	java.lang.Object
    //   260	6	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   26	76	220	java/lang/Exception
    //   200	214	220	java/lang/Exception
    //   76	120	260	java/lang/Exception
    //   123	177	260	java/lang/Exception
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyActivityDialog", 2, "updateContent=" + paramString);
    }
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.optJSONObject("pic").optString("pic_url");
      a(this.jdField_a_of_type_AndroidWidgetImageView, str);
      paramString = paramString.optJSONObject("jump_button");
      str = paramString.optString("text");
      int i = paramString.optInt("text_color");
      int j = paramString.optInt("bg_color");
      this.jdField_a_of_type_JavaLangString = paramString.optString("jump_url");
      this.jdField_a_of_type_AndroidWidgetButton.setText(str);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(i);
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundColor(j);
      return true;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.w("NearbyActivityDialog", 2, "updateContent exception:", paramString);
      }
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    String str = (Integer)auwq.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1)) + "";
    int i = paramView.getId();
    if (i == 2131368085)
    {
      dismiss();
      azqs.b(null, "dc00899", "grp_lbs", "", "home", "pop_clk_close", 0, 0, str, "", "", "");
    }
    while (i != 2131363492) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyActivityDialog", 2, "onClick, mJumpUrl=" + this.jdField_a_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (!this.jdField_a_of_type_JavaLangString.startsWith("http")) {
        break label221;
      }
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
      syb.a(paramView, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    }
    for (;;)
    {
      dismiss();
      azqs.b(null, "dc00899", "grp_lbs", "", "home", "pop_clk_btn", 0, 0, str, "", "", "");
      return;
      label221:
      if (this.jdField_a_of_type_JavaLangString.startsWith("mqqapi")) {
        this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).setData(Uri.parse(this.jdField_a_of_type_JavaLangString)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avto
 * JD-Core Version:    0.7.0.1
 */