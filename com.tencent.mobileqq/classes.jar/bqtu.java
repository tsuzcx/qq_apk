import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.biz.qqstory.takevideo.permission.PermissionSettingActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bqtu
  implements View.OnClickListener
{
  public bqtu(PermissionSettingActivity paramPermissionSettingActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    Object localObject = PermissionSettingActivity.a(this.a).a();
    int i = 10000;
    if (localObject != null)
    {
      i = ((bqts)localObject).b();
      yuk.a("Q.qqstory.QQStoryBaseActivity", "onCompleteBtnClick, partType:%s", Integer.valueOf(i));
      localIntent.putExtra("PERMISSION_TYPE_KEY", i);
      localIntent.putExtra("PERMISSION_CURRENT_UIN_KEY", PermissionSettingActivity.a(this.a));
      switch (i)
      {
      }
    }
    for (;;)
    {
      PermissionSettingActivity.a(this.a, i);
      this.a.setResult(1, localIntent);
      this.a.finish();
      ArrayList localArrayList;
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localArrayList = new ArrayList();
        localObject = ((bqtk)localObject).a();
        if (!((List)localObject).isEmpty()) {
          break;
        }
        yuk.d("Q.qqstory.QQStoryBaseActivity", "onCompleteBtnClick, empty friend list.");
        QQToast.a(this.a, anzj.a(2131706818), 0).a();
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((bqtm)((Iterator)localObject).next()).a());
      }
      localIntent.putExtra("PERMISSION_UIN_LIST_KEY", localArrayList);
      yuk.a("Q.qqstory.QQStoryBaseActivity", "select uin list:%s", localArrayList.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqtu
 * JD-Core Version:    0.7.0.1
 */