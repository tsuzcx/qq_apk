package com.tencent.gathererga.taid.ga;

import android.content.Context;
import com.tencent.gathererga.core.ProviderMethodPriority;
import com.tencent.gathererga.core.ProviderResult;
import com.tencent.gathererga.core.TuringProvider;
import com.tencent.gathererga.core.internal.provider.InfoID;
import com.tencent.gathererga.core.internal.provider.ProviderResultImpl;
import com.tencent.gathererga.core.internal.util.GLog;
import com.tencent.turingfd.sdk.ams.ga.ITuringDID;
import com.tencent.turingfd.sdk.ams.ga.TuringDIDService;

public class TuringProviderImpl
  implements TuringProvider
{
  private Context a;
  
  public void a(Context paramContext)
  {
    GLog.d("TuringProviderImpl init");
    this.a = paramContext;
  }
  
  @InfoID(id=1)
  public ProviderResult getAIDTicket(ProviderMethodPriority paramProviderMethodPriority)
  {
    paramProviderMethodPriority = TuringDIDService.getTuringDID(this.a);
    if (paramProviderMethodPriority.getErrorCode() != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("turing did error : ");
      localStringBuilder.append(paramProviderMethodPriority.getErrorCode());
      GLog.d(localStringBuilder.toString());
      return ProviderResultImpl.b(paramProviderMethodPriority.getErrorCode());
    }
    return new ProviderResultImpl(paramProviderMethodPriority.getErrorCode(), paramProviderMethodPriority.getAIDTicket());
  }
  
  @InfoID(id=2)
  public ProviderResult getTAIDTicket(ProviderMethodPriority paramProviderMethodPriority)
  {
    paramProviderMethodPriority = TuringDIDService.getTuringDID(this.a);
    if (paramProviderMethodPriority.getErrorCode() != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("turing did error : ");
      localStringBuilder.append(paramProviderMethodPriority.getErrorCode());
      GLog.d(localStringBuilder.toString());
      return ProviderResultImpl.b(paramProviderMethodPriority.getErrorCode());
    }
    return new ProviderResultImpl(paramProviderMethodPriority.getErrorCode(), paramProviderMethodPriority.getTAIDTicket());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.taid.ga.TuringProviderImpl
 * JD-Core Version:    0.7.0.1
 */