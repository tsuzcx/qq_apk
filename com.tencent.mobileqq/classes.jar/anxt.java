import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

public class anxt
  implements begh
{
  public anxt(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 <= 0) || (paramInt1 + paramInt2 >= paramInt3 - 1)) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        URLDrawable.resume();
      }
      return;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, LocalFileBrowserActivity.g + ",onScrollStateChanged() is called,scrollState is:" + paramInt + ",time is:" + System.currentTimeMillis());
    }
    if (paramInt == 0)
    {
      URLDrawable.resume();
      return;
    }
    URLDrawable.pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anxt
 * JD-Core Version:    0.7.0.1
 */