package com.tencent.mobileqq.apollo.emotionview.api.impl;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.emotionview.api.ICmShowEmotionPanelBuilder;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;

public class CmShowEmotionPanelBuilderImpl
  implements ICmShowEmotionPanelBuilder
{
  private BaseChatPie baseChatPie;
  private EmoticonCallback callback;
  private int columnNum;
  private int emotionType;
  private CmShowEmotionAdapter mAdapter;
  private IEmoticonMainPanelApp mApp;
  private Context mContext;
  private int panelType;
  
  public BaseEmotionAdapter buildComplete()
  {
    this.mAdapter = new CmShowEmotionAdapter(this.mApp, this.mContext, this.columnNum, this.panelType, this.emotionType, this.callback, this.baseChatPie);
    return this.mAdapter;
  }
  
  public void buildData() {}
  
  public void buildParams() {}
  
  public void buildView() {}
  
  public CmShowEmotionAdapter getAdapter()
  {
    return this.mAdapter;
  }
  
  public void init(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback, Object paramObject)
  {
    this.mApp = paramIEmoticonMainPanelApp;
    this.mContext = paramContext;
    this.columnNum = paramInt1;
    this.panelType = paramInt2;
    this.emotionType = paramInt3;
    this.callback = paramEmoticonCallback;
    this.baseChatPie = ((BaseChatPie)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.emotionview.api.impl.CmShowEmotionPanelBuilderImpl
 * JD-Core Version:    0.7.0.1
 */