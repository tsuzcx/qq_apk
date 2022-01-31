package com.tencent.gdtad.jsbridge;

import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import qks;
import qkt;
import qku;
import qkw;
import qkx;
import qky;
import qkz;

public class GdtAdPluginFactory
  extends VasWebviewJsPlugin
{
  private static GdtAdPluginFactory jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdPluginFactory;
  GdtAdReportJsCallHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdReportJsCallHandler;
  GdtAppJumpJsCallHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtAppJumpJsCallHandler;
  GdtLoadAdJsCallHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtLoadAdJsCallHandler;
  GdtLocationJsCallHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtLocationJsCallHandler;
  qks jdField_a_of_type_Qks;
  qkt jdField_a_of_type_Qkt;
  qku jdField_a_of_type_Qku;
  qkw jdField_a_of_type_Qkw;
  qkx jdField_a_of_type_Qkx;
  qky jdField_a_of_type_Qky;
  qkz jdField_a_of_type_Qkz;
  
  public static GdtAdPluginFactory a()
  {
    if (jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdPluginFactory == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdPluginFactory == null) {
        jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdPluginFactory = new GdtAdPluginFactory();
      }
      return jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdPluginFactory;
    }
    finally {}
  }
  
  public GdtJsCallHandler a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtAppJumpJsCallHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtAppJumpJsCallHandler = new GdtAppJumpJsCallHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtAppJumpJsCallHandler;
    case 2: 
      if (this.jdField_a_of_type_Qkz == null) {
        this.jdField_a_of_type_Qkz = new qkz();
      }
      return this.jdField_a_of_type_Qkz;
    case 3: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdReportJsCallHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdReportJsCallHandler = new GdtAdReportJsCallHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdReportJsCallHandler;
    case 4: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtLocationJsCallHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtLocationJsCallHandler = new GdtLocationJsCallHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtLocationJsCallHandler;
    case 5: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtLoadAdJsCallHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtLoadAdJsCallHandler = new GdtLoadAdJsCallHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtLoadAdJsCallHandler;
    case 6: 
      if (this.jdField_a_of_type_Qks == null) {
        this.jdField_a_of_type_Qks = new qks();
      }
      return this.jdField_a_of_type_Qks;
    case 7: 
      if (this.jdField_a_of_type_Qku == null) {
        this.jdField_a_of_type_Qku = new qku();
      }
      return this.jdField_a_of_type_Qku;
    case 8: 
      if (this.jdField_a_of_type_Qkw == null) {
        this.jdField_a_of_type_Qkw = new qkw();
      }
      return this.jdField_a_of_type_Qkw;
    case 9: 
      if (this.jdField_a_of_type_Qkt == null) {
        this.jdField_a_of_type_Qkt = new qkt();
      }
      return this.jdField_a_of_type_Qkt;
    case 10: 
      if (this.jdField_a_of_type_Qkx == null) {
        this.jdField_a_of_type_Qkx = new qkx();
      }
      return this.jdField_a_of_type_Qkx;
    }
    if (this.jdField_a_of_type_Qky == null) {
      this.jdField_a_of_type_Qky = new qky();
    }
    return this.jdField_a_of_type_Qky;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtAdPluginFactory
 * JD-Core Version:    0.7.0.1
 */