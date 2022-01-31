import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import java.util.List;

public class beyv
  implements ShareActionSheet
{
  private ShareActionSheet a;
  
  public beyv(ShareActionSheet paramShareActionSheet)
  {
    this.a = paramShareActionSheet;
  }
  
  public void dismiss()
  {
    this.a.dismiss();
  }
  
  public void dismissImmediately()
  {
    this.a.dismissImmediately();
  }
  
  public View findViewById(int paramInt)
  {
    return this.a.findViewById(paramInt);
  }
  
  public bhuf getActionSheet()
  {
    return this.a.getActionSheet();
  }
  
  public int getIconWidth()
  {
    return this.a.getIconWidth();
  }
  
  public String getOpenSource()
  {
    return this.a.getOpenSource();
  }
  
  public Window getWindow()
  {
    return this.a.getWindow();
  }
  
  public void hideTitle()
  {
    this.a.hideTitle();
  }
  
  public boolean isShowing()
  {
    return this.a.isShowing();
  }
  
  public void onConfigurationChanged()
  {
    this.a.onConfigurationChanged();
  }
  
  public void refresh()
  {
    this.a.refresh();
  }
  
  public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem> paramList1, List<ShareActionSheetBuilder.ActionSheetItem> paramList2)
  {
    this.a.setActionSheetItems(paramList1, paramList2);
  }
  
  public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem>[] paramArrayOfList)
  {
    this.a.setActionSheetItems(paramArrayOfList);
  }
  
  public void setActionSheetTitle(CharSequence paramCharSequence)
  {
    this.a.setActionSheetTitle(paramCharSequence);
  }
  
  public void setAdvBgColor(int paramInt)
  {
    this.a.setAdvBgColor(paramInt);
  }
  
  public void setAdvView(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    this.a.setAdvView(paramView, paramLayoutParams);
  }
  
  public void setBottomBarInterface(beys parambeys)
  {
    this.a.setBottomBarInterface(parambeys);
  }
  
  public void setCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.a.setCancelListener(paramOnCancelListener);
  }
  
  public void setEnableNotTriggerVirtualNavigationBar(boolean paramBoolean)
  {
    this.a.setEnableNotTriggerVirtualNavigationBar(paramBoolean);
  }
  
  public void setExtras(Bundle paramBundle)
  {
    this.a.setExtras(paramBundle);
  }
  
  public void setIconMarginLeftRight(int paramInt)
  {
    this.a.setIconMarginLeftRight(paramInt);
  }
  
  public void setIntentForStartForwardRecentActivity(Intent paramIntent)
  {
    this.a.setIntentForStartForwardRecentActivity(paramIntent);
  }
  
  public void setItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.a.setItemClickListener(paramOnItemClickListener);
  }
  
  public void setItemClickListenerV2(ShareActionSheet.OnItemClickListener paramOnItemClickListener)
  {
    this.a.setItemClickListenerV2(paramOnItemClickListener);
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.a.setOnDismissListener(paramOnDismissListener);
  }
  
  public void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    this.a.setOnShowListener(paramOnShowListener);
  }
  
  public void setOpenSource(String paramString)
  {
    this.a.setOpenSource(paramString);
  }
  
  public void setRowMarginLeftRight(int paramInt)
  {
    this.a.setRowMarginLeftRight(paramInt);
  }
  
  public void setRowVisibility(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.setRowVisibility(paramInt1, paramInt2, paramInt3);
  }
  
  public void show()
  {
    this.a.show();
  }
  
  public void updateUI()
  {
    this.a.updateUI();
  }
  
  public void updateUIIfShowing()
  {
    this.a.updateUIIfShowing();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beyv
 * JD-Core Version:    0.7.0.1
 */