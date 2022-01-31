package com.tencent.av.widget;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import kkg;
import mqq.app.BaseActivity;

public class ShareActionSheetBuilder
{
  private BaseActivity a;
  
  public ShareActionSheetBuilder(BaseActivity paramBaseActivity)
  {
    this.a = paramBaseActivity;
  }
  
  public ActionSheet a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.a, null);
    GridView localGridView = (GridView)View.inflate(this.a, 2130971721, null);
    localGridView.setBackgroundDrawable(this.a.getResources().getDrawable(2130837534));
    localGridView.setAdapter(new kkg(this, null));
    localGridView.setOnItemClickListener(paramOnItemClickListener);
    localActionSheet.a(localGridView);
    localActionSheet.c(2131433029);
    return localActionSheet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.widget.ShareActionSheetBuilder
 * JD-Core Version:    0.7.0.1
 */