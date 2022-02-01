package com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic;

import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ocd;
import org.jetbrains.annotations.NotNull;
import ozs;
import paa;
import rab;
import rfc;
import rff;
import rir;
import riw;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "topicInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ColumnInfo;", "invoke", "com/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SelectTopicFragment$onCreate$1$1"}, k=3, mv={1, 1, 16})
public final class SelectTopicFragment$onCreate$$inlined$let$lambda$1
  extends Lambda
  implements Function1<ColumnInfo, Unit>
{
  SelectTopicFragment$onCreate$$inlined$let$lambda$1(riw paramriw, FragmentActivity paramFragmentActivity, SelectTopicFragment paramSelectTopicFragment, int paramInt, String paramString)
  {
    super(1);
  }
  
  public final void invoke(@NotNull ColumnInfo paramColumnInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramColumnInfo, "topicInfo");
    QLog.i("SelectTopicFragment", 1, "select topic, topic=" + paramColumnInfo);
    this.$dialog.dismiss();
    Object localObject = ozs.a();
    int i;
    if (localObject != null)
    {
      localObject = new paa().a("uin", ((QQAppInterface)localObject).getCurrentAccountUin());
      if (rab.m())
      {
        i = 1;
        localObject = ((paa)localObject).a("ugc_video_flag", Integer.valueOf(i));
        if (!rab.h()) {
          break label162;
        }
        i = 1;
        label90:
        ocd.a("0X800ADD0", ((paa)localObject).a("ugc_column_flag", Integer.valueOf(i)).a("from_page", Integer.valueOf(this.$from$inlined)).a());
      }
    }
    for (;;)
    {
      rfc.a((List)CollectionsKt.arrayListOf(new String[] { this.$rowKey$inlined }), paramColumnInfo.columnID, (rff)new rir(this, paramColumnInfo));
      return;
      i = 0;
      break;
      label162:
      i = 0;
      break label90;
      QLog.e("SelectTopicFragment", 1, "getQQApp, app == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic.SelectTopicFragment.onCreate..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */