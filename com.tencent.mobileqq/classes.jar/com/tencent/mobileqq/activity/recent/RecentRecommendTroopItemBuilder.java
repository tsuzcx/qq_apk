package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.data.RecentItemRecommendTroopData;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.recommend.data.RecentRecommendTroopItem;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.widget.TroopActiveLayout;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.widget.FolderTextView;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.List;

public class RecentRecommendTroopItemBuilder
  extends RecentItemBaseBuilder
{
  private List<String> a;
  private int b = 2131629171;
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    if (paramView == null)
    {
      paramViewGroup = new RecentRecommendTroopItemBuilder.RecentRecommendTroopItemBuilderHolder();
      paramView = a(paramContext, this.b, paramViewGroup);
      paramViewGroup.a = ((RelativeLayout)paramView.findViewById(2131444468));
      paramViewGroup.b = ((LinearLayout)paramView.findViewById(2131444457));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131444466));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131444456));
      paramViewGroup.e = ((ThemeImageView)paramView.findViewById(2131436633));
      paramViewGroup.f = ((SingleLineTextView)paramView.findViewById(2131448843));
      paramViewGroup.g = ((FolderTextView)paramView.findViewById(2131448375));
      paramViewGroup.h = ((Button)paramView.findViewById(2131429917));
      paramViewGroup.i = ((TroopActiveLayout)paramView.findViewById(2131429299));
      paramViewGroup.j = ((TroopLabelLayout)paramView.findViewById(2131429306));
      paramViewGroup.e.setSupportMaskView(true);
      paramViewGroup.h.setOnClickListener(paramOnClickListener);
      paramViewGroup.b.setOnClickListener(paramOnClickListener);
      paramViewGroup.d.setOnClickListener(paramOnClickListener);
      paramViewGroup.h.setTag(paramViewGroup);
      paramViewGroup.b.setTag(paramViewGroup);
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (RecentRecommendTroopItemBuilder.RecentRecommendTroopItemBuilderHolder)paramView.getTag();
    }
    paramOnLongClickListener = (RecentItemRecommendTroopData)paramObject;
    paramViewGroup.a(paramOnLongClickListener, paramRecentFaceDecoder);
    a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
    paramViewGroup.b.setTag(-1, Integer.valueOf(paramInt));
    paramViewGroup.h.setTag(-1, Integer.valueOf(paramInt));
    paramViewGroup.d.setTag(-1, Integer.valueOf(paramInt));
    paramRecentFaceDecoder = null;
    paramObject = paramRecentFaceDecoder;
    if (paramOnLongClickListener.mUser != null)
    {
      paramObject = paramRecentFaceDecoder;
      if ((paramOnLongClickListener.mUser.extraInfo instanceof RecentRecommendTroopItem)) {
        paramObject = (RecentRecommendTroopItem)paramOnLongClickListener.mUser.extraInfo;
      }
    }
    if (paramObject == null) {
      paramRecentFaceDecoder = "";
    } else {
      paramRecentFaceDecoder = paramObject.uin;
    }
    if (paramObject == null) {
      paramObject = "";
    } else {
      paramObject = paramObject.recomAlgol;
    }
    ReportController.b(null, "dc00899", "Grp_recom", "", "msg_tab", "exp_grp", 0, 0, paramRecentFaceDecoder, paramObject, "", "");
    if (MayknowRecommendManager.l)
    {
      ReportController.b(null, "dc00899", "Grp_recom", "", "msg_tab", "exp", 0, 0, "", "", "", "");
      MayknowRecommendManager.l = false;
    }
    return paramView;
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData != null) && (paramContext != null))
    {
      int i = paramRecentBaseData.mMenuFlag;
      paramRecentBaseData = paramContext.getResources();
      paramContext = this.a;
      if (paramContext == null) {
        this.a = new ArrayList();
      } else {
        paramContext.clear();
      }
      if ((i & 0xF) == 1) {
        this.a.add(paramRecentBaseData.getString(c[0]));
      }
      return this.a;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentRecommendTroopItemBuilder
 * JD-Core Version:    0.7.0.1
 */