package com.tencent.mobileqq.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.troop.memberlist.TroopMemberList.ViewHolder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class DiscussionMemberActivity$DiscussionMemberListAdapter
  extends CharDividedFacePreloadBaseAdapter
{
  private LinkedHashMap<String, List<DiscussionMemberActivity.DiscussionMember>> b = new LinkedHashMap();
  private int[] c = new int[0];
  private String[] d = new String[0];
  
  public DiscussionMemberActivity$DiscussionMemberListAdapter(DiscussionMemberActivity paramDiscussionMemberActivity)
  {
    super(paramDiscussionMemberActivity, paramDiscussionMemberActivity.app, paramDiscussionMemberActivity.a, true);
    b();
  }
  
  private void b()
  {
    this.b.clear();
    Iterator localIterator = this.a.b.iterator();
    char c1;
    int j;
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      c1 = 'A';
      j = 0;
      String str = "#";
      if (!bool) {
        break;
      }
      DiscussionMemberActivity.DiscussionMember localDiscussionMember = (DiscussionMemberActivity.DiscussionMember)localIterator.next();
      if ((localDiscussionMember.c != null) && (localDiscussionMember.c.length() != 0)) {
        localObject1 = localDiscussionMember.c.substring(0, 1);
      } else {
        localObject1 = "#";
      }
      i = ((String)localObject1).charAt(0);
      if ((65 > i) || (i > 90))
      {
        localObject2 = str;
        if (97 <= i)
        {
          localObject2 = str;
          if (i > 122) {}
        }
      }
      else
      {
        localObject2 = ((String)localObject1).toUpperCase();
      }
      if (this.b.get(localObject2) == null) {
        this.b.put(localObject2, new ArrayList());
      }
      ((List)this.b.get(localObject2)).add(localDiscussionMember);
    }
    Object localObject1 = this.b;
    this.b = new LinkedHashMap();
    while (c1 <= 'Z')
    {
      if (((LinkedHashMap)localObject1).get(String.valueOf(c1)) != null) {
        this.b.put(String.valueOf(c1), ((LinkedHashMap)localObject1).get(String.valueOf(c1)));
      }
      c1 = (char)(c1 + '\001');
    }
    if (((LinkedHashMap)localObject1).get("#") != null) {
      this.b.put("#", ((LinkedHashMap)localObject1).get("#"));
    }
    ((LinkedHashMap)localObject1).clear();
    this.c = new int[this.b.keySet().size()];
    this.d = new String[this.c.length];
    localObject1 = this.b.keySet().iterator();
    Object localObject2 = this.c;
    if (localObject2.length == 0) {
      return;
    }
    localObject2[0] = 0;
    int i = 1;
    for (;;)
    {
      localObject2 = this.c;
      if (i >= localObject2.length) {
        break;
      }
      localObject2[i] += localObject2[(i - 1)] + ((List)this.b.get(((Iterator)localObject1).next())).size() + 1;
      i += 1;
    }
    localObject1 = this.b.keySet().iterator();
    i = j;
    while (((Iterator)localObject1).hasNext())
    {
      this.d[i] = ((String)((Iterator)localObject1).next());
      i += 1;
    }
  }
  
  public int a()
  {
    return 2131625258;
  }
  
  public void a(View paramView, int paramInt)
  {
    int i = Arrays.binarySearch(this.c, paramInt);
    paramInt = i;
    if (i < 0) {
      paramInt = -(i + 1) - 1;
    }
    ((TextView)paramView).setText(this.d[paramInt]);
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.c, paramInt) >= 0;
  }
  
  public int e_(String paramString)
  {
    if (this.d != null)
    {
      int i = 0;
      for (;;)
      {
        String[] arrayOfString = this.d;
        if (i >= arrayOfString.length) {
          break;
        }
        if (arrayOfString[i].equals(paramString)) {
          break label42;
        }
        i += 1;
      }
      i = -1;
      label42:
      if (i >= 0) {
        return this.c[i];
      }
    }
    return -1;
  }
  
  public int getCount()
  {
    Object localObject = this.c;
    if (localObject.length == 0) {
      return 0;
    }
    int i = localObject[(localObject.length - 1)];
    localObject = this.b;
    String[] arrayOfString = this.d;
    return i + ((List)((LinkedHashMap)localObject).get(arrayOfString[(arrayOfString.length - 1)])).size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.c, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    return (DiscussionMemberActivity.DiscussionMember)((List)this.b.get(this.d[i])).get(paramInt - this.c[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.c, paramInt);
    View localView = paramView;
    if (paramView == null)
    {
      localView = this.a.getLayoutInflater().inflate(2131624729, paramViewGroup, false);
      paramView = new TroopMemberList.ViewHolder();
      localView.setTag(paramView);
      paramView.g = ((RelativeLayout)localView.findViewById(2131444983));
      paramView.h = ((TextView)localView.findViewById(2131448537));
      paramView.A = ((ImageView)localView.findViewById(2131436404));
      paramView.i = ((TextView)localView.findViewById(2131448598));
    }
    paramView = (TroopMemberList.ViewHolder)localView.getTag();
    if (i < 0)
    {
      i = -(i + 1) - 1;
      DiscussionMemberActivity.DiscussionMember localDiscussionMember = (DiscussionMemberActivity.DiscussionMember)((List)this.b.get(this.d[i])).get(paramInt - this.c[i] - 1);
      paramView.g.setVisibility(0);
      paramView.h.setVisibility(8);
      paramView.A.setImageBitmap(a(localDiscussionMember.a, 1));
      paramView.i.setText(localDiscussionMember.b);
      paramView.y = localDiscussionMember.a;
    }
    else
    {
      paramView.g.setVisibility(8);
      paramView.h.setVisibility(0);
      paramView.h.setText(String.valueOf(this.d[i]));
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void notifyDataSetChanged()
  {
    b();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionMemberActivity.DiscussionMemberListAdapter
 * JD-Core Version:    0.7.0.1
 */