import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;

public class amip
  extends Dialog
  implements bcwt
{
  private static String jdField_a_of_type_JavaLangString = "MsgNotifyPushForSpecialCareDialog";
  private static String b = alpo.a(2131707333);
  private static String c = alpo.a(2131707330);
  private Context jdField_a_of_type_AndroidContentContext;
  private anoe jdField_a_of_type_Anoe;
  private anoi jdField_a_of_type_Anoi;
  private bcws jdField_a_of_type_Bcws;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private RoundImageView jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView;
  private String d;
  
  @TargetApi(14)
  public amip(Context paramContext, @Nullable QQAppInterface paramQQAppInterface, String paramString)
  {
    super(paramContext, 2131755801);
    super.getWindow().setWindowAnimations(2131755128);
    getWindow().setDimAmount(0.5F);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.d = paramString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bcws != null) {
      this.jdField_a_of_type_Bcws.d();
    }
    if (this.jdField_a_of_type_Anoe != null)
    {
      this.jdField_a_of_type_Anoe.b(this.jdField_a_of_type_Anoi);
      this.jdField_a_of_type_Anoe.b();
    }
  }
  
  public void onBackPressed() {}
  
  @TargetApi(16)
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131558952);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)findViewById(2131365224));
    paramBundle = (TextView)findViewById(2131365235);
    TextView localTextView = (TextView)findViewById(2131365203);
    Button localButton = (Button)findViewById(2131365200);
    ImageView localImageView = (ImageView)findViewById(2131364335);
    Bitmap localBitmap;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_Bcws = new bcws(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Bcws.a(this);
      localBitmap = this.jdField_a_of_type_Bcws.a(1, this.d, 0);
      if (localBitmap == null)
      {
        if (!this.jdField_a_of_type_Bcws.a()) {
          this.jdField_a_of_type_Bcws.a(this.d, 1, true);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setBackgroundDrawable(bdda.a());
      }
    }
    for (;;)
    {
      paramBundle.setText(b);
      localTextView.setText(c);
      localButton.setText(alpo.a(2131707332));
      localButton.setOnClickListener(new amir(this));
      localImageView.setOnClickListener(new amis(this));
      localImageView.setOnTouchListener(new amit(this, localImageView));
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setBackgroundDrawable(new BitmapDrawable(localBitmap));
      continue;
      this.jdField_a_of_type_Anoe = new anoe(this.jdField_a_of_type_AndroidContentContext, 1);
      this.jdField_a_of_type_Anoe.a();
      this.jdField_a_of_type_Anoi = new amiq(this);
      this.jdField_a_of_type_Anoe.a(this.jdField_a_of_type_Anoi);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setImageBitmap(this.jdField_a_of_type_Anoe.a(this.d, true));
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "uin=" + paramString + ", type=" + paramInt2 + ",avatar= " + paramBitmap);
    }
    if ((paramBitmap == null) || (this.jdField_a_of_type_Bcws.a())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amip
 * JD-Core Version:    0.7.0.1
 */