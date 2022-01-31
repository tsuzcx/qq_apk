import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import dov.com.tencent.biz.qqstory.takevideo.permission.PermissionSettingActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bkkx
  implements View.OnClickListener
{
  public bkkx(PermissionSettingActivity paramPermissionSettingActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    Object localObject = PermissionSettingActivity.a(this.a).a();
    int i = 10000;
    if (localObject != null)
    {
      i = ((bkkv)localObject).b();
      ved.a("Q.qqstory.QQStoryBaseActivity", "onCompleteBtnClick, partType:%s", Integer.valueOf(i));
      paramView.putExtra("PERMISSION_TYPE_KEY", i);
      paramView.putExtra("PERMISSION_CURRENT_UIN_KEY", PermissionSettingActivity.a(this.a));
      switch (i)
      {
      }
    }
    for (;;)
    {
      PermissionSettingActivity.a(this.a, i);
      this.a.setResult(1, paramView);
      this.a.finish();
      return;
      ArrayList localArrayList = new ArrayList();
      localObject = ((bkkn)localObject).a();
      if (((List)localObject).isEmpty())
      {
        ved.d("Q.qqstory.QQStoryBaseActivity", "onCompleteBtnClick, empty friend list.");
        bcql.a(this.a, ajya.a(2131707948), 0).a();
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((bkkp)((Iterator)localObject).next()).a());
      }
      paramView.putExtra("PERMISSION_UIN_LIST_KEY", localArrayList);
      ved.a("Q.qqstory.QQStoryBaseActivity", "select uin list:%s", localArrayList.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkkx
 * JD-Core Version:    0.7.0.1
 */