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

public class aude
  implements aucz
{
  int jdField_a_of_type_Int = 0;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  View jdField_a_of_type_AndroidViewView = null;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public auco a;
  aucw jdField_a_of_type_Aucw;
  audf jdField_a_of_type_Audf;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  BaseOCRTextSearchFragment jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment;
  public XListView a;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  boolean c = false;
  boolean d = false;
  
  public aude(auco paramauco, SearchResultFragment paramSearchResultFragment)
  {
    this.jdField_a_of_type_Auco = paramauco;
    this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment = paramSearchResultFragment;
    this.jdField_a_of_type_Aucw = new aucw(paramauco.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
  }
  
  private void a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_Auco.a(), QQBrowserActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("url", paramString2);
    localIntent.putExtra("hide_more_button", true);
    this.jdField_a_of_type_Auco.a().startActivity(localIntent);
  }
  
  public View a(Context paramContext, audf paramaudf)
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      paramContext = LayoutInflater.from(paramContext).inflate(2131560929, null);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramContext.findViewById(2131375735));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramContext.findViewById(2131376819));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131370876));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment.a);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext.findViewById(2131369481));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      this.jdField_a_of_type_AndroidViewView = paramContext;
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aucw);
    }
    a(paramaudf);
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
      this.jdField_a_of_type_Auco.a(null);
      return;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      continue;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131696290);
      continue;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699254);
      continue;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void a(aucy paramaucy)
  {
    if (paramaucy == null) {
      return;
    }
    if ((paramaucy.b == 2049) && (paramaucy.jdField_a_of_type_Int == 0))
    {
      paramaucy = (OCRTextSearchInfo.SougouSearchInfo)paramaucy.jdField_a_of_type_JavaLangObject;
      if ((paramaucy != null) && (!TextUtils.isEmpty(paramaucy.jumpURL))) {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramaucy.jumpURL);
      }
    }
    axqy.b(null, "dc00898", "", "", "0X80082E9", "0X80082E9", 0, 0, "", "", "", "");
  }
  
  protected void a(audf paramaudf)
  {
    if (this.d) {
      return;
    }
    this.d = true;
    this.jdField_a_of_type_Audf = paramaudf;
    if ((this.jdField_a_of_type_Audf.b == 0) && (this.jdField_a_of_type_Audf.a != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.SearchResultFragment", 2, "results: " + this.jdField_a_of_type_Audf.a.size());
      }
      List localList = this.jdField_a_of_type_Audf.a;
      if (localList.size() != 0) {
        this.jdField_a_of_type_Aucw.a(this.jdField_a_of_type_Audf, localList, false, false);
      }
    }
    else
    {
      b();
      a(paramaudf.b);
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
    if (this.jdField_a_of_type_Aucw != null) {
      this.jdField_a_of_type_Aucw.a();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new SearchResultPageView.1(this), 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aude
 * JD-Core Version:    0.7.0.1
 */