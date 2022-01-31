import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class aqqq
  implements View.OnClickListener
{
  public aqqq(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    Object localObject2;
    FileManagerEntity localFileManagerEntity;
    int i;
    if ((localObject1 instanceof aqqz))
    {
      localObject2 = (aqqz)paramView.getTag();
      localObject1 = ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
      localFileManagerEntity = (FileManagerEntity)((aqqz)localObject2).jdField_a_of_type_JavaLangObject;
      i = ((aqqz)localObject2).b;
      i = ((aqqz)localObject2).c;
    }
    for (;;)
    {
      if ((paramView.getId() == 2131366301) && (QfileBaseRecentFileTabView.b(this.a))) {
        azqs.b(QfileBaseRecentFileTabView.s(this.a), "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      if (localFileManagerEntity != null)
      {
        localObject2 = this.a;
        if (paramView.getId() != 2131366301) {
          break label183;
        }
      }
      label183:
      for (boolean bool = true;; bool = false)
      {
        ((QfileBaseRecentFileTabView)localObject2).a(localFileManagerEntity, (View)localObject1, bool);
        return;
        if (!(localObject1 instanceof aqnh)) {
          break label188;
        }
        localObject2 = (aqnh)paramView.getTag();
        localObject1 = ((aqnh)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
        localFileManagerEntity = (FileManagerEntity)((aqnh)localObject2).jdField_a_of_type_JavaLangObject;
        i = ((aqnh)localObject2).b;
        i = ((aqnh)localObject2).jdField_a_of_type_Int;
        break;
      }
      label188:
      localObject1 = null;
      localFileManagerEntity = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqqq
 * JD-Core Version:    0.7.0.1
 */