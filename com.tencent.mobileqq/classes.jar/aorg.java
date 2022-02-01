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
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class aorg
  extends ReportDialog
  implements FaceDecoder.DecodeTaskCompletionListener
{
  private static String jdField_a_of_type_JavaLangString = "MsgNotifyPushForSpecialCareDialog";
  private static String b = anvx.a(2131706425);
  private static String c = anvx.a(2131706422);
  private Context jdField_a_of_type_AndroidContentContext;
  private aqcx jdField_a_of_type_Aqcx;
  private aqdb jdField_a_of_type_Aqdb;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private RoundImageView jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView;
  private String d;
  
  @TargetApi(14)
  public aorg(Context paramContext, @Nullable QQAppInterface paramQQAppInterface, String paramString)
  {
    super(paramContext, 2131755829);
    super.getWindow().setWindowAnimations(2131755130);
    getWindow().setDimAmount(0.5F);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.d = paramString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
    }
    if (this.jdField_a_of_type_Aqcx != null)
    {
      this.jdField_a_of_type_Aqcx.b(this.jdField_a_of_type_Aqdb);
      this.jdField_a_of_type_Aqcx.b();
    }
  }
  
  public void onBackPressed() {}
  
  @TargetApi(16)
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131559054);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)findViewById(2131365637));
    paramBundle = (TextView)findViewById(2131365648);
    TextView localTextView = (TextView)findViewById(2131365615);
    Button localButton = (Button)findViewById(2131365612);
    ImageView localImageView = (ImageView)findViewById(2131364708);
    Bitmap localBitmap;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
      localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(1, this.d, 0);
      if (localBitmap == null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing()) {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(this.d, 1, true);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setBackgroundDrawable(bheg.a());
      }
    }
    for (;;)
    {
      paramBundle.setText(b);
      localTextView.setText(c);
      localButton.setText(anvx.a(2131706424));
      localButton.setOnClickListener(new aori(this));
      localImageView.setOnClickListener(new aorj(this));
      localImageView.setOnTouchListener(new aork(this, localImageView));
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setBackgroundDrawable(new BitmapDrawable(localBitmap));
      continue;
      this.jdField_a_of_type_Aqcx = new aqcx(this.jdField_a_of_type_AndroidContentContext, 1);
      this.jdField_a_of_type_Aqcx.a();
      this.jdField_a_of_type_Aqdb = new aorh(this);
      this.jdField_a_of_type_Aqcx.a(this.jdField_a_of_type_Aqdb);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setImageBitmap(this.jdField_a_of_type_Aqcx.a(this.d, true));
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "uin=" + paramString + ", type=" + paramInt2 + ",avatar= " + paramBitmap);
    }
    if ((paramBitmap == null) || (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing())) {
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
 * Qualified Name:     aorg
 * JD-Core Version:    0.7.0.1
 */