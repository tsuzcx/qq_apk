package com.tencent.biz.qqcircle.list.bizblocks;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class QCircleBlockCheckListBlock$DebugItemView
  extends BaseWidgetView
{
  private View b;
  private boolean c;
  private TextView d;
  
  public QCircleBlockCheckListBlock$DebugItemView(QCircleBlockCheckListBlock paramQCircleBlockCheckListBlock, @NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  protected void bindData(Object paramObject, int paramInt)
  {
    this.d.setOnClickListener(new QCircleBlockCheckListBlock.DebugItemView.1(this));
    JSONObject localJSONObject = (JSONObject)QCircleBlockCheckListBlock.access$200(this.a).get(paramInt);
    paramObject = new StringBuilder();
    try
    {
      paramObject.append("NO.");
      paramObject.append(paramInt + 1);
      paramObject.append(",costTime:");
      paramObject.append(localJSONObject.getString("cost_time"));
      paramObject.append("\n");
      paramObject.append("stack:");
      paramObject.append("\n");
      paramObject.append(localJSONObject.getString("stack"));
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.d.setText(paramObject.toString());
  }
  
  public int getLayoutId()
  {
    return 2131626791;
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.b = paramView.findViewById(2131445264);
    this.d = ((TextView)paramView.findViewById(2131431322));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleBlockCheckListBlock.DebugItemView
 * JD-Core Version:    0.7.0.1
 */