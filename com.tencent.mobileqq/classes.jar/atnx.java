import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atnx
  implements View.OnClickListener
{
  atnx(atnw paramatnw, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject instanceof atjl))
    {
      localObject = (FileManagerEntity)((atjl)localObject).a;
      if (paramView.getId() != 2131365346) {
        break label121;
      }
      blir localblir = (blir)blji.a(this.jdField_a_of_type_Atnw.a.a, null);
      localblir.a(anzj.a(2131708500));
      localblir.a(anzj.a(2131708504), 3);
      localblir.d(anzj.a(2131708502));
      localblir.a(new atny(this, (FileManagerEntity)localObject, localblir));
      localblir.show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = (FileManagerEntity)((atof)localObject).a;
      break;
      label121:
      if (paramView.getId() == 2131367081) {
        this.jdField_a_of_type_Atnw.a.c((FileManagerEntity)localObject);
      } else if (paramView.getId() == 2131377341) {
        ApolloUtil.a(paramView, (FileManagerEntity)localObject, QfileBaseRecentFileTabView.r(this.jdField_a_of_type_Atnw.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atnx
 * JD-Core Version:    0.7.0.1
 */