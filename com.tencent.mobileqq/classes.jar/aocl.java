import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class aocl
  implements View.OnClickListener
{
  public aocl(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    Object localObject2;
    FileManagerEntity localFileManagerEntity;
    int i;
    if ((localObject1 instanceof aocu))
    {
      localObject2 = (aocu)paramView.getTag();
      localObject1 = ((aocu)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
      localFileManagerEntity = (FileManagerEntity)((aocu)localObject2).jdField_a_of_type_JavaLangObject;
      i = ((aocu)localObject2).b;
      i = ((aocu)localObject2).c;
    }
    for (;;)
    {
      if ((paramView.getId() == 2131300609) && (QfileBaseRecentFileTabView.b(this.a))) {
        awqx.b(QfileBaseRecentFileTabView.s(this.a), "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      if (localFileManagerEntity != null)
      {
        localObject2 = this.a;
        if (paramView.getId() != 2131300609) {
          break label183;
        }
      }
      label183:
      for (boolean bool = true;; bool = false)
      {
        ((QfileBaseRecentFileTabView)localObject2).a(localFileManagerEntity, (View)localObject1, bool);
        return;
        if (!(localObject1 instanceof anzc)) {
          break label188;
        }
        localObject2 = (anzc)paramView.getTag();
        localObject1 = ((anzc)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
        localFileManagerEntity = (FileManagerEntity)((anzc)localObject2).jdField_a_of_type_JavaLangObject;
        i = ((anzc)localObject2).b;
        i = ((anzc)localObject2).jdField_a_of_type_Int;
        break;
      }
      label188:
      localObject1 = null;
      localFileManagerEntity = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aocl
 * JD-Core Version:    0.7.0.1
 */