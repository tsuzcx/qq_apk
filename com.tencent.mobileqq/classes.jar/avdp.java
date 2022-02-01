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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class avdp
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private avcq jdField_a_of_type_Avcq;
  private avhc jdField_a_of_type_Avhc;
  private PublicFragmentActivity jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity;
  
  public avdp(Context paramContext)
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
      QLog.d("HeadSetViewModule", 2, new Object[] { "refreshHeadSet: invoked. ", " uins: ", str1, " headAdapter.count: ", Integer.valueOf(this.jdField_a_of_type_Avhc.getCount()) });
    }
    if (this.jdField_a_of_type_Avhc == null) {
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity.getResources().getString(2131693502));
    }
    for (;;)
    {
      avgm.a(this.jdField_a_of_type_AndroidWidgetTextView, "" + this.jdField_a_of_type_AndroidWidgetTextView.getText());
      return;
      paramArrayList = paramArrayList.size() + this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity.getString(2131693522);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramArrayList);
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HeadSetViewModule", 2, new Object[] { "onClickMinimizeShare: invoked. ", " textSharingCount: ", this.jdField_a_of_type_AndroidWidgetTextView });
    }
    if (avhu.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity.app).a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity, this.jdField_a_of_type_Avcq)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity.finish();
    }
    bcef.b(null, "CliOper", "", "", "0X800A76F", "0X800A76F", 0, 0, "", "0", "0", "");
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HeadSetViewModule", 2, "onClickCancelShare: invoked. ");
    }
    bjnw localbjnw = bjnw.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity);
    localbjnw.a(2131691817, 3);
    localbjnw.a(2131694060);
    localbjnw.c(2131690620);
    localbjnw.a(new avdq(this, localbjnw));
    localbjnw.show();
    bcef.b(null, "CliOper", "", "", "0X800A76D", "0X800A76D", 0, 0, "", "0", "0", "");
  }
  
  public void a(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public void a(avcq paramavcq)
  {
    this.jdField_a_of_type_Avcq = paramavcq;
  }
  
  public void a(avhc paramavhc)
  {
    this.jdField_a_of_type_Avhc = paramavhc;
  }
  
  void a(List<avco> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(String.valueOf(((avco)paramList.next()).a()));
    }
    a(localArrayList);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      d();
      continue;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avdp
 * JD-Core Version:    0.7.0.1
 */