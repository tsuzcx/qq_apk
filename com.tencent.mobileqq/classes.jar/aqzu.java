import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.ui.HeadSetViewModule.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aqzu
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aqyw jdField_a_of_type_Aqyw;
  private ardb jdField_a_of_type_Ardb;
  private PublicFragmentActivity jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity;
  
  public aqzu(Context paramContext)
  {
    if ((paramContext instanceof PublicFragmentActivity)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity = ((PublicFragmentActivity)paramContext);
    }
    a();
    b();
  }
  
  private void a() {}
  
  private void a(ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      Iterator localIterator = paramArrayList.iterator();
      String str2;
      for (String str1 = ""; localIterator.hasNext(); str1 = str1 + ", " + str2) {
        str2 = (String)localIterator.next();
      }
      QLog.d("HeadSetViewModule", 2, new Object[] { "refreshHeadSet: invoked. ", " uins: ", str1, " headAdapter.count: ", Integer.valueOf(this.jdField_a_of_type_Ardb.getCount()) });
    }
    if (this.jdField_a_of_type_Ardb == null) {
      return;
    }
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      QLog.e("HeadSetViewModule", 1, "refreshHeadSet: failed. uins empty, maybe exit room");
      return;
    }
    paramArrayList = new HeadSetViewModule.1(this, paramArrayList);
    ThreadManager.getUIHandlerV2().post(paramArrayList);
  }
  
  private void b()
  {
    ImmersiveUtils.a(true, this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity.getWindow());
    ImmersiveUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity.getWindow(), true);
  }
  
  private void b(ArrayList<String> paramArrayList)
  {
    if (paramArrayList.size() == 1) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity.getResources().getString(2131628342));
    }
    for (;;)
    {
      arcl.a(this.jdField_a_of_type_AndroidWidgetTextView, "" + this.jdField_a_of_type_AndroidWidgetTextView.getText());
      return;
      paramArrayList = paramArrayList.size() + this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity.getString(2131628366);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramArrayList);
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HeadSetViewModule", 2, new Object[] { "onClickMinimizeShare: invoked. ", " textSharingCount: ", this.jdField_a_of_type_AndroidWidgetTextView });
    }
    if (ardn.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity.app).a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity, this.jdField_a_of_type_Aqyw)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity.finish();
    }
    awqx.b(null, "CliOper", "", "", "0X800A76F", "0X800A76F", 0, 0, "", "0", "0", "");
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HeadSetViewModule", 2, "onClickCancelShare: invoked. ");
    }
    begr localbegr = begr.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity);
    localbegr.a(2131626489, 3);
    localbegr.a(2131628941);
    localbegr.c(2131625035);
    localbegr.a(new aqzv(this, localbegr));
    localbegr.show();
    awqx.b(null, "CliOper", "", "", "0X800A76D", "0X800A76D", 0, 0, "", "0", "0", "");
  }
  
  public void a(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public void a(aqyw paramaqyw)
  {
    this.jdField_a_of_type_Aqyw = paramaqyw;
  }
  
  public void a(ardb paramardb)
  {
    this.jdField_a_of_type_Ardb = paramardb;
  }
  
  void a(List<aqyu> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(String.valueOf(((aqyu)paramList.next()).a()));
    }
    a(localArrayList);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298311: 
      d();
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aqzu
 * JD-Core Version:    0.7.0.1
 */