import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.SougouSearchInfo;
import com.tencent.mobileqq.ocr.ui.BaseOCRTextSearchFragment;
import com.tencent.mobileqq.ocr.ui.SearchResultFragment;
import com.tencent.mobileqq.ocr.ui.SearchResultPageView.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class atgb
  implements atfw
{
  int jdField_a_of_type_Int = 0;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  View jdField_a_of_type_AndroidViewView = null;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public atfl a;
  atft jdField_a_of_type_Atft;
  atgc jdField_a_of_type_Atgc;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  BaseOCRTextSearchFragment jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment;
  public XListView a;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  boolean c = false;
  boolean d = false;
  
  public atgb(atfl paramatfl, SearchResultFragment paramSearchResultFragment)
  {
    this.jdField_a_of_type_Atfl = paramatfl;
    this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment = paramSearchResultFragment;
    this.jdField_a_of_type_Atft = new atft(paramatfl.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
  }
  
  private void a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_Atfl.a(), QQBrowserActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("url", paramString2);
    localIntent.putExtra("hide_more_button", true);
    this.jdField_a_of_type_Atfl.a().startActivity(localIntent);
  }
  
  public View a(Context paramContext, atgc paramatgc)
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      paramContext = LayoutInflater.from(paramContext).inflate(2131495350, null);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramContext.findViewById(2131309972));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramContext.findViewById(2131311008));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131305203));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment.a);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext.findViewById(2131303807));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      this.jdField_a_of_type_AndroidViewView = paramContext;
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Atft);
    }
    a(paramatgc);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a() {}
  
  protected void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Atfl.a(null);
      return;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      continue;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131630586);
      continue;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131633490);
      continue;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void a(atfv paramatfv)
  {
    if (paramatfv == null) {
      return;
    }
    if ((paramatfv.b == 2049) && (paramatfv.jdField_a_of_type_Int == 0))
    {
      paramatfv = (OCRTextSearchInfo.SougouSearchInfo)paramatfv.jdField_a_of_type_JavaLangObject;
      if ((paramatfv != null) && (!TextUtils.isEmpty(paramatfv.jumpURL))) {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramatfv.jumpURL);
      }
    }
    awqx.b(null, "dc00898", "", "", "0X80082E9", "0X80082E9", 0, 0, "", "", "", "");
  }
  
  protected void a(atgc paramatgc)
  {
    if (this.d) {
      return;
    }
    this.d = true;
    this.jdField_a_of_type_Atgc = paramatgc;
    if ((this.jdField_a_of_type_Atgc.b == 0) && (this.jdField_a_of_type_Atgc.a != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.SearchResultFragment", 2, "results: " + this.jdField_a_of_type_Atgc.a.size());
      }
      List localList = this.jdField_a_of_type_Atgc.a;
      if (localList.size() != 0) {
        this.jdField_a_of_type_Atft.a(this.jdField_a_of_type_Atgc, localList, false, false);
      }
    }
    else
    {
      b();
      a(paramatgc.b);
      return;
    }
    a(-1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = false;
    this.jdField_a_of_type_Int = 0;
    this.c = false;
    this.b = false;
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Atft != null) {
      this.jdField_a_of_type_Atft.a();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new SearchResultPageView.1(this), 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atgb
 * JD-Core Version:    0.7.0.1
 */