import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class aotg
  implements View.OnClickListener
{
  aotg(aotf paramaotf, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject instanceof aoqa))
    {
      localObject = (FileManagerEntity)((aoqa)localObject).a;
      if (paramView.getId() != 2131364978) {
        break label114;
      }
      paramView = (bfpc)bfpp.a(this.jdField_a_of_type_Aotf.a.a, null);
      paramView.a(ajya.a(2131709631));
      paramView.a(ajya.a(2131709635), 3);
      paramView.d(ajya.a(2131709633));
      paramView.a(new aoth(this, (FileManagerEntity)localObject, paramView));
      paramView.show();
    }
    label114:
    do
    {
      return;
      localObject = (FileManagerEntity)((aots)localObject).a;
      break;
      if (paramView.getId() == 2131366634)
      {
        this.jdField_a_of_type_Aotf.a.c((FileManagerEntity)localObject);
        return;
      }
    } while (paramView.getId() != 2131375859);
    ApolloUtil.a(paramView, (FileManagerEntity)localObject, QfileBaseRecentFileTabView.r(this.jdField_a_of_type_Aotf.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aotg
 * JD-Core Version:    0.7.0.1
 */