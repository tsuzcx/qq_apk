package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.content.Context;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.CmpCtxt;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.widget.FixSizeImageView;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeAvatarView
  extends FixSizeImageView
  implements IView
{
  private CmpCtxt a = new CmpCtxt();
  private long b;
  
  public NativeAvatarView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(String paramString)
  {
    ArticleInfo localArticleInfo = this.a.a.a();
    Object localObject1 = "";
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("folder_status", ReadInJoyUtils.d);
      ((JSONObject)localObject2).put("feeds_source", this.b);
      ((JSONObject)localObject2).put("rowkey", localArticleInfo.innerUniqueID);
      ((JSONObject)localObject2).put("feeds_type", "" + ReadInJoyUtils.a(localArticleInfo));
      ((JSONObject)localObject2).put("kandian_mode", "" + ReadInJoyUtils.e());
      ((JSONObject)localObject2).put("tab_source", "" + ReadInJoyUtils.d());
      ((JSONObject)localObject2).put("entry_mode", "4");
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        try
        {
          localObject1 = ReadInJoyUtils.a();
          ((JSONObject)localObject1).put("feeds_source", paramString);
          ((JSONObject)localObject1).put("kandian_mode", ReadInJoyUtils.e());
          PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800744D", "0X800744D", 0, 0, ReadInJoyUtils.b(this.a.a.a()), "", "", ((JSONObject)localObject1).toString(), false);
          return;
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
        localJSONException = localJSONException;
        localJSONException.printStackTrace();
      }
    }
    PublicAccountReportUtils.a(null, String.valueOf(this.b), "0X8007BA3", "0X8007BA3", 0, 0, String.valueOf(localArticleInfo.mFeedId), String.valueOf(localArticleInfo.mArticleID), "", (String)localObject1, false);
  }
  
  public int a()
  {
    return getMeasuredWidth();
  }
  
  public void a()
  {
    if (this.a.a == null) {}
    while (this.b == 0L) {
      return;
    }
    if (ReadInJoyUtils.a())
    {
      setImageDrawable(SearchUtils.a(this.a.a.a().a(), String.valueOf(this.b), 1));
      return;
    }
    setImageBitmap(this.a.a.a().a(this.b));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int b()
  {
    return getMeasuredHeight();
  }
  
  public void b()
  {
    String str;
    if ((this.a.a != null) && (this.a.a.a() != null))
    {
      ReadInJoyUtils.a = this.a.a.a();
      if (this.a.a.a() != 34) {
        break label119;
      }
      str = ReadInJoyConstants.i + Base64Util.encodeToString(String.valueOf(this.b).getBytes(), 2);
      ReadInJoyUtils.a(getContext(), str);
    }
    for (;;)
    {
      a(ReadInJoyUtils.a(this.a.a.a()));
      return;
      label119:
      str = ReadInJoyConstants.f + Base64Util.encodeToString(String.valueOf(this.b).getBytes(), 2);
      ReadInJoyUtils.a(getContext(), str);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
  }
  
  public void setModel(IReadInJoyModel paramIReadInJoyModel)
  {
    this.a.a(paramIReadInJoyModel);
  }
  
  public void setUin(long paramLong)
  {
    this.b = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeAvatarView
 * JD-Core Version:    0.7.0.1
 */