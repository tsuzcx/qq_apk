import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class aoci
  implements View.OnClickListener
{
  aoci(aoch paramaoch, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject instanceof anzc))
    {
      localObject = (FileManagerEntity)((anzc)localObject).a;
      if (paramView.getId() != 2131299411) {
        break label114;
      }
      paramView = (begr)behe.a(this.jdField_a_of_type_Aoch.a.a, null);
      paramView.a(ajjy.a(2131643835));
      paramView.a(ajjy.a(2131643839), 3);
      paramView.d(ajjy.a(2131643837));
      paramView.a(new aocj(this, (FileManagerEntity)localObject, paramView));
      paramView.show();
    }
    label114:
    do
    {
      return;
      localObject = (FileManagerEntity)((aocu)localObject).a;
      break;
      if (paramView.getId() == 2131301023)
      {
        this.jdField_a_of_type_Aoch.a.c((FileManagerEntity)localObject);
        return;
      }
    } while (paramView.getId() != 2131310093);
    ApolloUtil.a(paramView, (FileManagerEntity)localObject, QfileBaseRecentFileTabView.r(this.jdField_a_of_type_Aoch.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoci
 * JD-Core Version:    0.7.0.1
 */