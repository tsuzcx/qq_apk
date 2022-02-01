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
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class aovn
  extends ReportDialog
  implements aoog
{
  private static String jdField_a_of_type_JavaLangString = "MsgNotifyPushForSpecialCareDialog";
  private static String b = anzj.a(2131705843);
  private static String c = anzj.a(2131705840);
  private Context jdField_a_of_type_AndroidContentContext;
  private aoof jdField_a_of_type_Aoof;
  private aqgi jdField_a_of_type_Aqgi;
  private aqgm jdField_a_of_type_Aqgm;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private RoundImageView jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView;
  private String d;
  
  @TargetApi(14)
  public aovn(Context paramContext, @Nullable QQAppInterface paramQQAppInterface, String paramString)
  {
    super(paramContext, 2131755824);
    super.getWindow().setWindowAnimations(2131755130);
    getWindow().setDimAmount(0.5F);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.d = paramString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aoof != null) {
      this.jdField_a_of_type_Aoof.d();
    }
    if (this.jdField_a_of_type_Aqgi != null)
    {
      this.jdField_a_of_type_Aqgi.b(this.jdField_a_of_type_Aqgm);
      this.jdField_a_of_type_Aqgi.b();
    }
  }
  
  public void onBackPressed() {}
  
  @TargetApi(16)
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131559018);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)findViewById(2131365512));
    paramBundle = (TextView)findViewById(2131365523);
    TextView localTextView = (TextView)findViewById(2131365491);
    Button localButton = (Button)findViewById(2131365488);
    ImageView localImageView = (ImageView)findViewById(2131364593);
    Bitmap localBitmap;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_Aoof = new aoof(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Aoof.a(this);
      localBitmap = this.jdField_a_of_type_Aoof.a(1, this.d, 0);
      if (localBitmap == null)
      {
        if (!this.jdField_a_of_type_Aoof.a()) {
          this.jdField_a_of_type_Aoof.a(this.d, 1, true);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setBackgroundDrawable(bhmq.a());
      }
    }
    for (;;)
    {
      paramBundle.setText(b);
      localTextView.setText(c);
      localButton.setText(anzj.a(2131705842));
      localButton.setOnClickListener(new aovp(this));
      localImageView.setOnClickListener(new aovq(this));
      localImageView.setOnTouchListener(new aovr(this, localImageView));
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setBackgroundDrawable(new BitmapDrawable(localBitmap));
      continue;
      this.jdField_a_of_type_Aqgi = new aqgi(this.jdField_a_of_type_AndroidContentContext, 1);
      this.jdField_a_of_type_Aqgi.a();
      this.jdField_a_of_type_Aqgm = new aovo(this);
      this.jdField_a_of_type_Aqgi.a(this.jdField_a_of_type_Aqgm);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setImageBitmap(this.jdField_a_of_type_Aqgi.a(this.d, true));
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "uin=" + paramString + ", type=" + paramInt2 + ",avatar= " + paramBitmap);
    }
    if ((paramBitmap == null) || (this.jdField_a_of_type_Aoof.a())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aovn
 * JD-Core Version:    0.7.0.1
 */