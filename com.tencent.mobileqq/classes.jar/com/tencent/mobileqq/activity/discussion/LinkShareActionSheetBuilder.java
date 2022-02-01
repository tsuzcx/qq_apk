package com.tencent.mobileqq.activity.discussion;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class LinkShareActionSheetBuilder
{
  private BaseActivity a;
  
  public LinkShareActionSheetBuilder(BaseActivity paramBaseActivity)
  {
    this.a = paramBaseActivity;
  }
  
  public ActionSheet a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.a, null);
    GridView localGridView = (GridView)View.inflate(this.a, 2131629609, null);
    localGridView.setBackgroundDrawable(this.a.getResources().getDrawable(2130837684));
    localGridView.setAdapter(new LinkShareActionSheetBuilder.ActionSheetAdapter(this, null));
    localGridView.setOnItemClickListener(paramOnItemClickListener);
    localActionSheet.addView(localGridView);
    localActionSheet.addCancelButton(2131887648);
    return localActionSheet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.discussion.LinkShareActionSheetBuilder
 * JD-Core Version:    0.7.0.1
 */