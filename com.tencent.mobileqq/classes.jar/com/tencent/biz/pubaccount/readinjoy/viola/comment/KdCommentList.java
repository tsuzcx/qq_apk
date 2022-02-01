package com.tencent.biz.pubaccount.readinjoy.viola.comment;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.component.VDiv;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pac;
import paq;
import pat;
import pbg;
import pdp;
import pfh;

public class KdCommentList
  extends VDiv
  implements paq, pat, pbg, pfh
{
  public static final String EVENT_CHANGE = "change";
  public static final String EVENT_COMMENT_CHANGE = "commentChange";
  public static final String EVENT_SCROLL_CHANGE = "scrollChange";
  private KdCommentHeaderView kdHeaderView;
  private ReadInJoyCommentListFragment readInJoyCommentListFragment;
  
  public KdCommentList(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  private void fireCommentListEvent(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    JSONArray localJSONArray = new JSONArray();
    if (this.mDomObj != null)
    {
      localJSONArray.put(this.mDomObj.getRef());
      localJSONArray.put("change");
    }
    fireEvent("change", localJSONArray, paramJSONObject);
  }
  
  private JSONObject getJSONObjectFromAttr(String paramString)
  {
    DomObject localDomObject = getDomObject();
    if (localDomObject == null) {
      return null;
    }
    paramString = localDomObject.getAttributes().get(paramString);
    if ((paramString instanceof JSONObject)) {
      return (JSONObject)paramString;
    }
    return null;
  }
  
  private JSONObject mergeSrcToConfig(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    Object localObject;
    if ((paramJSONObject1 == null) && (paramJSONObject2 == null)) {
      localObject = new JSONObject();
    }
    do
    {
      return localObject;
      localObject = paramJSONObject2;
    } while (paramJSONObject1 == null);
    if (paramJSONObject2 == null) {
      return paramJSONObject1;
    }
    Iterator localIterator = paramJSONObject1.keys();
    for (;;)
    {
      localObject = paramJSONObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (String)localIterator.next();
      try
      {
        paramJSONObject2.put((String)localObject, paramJSONObject1.opt((String)localObject));
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void addSubView(View paramView, int paramInt)
  {
    if ((paramView instanceof KdCommentHeaderView)) {
      this.kdHeaderView = ((KdCommentHeaderView)paramView);
    }
  }
  
  public ViewGroup.LayoutParams getChildLayoutParams(VComponent paramVComponent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    paramVComponent = null;
    if (paramView != null) {
      paramVComponent = paramView.getLayoutParams();
    }
    if (paramVComponent == null) {
      return new AbsListView.LayoutParams(paramInt1, paramInt2);
    }
    paramVComponent.width = paramInt1;
    paramVComponent.height = paramInt2;
    return paramVComponent;
  }
  
  public void notifyParentWhenChildAddEnd()
  {
    View localView = getHostView();
    if (localView == null) {}
    JSONObject localJSONObject1;
    JSONObject localJSONObject2;
    do
    {
      return;
      localJSONObject1 = getJSONObjectFromAttr("src");
      localJSONObject2 = getJSONObjectFromAttr("config");
    } while ((localJSONObject1 == null) || (localJSONObject2 == null));
    localView.post(new KdCommentList.1(this, localJSONObject1, localJSONObject2, localView));
  }
  
  public void onActivityDestroy()
  {
    super.onActivityDestroy();
    pac.a().b(this);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.readInJoyCommentListFragment != null) {
      this.readInJoyCommentListFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCommentCreate(boolean paramBoolean, pdp parampdp, List<pdp> paramList, int paramInt)
  {
    if (!this.mAppendEvents.contains("change")) {}
    while (!paramBoolean) {
      return;
    }
    parampdp = new JSONObject();
    try
    {
      parampdp.put("commentChange", 1);
      fireCommentListEvent(parampdp);
      return;
    }
    catch (JSONException paramList)
    {
      for (;;)
      {
        paramList.printStackTrace();
      }
    }
  }
  
  public void onCommentCreate(boolean paramBoolean1, pdp parampdp, boolean paramBoolean2, List<pdp> paramList, int paramInt) {}
  
  public void onCommentDelete(int paramInt1, boolean paramBoolean, pdp parampdp, int paramInt2)
  {
    if (!this.mAppendEvents.contains("change")) {}
    while (!paramBoolean) {
      return;
    }
    parampdp = new JSONObject();
    try
    {
      parampdp.put("commentChange", -1);
      fireCommentListEvent(parampdp);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void onCommentLikeOrDislike(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<pdp> paramList, boolean paramBoolean2, int paramInt2, int paramInt3) {}
  
  public void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<pdp> paramList, boolean paramBoolean2, int paramInt2) {}
  
  public void onCommentReply(boolean paramBoolean, pdp parampdp) {}
  
  public void onCommentStateError(int paramInt) {}
  
  public void onScroll(int paramInt)
  {
    if (!this.mAppendEvents.contains("change")) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("scrollChange", FlexConvertUtils.px2dip(paramInt));
      fireCommentListEvent(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void onViewCreated(boolean paramBoolean)
  {
    if (this.readInJoyCommentListFragment == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.readInJoyCommentListFragment.a();
      } while (localObject == null);
      this.readInJoyCommentListFragment.a(this);
      this.readInJoyCommentListFragment.a(this);
      this.readInJoyCommentListFragment.a();
      ((ListView)localObject).addHeaderView(this.kdHeaderView);
      localObject = this.kdHeaderView.getComponent();
    } while (localObject == null);
    ((VDiv)localObject).applyLayout();
    ((VDiv)localObject).applyEvents();
    ((VDiv)localObject).bindData();
  }
  
  public void onViewState(boolean paramBoolean, String paramString)
  {
    if (!this.mAppendEvents.contains("change")) {
      return;
    }
    try
    {
      fireCommentListEvent(new JSONObject(paramString));
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.comment.KdCommentList
 * JD-Core Version:    0.7.0.1
 */