package com.tencent.mobileqq.activity.discussion;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import wov;

public class LinkShareActionSheetBuilder
{
  private BaseActivity a;
  
  public LinkShareActionSheetBuilder(BaseActivity paramBaseActivity)
  {
    this.a = paramBaseActivity;
  }
  
  public ActionSheet a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.a, null);
    GridView localGridView = (GridView)View.inflate(this.a, 2130971692, null);
    localGridView.setBackgroundDrawable(this.a.getResources().getDrawable(2130837534));
    localGridView.setAdapter(new wov(this, null));
    localGridView.setOnItemClickListener(paramOnItemClickListener);
    localActionSheet.a(localGridView);
    localActionSheet.c(2131433015);
    return localActionSheet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.discussion.LinkShareActionSheetBuilder
 * JD-Core Version:    0.7.0.1
 */