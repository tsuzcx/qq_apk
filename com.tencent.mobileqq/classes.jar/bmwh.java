import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.tencent.biz.qqstory.takevideo.permission.PermissionSettingActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bmwh
  implements View.OnClickListener
{
  public bmwh(PermissionSettingActivity paramPermissionSettingActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    Object localObject = PermissionSettingActivity.a(this.a).a();
    int i = 10000;
    if (localObject != null)
    {
      i = ((bmwf)localObject).b();
      wsv.a("Q.qqstory.QQStoryBaseActivity", "onCompleteBtnClick, partType:%s", Integer.valueOf(i));
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
      localObject = ((bmvx)localObject).a();
      if (((List)localObject).isEmpty())
      {
        wsv.d("Q.qqstory.QQStoryBaseActivity", "onCompleteBtnClick, empty friend list.");
        QQToast.a(this.a, alpo.a(2131708320), 0).a();
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((bmvz)((Iterator)localObject).next()).a());
      }
      paramView.putExtra("PERMISSION_UIN_LIST_KEY", localArrayList);
      wsv.a("Q.qqstory.QQStoryBaseActivity", "select uin list:%s", localArrayList.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwh
 * JD-Core Version:    0.7.0.1
 */