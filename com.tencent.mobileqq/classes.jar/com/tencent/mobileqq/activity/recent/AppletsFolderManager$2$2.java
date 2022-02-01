package com.tencent.mobileqq.activity.recent;

import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.applets.AppletsHandler;
import com.tencent.mobileqq.applets.data.AppletItem.Builder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

class AppletsFolderManager$2$2
  implements ActionSheet.OnButtonClickListener
{
  AppletsFolderManager$2$2(AppletsFolderManager.2 param2) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (AppletsFolderManager.a(this.a.this$0)) {
      return;
    }
    AppletsFolderManager.a(this.a.this$0, true);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppletsFolderManager.a(this.a.this$0).dismiss();
      return;
      paramView = new ArrayList();
      AppletItem.Builder localBuilder = new AppletItem.Builder();
      localBuilder.a(Integer.valueOf(this.a.a).intValue());
      localBuilder.a(Integer.valueOf(this.a.b).intValue());
      localBuilder.b(0);
      paramView.add(localBuilder.a());
      AppletsFolderManager.a(this.a.this$0).a(paramView);
      QQToast.a(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131700696), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.AppletsFolderManager.2.2
 * JD-Core Version:    0.7.0.1
 */