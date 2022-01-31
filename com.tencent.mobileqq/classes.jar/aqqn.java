import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class aqqn
  implements View.OnClickListener
{
  aqqn(aqqm paramaqqm, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject instanceof aqnh))
    {
      localObject = (FileManagerEntity)((aqnh)localObject).a;
      if (paramView.getId() != 2131365065) {
        break label114;
      }
      paramView = (bhuf)bhus.a(this.jdField_a_of_type_Aqqm.a.a, null);
      paramView.a(alud.a(2131710015));
      paramView.a(alud.a(2131710019), 3);
      paramView.d(alud.a(2131710017));
      paramView.a(new aqqo(this, (FileManagerEntity)localObject, paramView));
      paramView.show();
    }
    label114:
    do
    {
      return;
      localObject = (FileManagerEntity)((aqqz)localObject).a;
      break;
      if (paramView.getId() == 2131366762)
      {
        this.jdField_a_of_type_Aqqm.a.c((FileManagerEntity)localObject);
        return;
      }
    } while (paramView.getId() != 2131376412);
    ApolloUtil.a(paramView, (FileManagerEntity)localObject, QfileBaseRecentFileTabView.r(this.jdField_a_of_type_Aqqm.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqqn
 * JD-Core Version:    0.7.0.1
 */