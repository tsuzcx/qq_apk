package com.tencent.mobileqq.activity.contact.connections;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ConnectionsTabLayout$TabItemViewHolder
{
  ImageView a;
  ImageView b;
  TextView c;
  TextView d;
  TriangleView e;
  
  public ConnectionsTabLayout$TabItemViewHolder(View paramView)
  {
    this.a = ((ImageView)paramView.findViewById(2131439278));
    this.b = ((ImageView)paramView.findViewById(2131439275));
    this.c = ((TextView)paramView.findViewById(2131439279));
    this.d = ((TextView)paramView.findViewById(2131439277));
    this.e = ((TriangleView)paramView.findViewById(2131447858));
  }
  
  public void a()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((ImageView)localObject).setSelected(true);
    }
    localObject = this.b;
    if (localObject != null) {
      ((ImageView)localObject).setSelected(true);
    }
    localObject = this.c;
    if (localObject != null) {
      ((TextView)localObject).setSelected(true);
    }
    localObject = this.d;
    if (localObject != null) {
      ((TextView)localObject).setSelected(true);
    }
    localObject = this.e;
    if (localObject != null) {
      ((TriangleView)localObject).setVisibility(0);
    }
  }
  
  public void b()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((ImageView)localObject).setSelected(false);
    }
    localObject = this.b;
    if (localObject != null) {
      ((ImageView)localObject).setSelected(false);
    }
    localObject = this.c;
    if (localObject != null) {
      ((TextView)localObject).setSelected(false);
    }
    localObject = this.d;
    if (localObject != null) {
      ((TextView)localObject).setSelected(false);
    }
    localObject = this.e;
    if (localObject != null) {
      ((TriangleView)localObject).setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectionsTabLayout.TabItemViewHolder
 * JD-Core Version:    0.7.0.1
 */