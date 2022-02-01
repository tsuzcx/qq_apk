import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class asag
  implements View.OnClickListener
{
  asag(asaf paramasaf, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject instanceof arvu))
    {
      localObject = (FileManagerEntity)((arvu)localObject).a;
      if (paramView.getId() != 2131365376) {
        break label121;
      }
      bjnw localbjnw = (bjnw)bjon.a(this.jdField_a_of_type_Asaf.a.a, null);
      localbjnw.a(amtj.a(2131708732));
      localbjnw.a(amtj.a(2131708736), 3);
      localbjnw.d(amtj.a(2131708734));
      localbjnw.a(new asah(this, (FileManagerEntity)localObject, localbjnw));
      localbjnw.show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = (FileManagerEntity)((asao)localObject).a;
      break;
      label121:
      if (paramView.getId() == 2131367097) {
        this.jdField_a_of_type_Asaf.a.c((FileManagerEntity)localObject);
      } else if (paramView.getId() == 2131377104) {
        ApolloUtil.a(paramView, (FileManagerEntity)localObject, QfileBaseRecentFileTabView.r(this.jdField_a_of_type_Asaf.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asag
 * JD-Core Version:    0.7.0.1
 */