package com.tencent.featuretoggle;

import com.tencent.featuretoggle.models.FeatureTriggered;
import com.tencent.featuretoggle.models.FeatureTypedTriggered;

public class ToggleDataTransfer
{
  private ToggleDataTransfer.StringTransfer a = new ToggleDataTransfer.StringTransfer();
  private ToggleDataTransfer.BooleanTransfer b = new ToggleDataTransfer.BooleanTransfer();
  private ToggleDataTransfer.IntTransfer c = new ToggleDataTransfer.IntTransfer();
  private ToggleDataTransfer.FloatTransfer d = new ToggleDataTransfer.FloatTransfer();
  private ToggleDataTransfer.ListTransfer e = new ToggleDataTransfer.ListTransfer();
  private ToggleDataTransfer.JSONTransfer f = new ToggleDataTransfer.JSONTransfer();
  private ToggleDataTransfer.MapTransfer g = new ToggleDataTransfer.MapTransfer();
  
  private static <T> void b(FeatureTriggered paramFeatureTriggered, FeatureTypedTriggered<T> paramFeatureTypedTriggered)
  {
    paramFeatureTypedTriggered.a(paramFeatureTriggered.a());
    paramFeatureTypedTriggered.a(paramFeatureTriggered.b());
    paramFeatureTypedTriggered.b(paramFeatureTriggered.c());
    paramFeatureTypedTriggered.c(paramFeatureTriggered.e());
    paramFeatureTypedTriggered.b(paramFeatureTriggered.d());
    paramFeatureTypedTriggered.d(paramFeatureTriggered.g());
    paramFeatureTypedTriggered.e(paramFeatureTriggered.h());
  }
  
  public ToggleDataTransfer.JSONTransfer a()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.ToggleDataTransfer
 * JD-Core Version:    0.7.0.1
 */