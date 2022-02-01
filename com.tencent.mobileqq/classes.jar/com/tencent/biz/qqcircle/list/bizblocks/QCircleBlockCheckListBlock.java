package com.tencent.biz.qqcircle.list.bizblocks;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper.BlockLooperListener;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.list.QCircleBaseListBlock;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock.BaseListVH;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.idata.IDataCallBack;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

public class QCircleBlockCheckListBlock
  extends QCircleBaseListBlock<JSONObject, ByteStringMicro>
{
  private static final int LOAD_COUNT_PER_PAGE = 20;
  private static final String TAG = "QCircleBlockCheckListBlock";
  private static QCircleHostDropFrameMonitorHelper.BlockLooperListener mLooperListener = new QCircleBlockCheckListBlock.1();
  private static CopyOnWriteArrayList<JSONObject> sLooperBlockInfo = new CopyOnWriteArrayList();
  
  public QCircleBlockCheckListBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private static TextView addDebugViewToInfoView(ViewGroup paramViewGroup)
  {
    TextView localTextView = new TextView(paramViewGroup.getContext());
    localTextView.setBackgroundColor(Color.parseColor("#99000000"));
    localTextView.setTextColor(-1);
    localTextView.setMaxLines(1);
    localTextView.setTag("debug_view");
    localTextView.setGravity(17);
    localTextView.setPadding(ViewUtils.a(8.0F), ViewUtils.a(10.0F), ViewUtils.a(8.0F), ViewUtils.a(10.0F));
    localTextView.setTextSize(1, 12.0F);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    localTextView.setOnClickListener(new QCircleBlockCheckListBlock.2());
    localTextView.setOnLongClickListener(new QCircleBlockCheckListBlock.3(localTextView));
    paramViewGroup.addView(localTextView);
    return localTextView;
  }
  
  public static void clearBlockLooperListener() {}
  
  private static TextView getBlockDebugView(FrameLayout paramFrameLayout)
  {
    paramFrameLayout = paramFrameLayout.getChildAt(paramFrameLayout.getChildCount() - 1);
    if ("debug_view".equals(paramFrameLayout.getTag())) {
      return (TextView)paramFrameLayout;
    }
    return null;
  }
  
  public static CopyOnWriteArrayList<JSONObject> getBlockLooperInfoList()
  {
    return sLooperBlockInfo;
  }
  
  private static boolean isBlockCheckOpen()
  {
    return QCirclePluginConfig.b().getBoolean("SP_KEY_IS_BLOCK_CHECK_OPEN", false);
  }
  
  public static void tryInjectBlockLooperListener()
  {
    if ((QCircleApplication.isRDMVersion()) && (isBlockCheckOpen())) {
      QCircleHostDropFrameMonitorHelper.setLooperListener(mLooperListener);
    }
  }
  
  public String getAttachInfoFromItemData(JSONObject paramJSONObject)
  {
    return null;
  }
  
  public String getAttachInfoFromRsp(ByteStringMicro paramByteStringMicro)
  {
    return null;
  }
  
  public List<Part> getCustomParts()
  {
    return null;
  }
  
  public String getDropFrameMonitorTag()
  {
    return null;
  }
  
  public String getEmptyHint()
  {
    return null;
  }
  
  public boolean getIsFinishFromRsp(ByteStringMicro paramByteStringMicro)
  {
    return false;
  }
  
  public void getListDataAsync(IDataCallBack paramIDataCallBack, String paramString)
  {
    paramIDataCallBack.a(true, 0L, sLooperBlockInfo, "", true);
  }
  
  public List<JSONObject> getListDataFromRsp(ByteStringMicro paramByteStringMicro)
  {
    return null;
  }
  
  public String getLogTag()
  {
    return "QCircleBlockCheckListBlock";
  }
  
  public int getPageCount()
  {
    return 20;
  }
  
  public BaseRequest getRequest(String paramString)
  {
    return null;
  }
  
  public String getTitle()
  {
    return "卡顿信息";
  }
  
  public View getTitleTabView(ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public void initTitleBar(View paramView) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    ((BaseListBlock.BaseListVH)paramViewHolder).a(this.mDataList.get(paramInt), paramInt, this.mExtraTypeInfo);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onBindViewHolder:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("  ");
    localStringBuilder.append(paramViewHolder);
    localStringBuilder.append("  ");
    localStringBuilder.append(this);
    QLog.d("QCircleBlockCheckListBlock", 4, localStringBuilder.toString());
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new BaseListBlock.BaseListVH(new QCircleBlockCheckListBlock.DebugItemView(this, getContext()));
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    super.onInitBlock(paramBundle);
    getBlockContainer().setEnableRefresh(false);
    getBlockContainer().setEnableLoadMore(false);
  }
  
  public void onTitleTabSelectedChanged(View paramView, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleBlockCheckListBlock
 * JD-Core Version:    0.7.0.1
 */