import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class aqme
  implements View.OnClickListener
{
  aqme(aqmd paramaqmd, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject instanceof aqiy))
    {
      localObject = (FileManagerEntity)((aqiy)localObject).a;
      if (paramView.getId() != 2131365063) {
        break label114;
      }
      paramView = (bhpy)bhql.a(this.jdField_a_of_type_Aqmd.a.a, null);
      paramView.a(alpo.a(2131710003));
      paramView.a(alpo.a(2131710007), 3);
      paramView.d(alpo.a(2131710005));
      paramView.a(new aqmf(this, (FileManagerEntity)localObject, paramView));
      paramView.show();
    }
    label114:
    do
    {
      return;
      localObject = (FileManagerEntity)((aqmq)localObject).a;
      break;
      if (paramView.getId() == 2131366752)
      {
        this.jdField_a_of_type_Aqmd.a.c((FileManagerEntity)localObject);
        return;
      }
    } while (paramView.getId() != 2131376358);
    ApolloUtil.a(paramView, (FileManagerEntity)localObject, QfileBaseRecentFileTabView.r(this.jdField_a_of_type_Aqmd.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqme
 * JD-Core Version:    0.7.0.1
 */