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

public class arvk
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private arum jdField_a_of_type_Arum;
  private aryv jdField_a_of_type_Aryv;
  private PublicFragmentActivity jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity;
  
  public arvk(Context paramContext)
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
      QLog.d("HeadSetViewModule", 2, new Object[] { "refreshHeadSet: invoked. ", " uins: ", str1, " headAdapter.count: ", Integer.valueOf(this.jdField_a_of_type_Aryv.getCount()) });
    }
    if (this.jdField_a_of_type_Aryv == null) {
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity.getResources().getString(2131693984));
    }
    for (;;)
    {
      aryf.a(this.jdField_a_of_type_AndroidWidgetTextView, "" + this.jdField_a_of_type_AndroidWidgetTextView.getText());
      return;
      paramArrayList = paramArrayList.size() + this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity.getString(2131694008);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramArrayList);
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HeadSetViewModule", 2, new Object[] { "onClickMinimizeShare: invoked. ", " textSharingCount: ", this.jdField_a_of_type_AndroidWidgetTextView });
    }
    if (arzn.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity.app).a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity, this.jdField_a_of_type_Arum)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity.finish();
    }
    axqy.b(null, "CliOper", "", "", "0X800A76F", "0X800A76F", 0, 0, "", "0", "0", "");
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HeadSetViewModule", 2, "onClickCancelShare: invoked. ");
    }
    bfpc localbfpc = bfpc.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity);
    localbfpc.a(2131692075, 3);
    localbfpc.a(2131694603);
    localbfpc.c(2131690596);
    localbfpc.a(new arvl(this, localbfpc));
    localbfpc.show();
    axqy.b(null, "CliOper", "", "", "0X800A76D", "0X800A76D", 0, 0, "", "0", "0", "");
  }
  
  public void a(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public void a(arum paramarum)
  {
    this.jdField_a_of_type_Arum = paramarum;
  }
  
  public void a(aryv paramaryv)
  {
    this.jdField_a_of_type_Aryv = paramaryv;
  }
  
  void a(List<aruk> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(String.valueOf(((aruk)paramList.next()).a()));
    }
    a(localArrayList);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363865: 
      d();
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arvk
 * JD-Core Version:    0.7.0.1
 */