import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atem
  implements View.OnClickListener
{
  atem(atel paramatel, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject instanceof ataa))
    {
      localObject = (FileManagerEntity)((ataa)localObject).a;
      if (paramView.getId() != 2131365469) {
        break label121;
      }
      bkzi localbkzi = (bkzi)bkzz.a(this.jdField_a_of_type_Atel.a.a, null);
      localbkzi.a(anvx.a(2131709079));
      localbkzi.a(anvx.a(2131709083), 3);
      localbkzi.d(anvx.a(2131709081));
      localbkzi.a(new aten(this, (FileManagerEntity)localObject, localbkzi));
      localbkzi.show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = (FileManagerEntity)((ateu)localObject).a;
      break;
      label121:
      if (paramView.getId() == 2131367216) {
        this.jdField_a_of_type_Atel.a.c((FileManagerEntity)localObject);
      } else if (paramView.getId() == 2131377378) {
        ApolloUtil.a(paramView, (FileManagerEntity)localObject, QfileBaseRecentFileTabView.r(this.jdField_a_of_type_Atel.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atem
 * JD-Core Version:    0.7.0.1
 */