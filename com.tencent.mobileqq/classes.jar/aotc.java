import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class aotc
  implements View.OnClickListener
{
  aotc(aotb paramaotb, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject instanceof aopv))
    {
      localObject = (FileManagerEntity)((aopv)localObject).a;
      if (paramView.getId() != 2131364979) {
        break label114;
      }
      paramView = (bfol)bfoy.a(this.jdField_a_of_type_Aotb.a.a, null);
      paramView.a(ajyc.a(2131709620));
      paramView.a(ajyc.a(2131709624), 3);
      paramView.d(ajyc.a(2131709622));
      paramView.a(new aotd(this, (FileManagerEntity)localObject, paramView));
      paramView.show();
    }
    label114:
    do
    {
      return;
      localObject = (FileManagerEntity)((aoto)localObject).a;
      break;
      if (paramView.getId() == 2131366634)
      {
        this.jdField_a_of_type_Aotb.a.c((FileManagerEntity)localObject);
        return;
      }
    } while (paramView.getId() != 2131375857);
    ApolloUtil.a(paramView, (FileManagerEntity)localObject, QfileBaseRecentFileTabView.r(this.jdField_a_of_type_Aotb.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aotc
 * JD-Core Version:    0.7.0.1
 */