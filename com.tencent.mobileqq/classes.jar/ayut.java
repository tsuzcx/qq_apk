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

public class ayut
  implements ayuo
{
  int jdField_a_of_type_Int = 0;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  View jdField_a_of_type_AndroidViewView = null;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public ayud a;
  ayul jdField_a_of_type_Ayul;
  ayuu jdField_a_of_type_Ayuu;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  BaseOCRTextSearchFragment jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment;
  public XListView a;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  boolean c = false;
  boolean d = false;
  
  public ayut(ayud paramayud, SearchResultFragment paramSearchResultFragment)
  {
    this.jdField_a_of_type_Ayud = paramayud;
    this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment = paramSearchResultFragment;
    this.jdField_a_of_type_Ayul = new ayul(paramayud.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
  }
  
  private void a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_Ayud.a(), QQBrowserActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("url", paramString2);
    localIntent.putExtra("hide_more_button", true);
    this.jdField_a_of_type_Ayud.a().startActivity(localIntent);
  }
  
  public View a(Context paramContext, ayuu paramayuu)
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      paramContext = LayoutInflater.from(paramContext).inflate(2131561316, null);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramContext.findViewById(2131377223));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramContext.findViewById(2131378423));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131372032));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment.a);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext.findViewById(2131370441));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      this.jdField_a_of_type_AndroidViewView = paramContext;
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ayul);
    }
    a(paramayuu);
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
      this.jdField_a_of_type_Ayud.a(null);
      return;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      continue;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695775);
      continue;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698703);
      continue;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void a(ayun paramayun)
  {
    if (paramayun == null) {
      return;
    }
    if ((paramayun.b == 2049) && (paramayun.jdField_a_of_type_Int == 0))
    {
      paramayun = (OCRTextSearchInfo.SougouSearchInfo)paramayun.jdField_a_of_type_JavaLangObject;
      if ((paramayun != null) && (!TextUtils.isEmpty(paramayun.jumpURL))) {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramayun.jumpURL);
      }
    }
    bdla.b(null, "dc00898", "", "", "0X80082E9", "0X80082E9", 0, 0, "", "", "", "");
  }
  
  protected void a(ayuu paramayuu)
  {
    if (this.d) {
      return;
    }
    this.d = true;
    this.jdField_a_of_type_Ayuu = paramayuu;
    if ((this.jdField_a_of_type_Ayuu.b == 0) && (this.jdField_a_of_type_Ayuu.a != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.SearchResultFragment", 2, "results: " + this.jdField_a_of_type_Ayuu.a.size());
      }
      List localList = this.jdField_a_of_type_Ayuu.a;
      if (localList.size() != 0) {
        this.jdField_a_of_type_Ayul.a(this.jdField_a_of_type_Ayuu, localList, false, false);
      }
    }
    else
    {
      b();
      a(paramayuu.b);
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
    if (this.jdField_a_of_type_Ayul != null) {
      this.jdField_a_of_type_Ayul.a();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new SearchResultPageView.1(this), 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayut
 * JD-Core Version:    0.7.0.1
 */