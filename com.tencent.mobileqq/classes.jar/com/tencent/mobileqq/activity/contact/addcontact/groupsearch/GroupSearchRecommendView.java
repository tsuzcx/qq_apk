package com.tencent.mobileqq.activity.contact.addcontact.groupsearch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.addContactTroopView.AddContactTroopHandler;
import com.tencent.biz.addContactTroopView.AddContactTroopHandler.IGetPopClassAndSearchCB;
import com.tencent.biz.addContactTroopView.AddContactTroopManage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.MeasureListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ScrollView;
import tencent.im.troop_search_popclassifc.popclassifc.HotWordItem;
import tencent.im.troop_search_popclassifc.popclassifc.PopHotWordCard;

public class GroupSearchRecommendView
  extends ScrollView
{
  protected GroupSearchRecommendView.IGroupSearchContext a;
  private GroupSearchRecommendView.UIHandler b;
  private Context c;
  private MeasureListView d;
  private GroupSearchHistoryListAdapter e;
  private GroupSearchHistoryListAdapter.OnItemClickListener f;
  private View g;
  private TextView h;
  private HotRecommendGroupFlowLayout i;
  private HotRecommendGroupListAdapter j;
  private HotRecommendGroupListAdapter.OnItemClickListener k;
  private LinearLayout l;
  private AddContactTroopHandler.IGetPopClassAndSearchCB m = new GroupSearchRecommendView.1(this);
  
  public GroupSearchRecommendView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GroupSearchRecommendView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public GroupSearchRecommendView(Context paramContext, GroupSearchRecommendView.IGroupSearchContext paramIGroupSearchContext, GroupSearchHistoryListAdapter.OnItemClickListener paramOnItemClickListener, HotRecommendGroupListAdapter.OnItemClickListener paramOnItemClickListener1)
  {
    super(paramContext);
    this.a = paramIGroupSearchContext;
    this.c = paramContext;
    this.f = paramOnItemClickListener;
    this.k = paramOnItemClickListener1;
  }
  
  private void a(boolean paramBoolean)
  {
    if (StudyModeManager.h())
    {
      this.h.setVisibility(8);
      this.i.setVisibility(8);
      this.l.setVisibility(8);
      this.g.setVisibility(8);
      return;
    }
    if (paramBoolean) {
      return;
    }
    AddContactTroopManage localAddContactTroopManage = (AddContactTroopManage)this.a.a().getManager(QQManagerFactory.ADDCONTACT_TROOP_SEARCH_POP_MANAGE);
    if ((localAddContactTroopManage.a() != null) && (localAddContactTroopManage.a().rpt_pop_items.size() > 0))
    {
      TextView localTextView = this.h;
      int n = 0;
      localTextView.setVisibility(0);
      this.i.setVisibility(0);
      this.l.setVisibility(0);
      this.g.setVisibility(0);
      this.j.a();
      while (n < localAddContactTroopManage.a().rpt_pop_items.size())
      {
        this.j.a(new HotRecommendGroupListAdapter.Keyword(((popclassifc.HotWordItem)localAddContactTroopManage.a().rpt_pop_items.get(n)).str_hot_word.get(), ((popclassifc.HotWordItem)localAddContactTroopManage.a().rpt_pop_items.get(n)).str_text_color.get()));
        n += 1;
      }
      this.j.notifyDataSetChanged();
      return;
    }
    this.h.setVisibility(8);
    this.i.setVisibility(8);
    this.l.setVisibility(8);
    this.g.setVisibility(8);
  }
  
  private void c()
  {
    this.b = new GroupSearchRecommendView.UIHandler(this);
    this.d = ((MeasureListView)findViewById(2131437781));
    this.e = new GroupSearchHistoryListAdapter(this.c, this.d, this.a.a().getCurrentUin());
    this.e.a(this.f);
    this.g = new View(this.c);
    this.g.setBackgroundResource(2130852210);
    this.g.setLayoutParams(new AbsListView.LayoutParams(-1, DisplayUtil.a(this.c, 12.0F)));
    this.d.setVerticalScrollBarEnabled(false);
    this.d.setFastScrollEnabled(false);
    LinearLayout localLinearLayout = new LinearLayout(this.c);
    localLinearLayout.addView(this.g);
    this.d.addFooterView(localLinearLayout);
    this.d.setAdapter(this.e);
    this.h = ((TextView)findViewById(2131448531));
    this.i = ((HotRecommendGroupFlowLayout)findViewById(2131433265));
    this.l = ((LinearLayout)findViewById(2131437474));
    this.j = new HotRecommendGroupListAdapter(this.c);
    this.j.a(this.k);
    this.i.setAdapter(this.j);
    a(false);
    setOverScrollMode(0);
    setVerticalScrollBarEnabled(false);
    setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    if (StudyModeManager.h())
    {
      this.h.setVisibility(8);
      this.i.setVisibility(8);
      this.l.setVisibility(8);
      this.g.setVisibility(8);
    }
  }
  
  private void d()
  {
    this.b.sendEmptyMessage(1);
  }
  
  private void e()
  {
    new AddContactTroopHandler(this.a.a()).b(this.m);
  }
  
  public void a()
  {
    setContentView(2131627895);
    c();
    d();
  }
  
  public void b()
  {
    GroupSearchHistoryListAdapter localGroupSearchHistoryListAdapter = this.e;
    if (localGroupSearchHistoryListAdapter != null) {
      localGroupSearchHistoryListAdapter.a();
    }
  }
  
  protected final void setContentView(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchRecommendView
 * JD-Core Version:    0.7.0.1
 */