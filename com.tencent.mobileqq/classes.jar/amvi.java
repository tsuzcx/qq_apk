import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.datareportviewer.DataReportViewer;
import com.tencent.mobileqq.datareportviewer.ReportData;
import java.util.ArrayList;

public class amvi
  extends BaseAdapter
{
  public amvi(DataReportViewer paramDataReportViewer) {}
  
  public int getCount()
  {
    return this.a.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.getContext()).inflate(2131493854, paramViewGroup, false);
      paramViewGroup = new amvj(this.a, paramView);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      ReportData localReportData = (ReportData)this.a.a.get(paramInt);
      paramViewGroup.a.setText(localReportData.table);
      paramViewGroup.b.setText(localReportData.mainAction);
      paramViewGroup.c.setText(localReportData.subAction);
      paramViewGroup.d.setText(localReportData.actionName);
      paramViewGroup.e.setText(String.valueOf(localReportData.opType));
      paramViewGroup.f.setText(String.valueOf(localReportData.result));
      paramViewGroup.g.setText(localReportData.r2);
      paramViewGroup.h.setText(localReportData.r3);
      paramViewGroup.i.setText(localReportData.r4);
      paramViewGroup.j.setText(localReportData.r5);
      if (!localReportData.isLightBlueBg) {
        break;
      }
      paramView.setBackgroundColor(this.a.getContext().getResources().getColor(2131100846));
      return paramView;
      paramViewGroup = (amvj)paramView.getTag();
    }
    paramView.setBackgroundColor(this.a.getContext().getResources().getColor(2131101537));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amvi
 * JD-Core Version:    0.7.0.1
 */