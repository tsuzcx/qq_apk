import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class asxt
  implements View.OnClickListener
{
  asxt(asxs paramasxs, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject instanceof asth))
    {
      localObject = (FileManagerEntity)((asth)localObject).a;
      if (paramView.getId() != 2131365302) {
        break label121;
      }
      bkho localbkho = (bkho)bkif.a(this.jdField_a_of_type_Asxs.a.a, null);
      localbkho.a(anni.a(2131708391));
      localbkho.a(anni.a(2131708395), 3);
      localbkho.d(anni.a(2131708393));
      localbkho.a(new asxu(this, (FileManagerEntity)localObject, localbkho));
      localbkho.show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = (FileManagerEntity)((asyb)localObject).a;
      break;
      label121:
      if (paramView.getId() == 2131367030) {
        this.jdField_a_of_type_Asxs.a.c((FileManagerEntity)localObject);
      } else if (paramView.getId() == 2131377201) {
        ApolloUtil.a(paramView, (FileManagerEntity)localObject, QfileBaseRecentFileTabView.r(this.jdField_a_of_type_Asxs.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxt
 * JD-Core Version:    0.7.0.1
 */