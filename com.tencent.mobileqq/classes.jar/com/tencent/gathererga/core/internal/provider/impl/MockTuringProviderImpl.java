package com.tencent.gathererga.core.internal.provider.impl;

import android.content.Context;
import com.tencent.gathererga.core.ProviderMethodPriority;
import com.tencent.gathererga.core.ProviderResult;
import com.tencent.gathererga.core.TuringProvider;
import com.tencent.gathererga.core.internal.provider.InfoID;
import com.tencent.gathererga.core.internal.provider.ProviderResultImpl;

public class MockTuringProviderImpl
  implements TuringProvider
{
  private Context a;
  
  public void a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  @InfoID(id=1)
  public ProviderResult getAIDTicket(ProviderMethodPriority paramProviderMethodPriority)
  {
    return new ProviderResultImpl(-999L, "");
  }
  
  @InfoID(id=2)
  public ProviderResult getTAIDTicket(ProviderMethodPriority paramProviderMethodPriority)
  {
    return new ProviderResultImpl(-999L, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.provider.impl.MockTuringProviderImpl
 * JD-Core Version:    0.7.0.1
 */