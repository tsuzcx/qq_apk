package com.tencent.av.wtogether.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.wtogether.callback.GroupFileClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class QVideoGroupFileExpandableListAdapter
  extends QfileBaseExpandableListAdapter
{
  private LayoutInflater a;
  private String b;
  private GroupFileClickListener c;
  private HashMap<Integer, ArrayList<QVideoGroupFileExpandableListAdapter.PosInfo>> d = new HashMap();
  private View.OnClickListener i = new QVideoGroupFileExpandableListAdapter.1(this);
  
  public QVideoGroupFileExpandableListAdapter(Context paramContext, LinkedHashMap<String, List<FileManagerEntity>> paramLinkedHashMap, GroupFileClickListener paramGroupFileClickListener)
  {
    super(paramContext, paramLinkedHashMap);
    this.a = LayoutInflater.from(paramContext);
    this.c = paramGroupFileClickListener;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = (ArrayList)this.d.get(Integer.valueOf(paramInt1));
    Object localObject3;
    if (localObject1 != null)
    {
      localObject3 = ((ArrayList)localObject1).iterator();
      localObject1 = null;
      for (;;)
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject2 = (QVideoGroupFileExpandableListAdapter.PosInfo)((Iterator)localObject3).next();
        if (((QVideoGroupFileExpandableListAdapter.PosInfo)localObject2).a == paramInt2) {
          localObject1 = (FileManagerEntity)getChild(paramInt1, ((QVideoGroupFileExpandableListAdapter.PosInfo)localObject2).b);
        }
      }
    }
    Object localObject2 = null;
    if (localObject2 == null) {
      return paramView;
    }
    if (paramView == null) {
      localObject1 = paramView;
    }
    try
    {
      localObject3 = new QVideoGroupFileExpandableListAdapter.RecentItemHolder();
      localObject1 = paramView;
      paramView = this.a.inflate(2131627036, paramViewGroup, false);
      localObject1 = paramView;
      ((QVideoGroupFileExpandableListAdapter.RecentItemHolder)localObject3).a = ((RelativeLayout)paramView.findViewById(2131444373));
      localObject1 = paramView;
      ((QVideoGroupFileExpandableListAdapter.RecentItemHolder)localObject3).a.setTag(localObject3);
      localObject1 = paramView;
      ((QVideoGroupFileExpandableListAdapter.RecentItemHolder)localObject3).b = paramView.findViewById(2131437978);
      localObject1 = paramView;
      ((QVideoGroupFileExpandableListAdapter.RecentItemHolder)localObject3).c = ((CheckBox)paramView.findViewById(2131433116));
      localObject1 = paramView;
      ((QVideoGroupFileExpandableListAdapter.RecentItemHolder)localObject3).d = ((AsyncImageView)paramView.findViewById(2131433103));
      localObject1 = paramView;
      ((QVideoGroupFileExpandableListAdapter.RecentItemHolder)localObject3).d.setTag(localObject3);
      localObject1 = paramView;
      ((QVideoGroupFileExpandableListAdapter.RecentItemHolder)localObject3).e = ((TextView)paramView.findViewById(2131433114));
      localObject1 = paramView;
      ((QVideoGroupFileExpandableListAdapter.RecentItemHolder)localObject3).e.setGravity(48);
      localObject1 = paramView;
      ((QVideoGroupFileExpandableListAdapter.RecentItemHolder)localObject3).e.setMaxLines(2);
      localObject1 = paramView;
      ((QVideoGroupFileExpandableListAdapter.RecentItemHolder)localObject3).f = ((TextView)paramView.findViewById(2131433101));
      localObject1 = paramView;
      ((QVideoGroupFileExpandableListAdapter.RecentItemHolder)localObject3).d.setAsyncClipSize(AIOUtils.b(70.0F, this.e.getResources()), AIOUtils.b(70.0F, this.e.getResources()));
      localObject1 = paramView;
      paramView.setTag(localObject3);
      paramViewGroup = (ViewGroup)localObject3;
      break label365;
      localObject1 = paramView;
      paramViewGroup = (QVideoGroupFileExpandableListAdapter.RecentItemHolder)paramView.getTag();
      label365:
      localObject1 = paramView;
      FileManagerUtil.a(paramViewGroup.d, ((FileManagerEntity)localObject2).strThumbPath, 2);
      localObject1 = paramView;
      paramViewGroup.h = paramInt1;
      localObject1 = paramView;
      paramViewGroup.i = paramInt2;
      localObject1 = paramView;
      paramViewGroup.a.setVisibility(0);
      localObject1 = paramView;
      if (QQFileManagerUtil.a(this.e, (FileManagerEntity)localObject2))
      {
        localObject1 = paramView;
        paramViewGroup.b.setVisibility(0);
        localObject1 = paramView;
        paramViewGroup.a.setOnClickListener(null);
      }
      else
      {
        localObject1 = paramView;
        paramViewGroup.b.setVisibility(8);
        localObject1 = paramView;
        paramViewGroup.a.setOnClickListener(this.i);
      }
      localObject1 = paramView;
      paramViewGroup.g = localObject2;
      localObject1 = paramView;
      paramViewGroup.e.setText(((FileManagerEntity)localObject2).fileName);
      localObject1 = paramView;
      if (5 != ((FileManagerEntity)localObject2).cloudType)
      {
        localObject1 = paramView;
        FileManagerUtil.e((FileManagerEntity)localObject2);
      }
      localObject1 = paramView;
      paramViewGroup.c.setVisibility(0);
      localObject1 = paramView;
      paramViewGroup.c.setChecked(((FileManagerEntity)localObject2).Uuid.equalsIgnoreCase(this.b));
      localObject1 = paramView;
      localObject3 = (LinearLayout.LayoutParams)paramViewGroup.f.getLayoutParams();
      localObject1 = paramView;
      ((LinearLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(3.0F, this.e.getResources());
      localObject1 = paramView;
      paramViewGroup.f.setLineSpacing(TypedValue.applyDimension(1, 0.8F, this.e.getResources().getDisplayMetrics()), 1.0F);
      localObject1 = paramView;
      paramViewGroup.f.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject1 = paramView;
      paramViewGroup.e.setLineSpacing(TypedValue.applyDimension(1, 0.25F, this.e.getResources().getDisplayMetrics()), 1.0F);
      localObject1 = paramView;
      localObject3 = TroopFileUtils.a(((FileManagerEntity)localObject2).fileSize);
      localObject1 = paramView;
      String str = TroopFileInfo.a(BaseApplicationImpl.getApplication(), ((FileManagerEntity)localObject2).srvTime);
      localObject1 = paramView;
      localObject2 = ((FileManagerEntity)localObject2).peerNick;
      localObject1 = paramView;
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localObject1 = paramView;
      localSpannableStringBuilder.append(str).append("  ").append("来自").append((CharSequence)localObject2).append("  ").append((CharSequence)localObject3);
      localObject1 = paramView;
      paramViewGroup.f.setText(localSpannableStringBuilder);
      return paramView;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
    return localObject1;
  }
  
  public int getChildrenCount(int paramInt)
  {
    Object localObject1 = a(paramInt);
    int k = 0;
    if (localObject1 != null)
    {
      if (!this.d.containsKey(Integer.valueOf(paramInt))) {
        this.d.put(Integer.valueOf(paramInt), new ArrayList());
      }
      localObject1 = (ArrayList)localObject1;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = ((ArrayList)localObject1).iterator();
      int j = 0;
      while (localIterator.hasNext())
      {
        Object localObject2 = (FileManagerEntity)localIterator.next();
        if ((((FileManagerEntity)localObject2).getCloudType() != 0) && ((((FileManagerEntity)localObject2).getCloudType() != 5) || (((FileManagerEntity)localObject2).bSend) || (((FileManagerEntity)localObject2).status == 1)) && (!((FileManagerEntity)localObject2).sendCloudUnsuccessful()))
        {
          localObject2 = new QVideoGroupFileExpandableListAdapter.PosInfo();
          ((QVideoGroupFileExpandableListAdapter.PosInfo)localObject2).a = j;
          ((QVideoGroupFileExpandableListAdapter.PosInfo)localObject2).b = (j + k);
          localArrayList.add(localObject2);
          j += 1;
        }
        else
        {
          k += 1;
        }
      }
      this.d.put(Integer.valueOf(paramInt), localArrayList);
      return ((ArrayList)localObject1).size() - k;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.adapter.QVideoGroupFileExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */